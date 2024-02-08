# APIPeliculeros - Manual

## Descripción

Esta API proporciona un sistema automatizado para que una serie de empleados propongan contenidos audiovisuales (películas o series), éstos sean votados, y finalmente se obtenga como resultado el empleado ganador, con el contenido de mayor puntuación.

## Instalación

Para la puesta en funcionamiento de la base de datos, será necesario levantar el servicio de docker proporcionado a través del archivo docker-compose.yml proporcionado.

Para la ejecución de la aplicación, es necesario compilar el código (build) y ejecutar el paquete resultante (jar o war). También es posible arrancar la aplicación a través de un IDE ejecutándolo para que éste se encargue de compilar y ejecutar.

Una vez arrancada la base de datos y la aplicación, accederemos a través de la dirección http://localhost:4000 (el puerto puede ser configurado en el archivo application.properties).

## Gestión de empleados

| Metodo | Url            | Descripción                                                        |
| ------ | -------------- | ------------------------------------------------------------------ |
| GET    | /empleado      | Devuelve la lista completa de empleados                            |
| POST   | /empleado      | Inserta el empleado proporcionado en formato JSON                  |
| GET    | /empleado/{id} | Devuelve el empleado correspondiente a esa id                      |
| PUT    | /empleado/{id} | Modifica los datos completos del empleado correspondiente a esa id |
| DELETE | /empleado/{id} | Elimina el empleado correspondiente a esa id                       |

## Gestión de contenidos

| Metodo | Url                                                          | Descripción                                                                         |
| ------ | ------------------------------------------------------------ | ----------------------------------------------------------------------------------- |
| GET    | /contenido                                                   | Devuelve la lista completa de contenidos                                            |
| GET    | /contenido/peliculas                                         | Devuelve la lista completa de películas                                             |
| GET    | /contenido/series                                            | Devuelve la lista completa de series                                                |
| GET    | /contenido?genero={genero}&puntuacion={puntuacion}&año={año} | Devuelve la lista completa de contenidos, filtradas por genero, puntuación y/o año. |
| POST   | /contenido                                                   | Inserta el contenido proporcionado en formato JSON                                  |
| GET    | /contenido/{id}                                              | Devuelve el contenido correspondiente a esa id                                      |
| PUT    | /contenido/{id}                                              | Modifica los datos completos del contenido correspondiente a esa id                 |
| DELETE | /contenido/{id}                                              | Elimina el contenido correspondiente a esa id                                       |
| PATCH  | /contenido/{id}                                              | Modifica la puntuación (nota media) del contenido correspondiente a esa id          |
| GET    | /contenido/ganador                                           | Devuelve el ganador, con el título del contenido y su puntuación                    |

