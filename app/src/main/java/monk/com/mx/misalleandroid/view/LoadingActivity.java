package monk.com.mx.misalleandroid.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import monk.com.mx.misalleandroid.R;
import monk.com.mx.misalleandroid.presenter.LoadingPresenter;

/**
 * Created by edago on 7/2/17.
 */
public class LoadingActivity extends AppCompatActivity {

    private LoadingPresenter loadingPresenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loading);
        String matricula = getIntent().getStringExtra("matricula");
        String password = getIntent().getStringExtra("password");
        Integer sistema = getIntent().getIntExtra("sistema", 0);
        loadingPresenter = new LoadingPresenter(this, matricula, password, sistema);

        loadingPresenter.LoadInformation();
    }

    public void onSuccessfulLoading(){
        Intent intent = new Intent(LoadingActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void onErrorLoading(String error) {
        Intent intent = new Intent(LoadingActivity.this, LoginActivity.class);
        intent.putExtra("error", error);
        startActivity(intent);
        finish();
    }
}
