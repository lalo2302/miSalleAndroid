![](http://i.imgur.com/MvqaIGv.png)

# miSalle

## Índice

[English](./README.md)

* [Presentación](#presentación)
  * [Características](#características)
  * [Prerequisitos](#prerequisitos)
* [Documentación](#documentación)
  * [Análisis](#análisis)
    * [Descripción del problema](#descripción-del-problema)
    * [Impacto al alumno y a la institución](#impacto-al-alumno-y-a-la-institución)
    * [Antecedentes](#antecedentes)
    * [Objetivo](#objetivo)
    * [Alcance](#alcance)
    * [Fuera del alcance](#fuera-del-alcance)
    * [Costo](#costo)
    * [Beneficio](#beneficio)
    * [Futuro](#futuro)
    * [Requerimientos Funcionales](#requerimientos-funcionales)
    * [Requerimientos No Funcionales](#requerimientos-no-funcionales)
    * [Riesgos](#riesgos)
    * [Arquitectura de alto nivel](#arquitectura-de-alto-nivel)
    * [Diagrama de flujo de datos](#diagrama-de-flujo-de-datos)
    * [Análisis de pantallas](#análisis-de-pantallas)
  * [Diseño de sistema](#diseño-de-sistema)
    * [Diagrama de clases](#diagrama-de-clases) (Puede estar desactualizado)
    * [Módulos de arquitectura](#módulos-de-arquitectura)
    * [Paletas de colores](#paletas-de-colores)
    * [Prototipo UI](#prototipo-ui)
* [Agradecimientos](#agradecimientos)

## Presentación

miSalle fue un producto dirigido a los alumnos de la Universidad De La Salle Bajío,
hecho por un alumno, pero el servidor de la app fue bloqueado por la administración de la institución.

En este repositorio encontrarás la aplicación que consume la información de los alumnos. Lamentablemente la aplicación
fue bloqueada por la institución, puedes leer más en el [sitio de miSalle](http://www.misalle.com.mx)

Para ver la parte del servidor que alimenta esta aplicación, referirse a su [repositorio en Github](https://github.com/lalo2302/miSalleScrapper)

Para utilizar esta aplicación necesitarás credenciales que la institución avale. Para cuidar la privacidad y seguridad
de todos los alumnos de la institución, no proporiconaré ninguna credencial, pero puedes experimentar su uso con un demo
en la Google Play Store [aquí](https://play.google.com/store/apps/details?id=monk.com.mx.misalleandroid)

### Características

Con miSalle puedes obtener:

- Información del alumno
- Horario
- Créditos
- Calificaciones 

### Prerequisitos

Para utilizar miSalle necesitarás un dispositivo Android con 5.1 para arriba.

## Documentación

### Análisis

#### Descripción del problema

Los alumnos de la Universidad De La Salle Bajío no tiene una forma natural de consumir su información relevante
a la comunidad. Con natural se refiere a nativo en la plataforma en donde se esté consumiendo.

#### Impacto al alumno y a la institución

**Alumno**

El proceso de consulta e interacción con la universidad será eficaz, aumentando el nivel de comodidad del estudiante de
ser parte de la institución.

**Institución**

Se automatizarán procesos que en la actualidad significan tiempo invertido en su ejecución. El personal podrá dedicar su
tiempo a tareas menos repetitivas y aumentar la productividad de la institución en general.

#### Antecedentes

Al momento del lanzamiento del proyecto para ver:

- Horario
- Calificaciones
- Créditos
- Maestros

Se necesitan los siguientes pasos:

1. Abrir navegador
2. Ir a la página de la salle
3. Ir a la página de la comunidad
4. Iniciar sesión
5. Ir a consulta académica

Al momento del lanzamiento no existía competencia como tal.

#### Objetivo

Crear una solución móvil que sirva de intermediario entre el alumno y la institución

#### Alcance

miSalle será un intermediario entre el actual sistema de la universidad, y los dispositivos móviles del alumno

#### Fuera del alcance

Si se rompe con la relación alumno-universidad, queda fuera del alcance del proyecto

#### Costo

- Recursos monetarios que cueste la insfraestructura
- Recursos humanos
- Tiempo inadvertido

#### Beneficio

- No hay competencia en el mercado, por lo que se podría llegar al 100% del alumnado.
- Se abre la oportunidad de colaborar con la universidad
- Abre la posibilidad de cambiar el esquema de enseñanza de la escuela

#### Futuro

A pesar del alcance que se declaró, se ve a futuro las siguientes características:

- Detalles de créditos
- Plan de estudios
- Vista de horario por semana
- El alumno podrá ir anotando sus faltas para no tener que esperar a que se suban al sistema
- El usuario podrá ser creador de eventos y proyectos para compartir con el alumnado
- Se creará algún tipo de enlance entre los negocios cerca de la universidad, ya que son parte de la comunidad
- Se hará difusión sobre eventos organizados por la universidad
- Se ofrecerá ser un intermediario bancario entre el alumno y la universidad para pagos de colegiaturas, etc...
- Se creará un sistma de evaluación para maestros y materias, generando retroalimentación visible para los alumnos

#### Requerimientos funcionales

1. [x] El usuario inciará sesión con sus credenciales de la universidad
2. [x] El sistema mostrará un horario que sólo recorra las horas de clase del alumno, identificando cada clase con su
nombre y el del profesor
3. [x] El sistema mostrará la siguiente clase del alumno en caso de que exista una
4. [x] El sistema mostrará las calificaciones por parcial del alumno
5. [x] El sistema mostrará la cantidad de créditos culturales, sociales y deportivos que tiene el alumno
6. [x] El sistema mostrará un aviso 5 días antes del día de vencimiento de pago de colegiatura
7. [x] El sistema mostrará las faltas del alumno por materia
8. [x] El sistema mostrará el nombre, matrícula, y carrera del alumno
9. [x] El alumno podrá subir una foto a su información personal

#### Requerimientos no funcionales

1. El sistema consumirá la información de los alumnos a través de web scrapping
2. La aplicación de consumo del alumno será móvil
3. La aplicación móvil deberá existir para Android y iOS, dándole prioridad de tiempo a Android
4. El sistema sólo permitirá el ingreso de alumnos con credenciales de instituciones pertenecientes a la
Universidad De La Salle Bajío
5. La aplicación deberá ser capaz de mostrar la información del alumno sin una conexión a internet

#### Riesgos

##### Bloqueo de ip del scrapper por parte de La Salle

###### Descripción
Al obtener la información del sitio de La Salle por medio de scrapping, fácilmente la institución, al percatarse de la extracción de la información, puede sin ningún problema bloquear el acceso al sitio por medio de la ip.

###### Severidad
**Alta**
Es la principal fuente del sistema

###### Acción
1. En la arquitectura se observa que el scrapper estará en un nivel diferente, hospedado en Heroku. Cada 24 hrs Heroku reinicia los dynos, proporcionándole una nueva ip. En caso de que el bloqueo suceda antes, se puede reiniciar el dyno manualmente.
2. La información al ser semi-estática, se guardará en el dispositivo del usuario, para no depender del sitio de La Salle para el acceso de su información, así en cualquier evento, la interacción de los usuarios ya registrados en el sistema no se verá afectada

##### Cambio de formato en sitio web de La Salle

###### Descripción
El sistema al hacer scrapping al sitio de La Salle, depende del como la información es presentada en el buscador. Si la institución decide cambiar el esquema del html, el scrapper dejaría de funcionar efectivamente

###### Severidad
**Media**
Esto llevaría a rediseñar el scrapper para que satisfaga las necesidades del esquema html de la institución

###### Probabilidad
**Baja**
El sitio está pobremente diseñado, y al parecer fuertemente atado al cómo la información es guardada en su almacén de datos. El rediseño implica un esfuerzo enorme, que la institución no logrará a corto plazo.
También se sabe que en el primer semestre del año, la universidad analiza y distribuye el presupuesto de la institución, poniendo a trabajar el dinero en el segundo semestre. Esto nos da tiempo para crear una base de usuarios solida y para estar listos para el nuevo ingreso en Agosto

###### Acción
Diseñar el sistema de una manera que los cambios del scrapper sean en 1 sólo lugar, sin afectar la funcionalidad de todo lo demás

##### Insuficiencia de fondos ($) para mantener el sistema

###### Descripción
El equipo de trabajo actualmente no cuenta con inversionistas mayores, por lo que el proyecto se está llevando a cabo con recursos propios. Esto significa una limitada disposición de fondos para la contratación de desarrolladores y para pagar servidores

###### Severidad
**Mediana**
En el momento que la demanda económica del proyecto crezca como para no ser capaces de soportar los gastos, significa que la base de usuarios y el tráfico son constantes, consecuentemente el valor del proyecto crece y se puede buscar una manera de financiar el proyecto con bases más sólidas

###### Probabilidad
**Mediana**
El equipo de trabajo no cuenta con la experiencia necesaria para poder calcular el costo del tráfico próximo a generar.

###### Acción
1. Se utilizará el paquete de estudiante que ofrece GitHub para el desarrollo del proyecto
2. Se utilizarán los dominios proporcionados por heroku (~~~.herokuapp.com) para el scrapper y para el api
3. Se generarán ingresos con el modelo de negocio del proyecto

#### Arquitectura de alto nivel

![](img_assets/arquitectura_alto_nivel.JPG)

#### Diagrama de flujo de datos

![](img_assets/diagrama_flujo_datos.JPG)

#### Análisis de pantallas

![](img_assets/analisis1.JPG)

![](img_assets/analisis2.JPG)

![](img_assets/analisis3.JPG)

![](img_assets/analisis4.JPG)

![](img_assets/analisis5.JPG)

![](img_assets/analisis6.JPG)

![](img_assets/analisis7.JPG)

![](img_assets/analisis8.JPG)

![](img_assets/analisis9.JPG)

### Diseño de sistema

#### Diagrama de clases

![](img_assets/diagrama_clases.JPG)

#### Módulos de arquitectura

![](img_assets/arquitectura_detalle.JPG)

#### Paletas de colores

![](img_assets/paleta_colores.JPG)

#### Prototipo UI

![](img_assets/prototipo.JPG)

## Agradecimientos

Un agradecimiento especial a Andrea Hernández De Alba, por su colaboración inicial en el proyecto, proporcionando
el diseño de la interfaz gráfica, así como parte de su desarrollo en la aplicación de Android.
