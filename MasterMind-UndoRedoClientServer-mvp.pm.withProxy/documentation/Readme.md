= Entrega Práctica Obligatoria MasterMind 

Francisco Javier Moreno Moreno <franciscojavier.moreno@alumnos.upm.es>
v1.0, 7 de Diciembre, 2020

:imagesdir: ./images

Documentación del código entregado para la prática de evaluación obligatoria de la
asignatura Patrones de Diseño, perteneciente al curso de **Experto en Arquitectura y Desarrollo Software** (EADS)
(Oct-2020/Mar-2021).

Este documento incluye los diagramas de paquetes y relaciones entre clases que describen
la arquitectura del código que aconpaña a este documento. En este diseño y su correspondiente
implementación sólo se entrega con soporte para interfaz de consola, de acuerdo con los requisitos.

El diseño se puede ampliar para otros interfaces, implementados como un nuevo paquete

Además se utilizan las siguientes técnicas o estrategias para conseguir un código mas robusto:

* **Arquitectura Modelo/Controlador/Vista**, separando las respondabilidades de cada parte de la arquitectura.
* **Distribución en paquetes**. El código común que puede reutilizarse en otros proyectos se ha sacado a un paquete llamado "Utils".

* **Patrón Singleton**: El acceso a la consola se realiza mediante el método instance() de la clase Console, que controla el acceso al recurso.

image::console.svg[]

* **Patrón Memento**: Para la funcionalidad de undo/redo, se ha implementado el patrón memento, que guarda el estado del juego. Dicho estado está compuesto básicamente por las combinaciones propuestas por el usuario. Aunque se podrían recrear a partir de estas, también se guardan los resultados de las evaluaciones de dichas combinaciones contra la combinación secreta y además el número de intentos en el momento de guardado.

Al crear el objeto Memento, se realiza una copia profunda del las listas, para no modificar el estado del juego en futuras interacciones entre el memento y los objetos sujetos a ser restaurados.

El diagrama UML de la implementación se puede dentro del modelo

* **Patrón Command**: 

La utilización de este patrón permite la activación o desactivación de pendiendo del estado del juego de ciertas opciones. Además, permite la extensibilidad de nuevas funcionalidades sobre el juego, añadiendo nuevos comandos sin modificar los ya existentes.

image::command.svg[]

* **Patrón Facade**: La clase _Logic_ disminye la complejidad del sistema mediante una interfaz mas sencilla para acceder a los controladores desde otras partes del código.

* **Patrón Visitor**: La clase UseCaseController proporciona el método accept a sus clases derivadas (StartController, PlayController y ResumeController), y el interface ControllerVisitor que implementa la clase Vista proporciona el método visit para poner en marcha el código del controlador adecuado en cada fase del juego.

image::pkt_mastermind_controllers.svg[]

* **Patrón Proxy**: Para la implementación de la funcionalidad cliente/servidor, se ha utilizado el patrón Proxy, de tal forma que existen dos conjuntos de controladores, dependiendo de si la aplicación se ejecuta en modo StandAlone o en modo Cliente/Servidor.

El paquete _mastermind.distributed_ contiene los controladores proxy que se comunican con el Servidor

image::pkt_mastermind_controllers_proxy.svg[]

El paquete _mastermind.controllers.implementation_ contiene los controladores cuando se utiliza en modo StandAlone:

image::pkt_mastermind_controllers_implementation.svg[]

En el caso de estar siendo ejecutado como Cliente/servidor, los controlladores se encargan de gestionar la comunicación con el modelo, sin contaminarlo. 

Para ello, en el servidor se han implementado una serie de dispatchers de commandos que se ejecutan en respuesta a las peticiones del cliente. 

image::dispatchers.svg[]

== Paquete _Mastermind (Standalone deployment)_

image::pkt_mastermind.svg[]

== Paquete _Mastermind (Client/Server deployment)_

En la parte del Servidor, el software está en un bucle, atendiendo las peticiones que recibe del cliente mediante los dispatchers, de tal forma que estos dispatcher son los que tratan con los controladores y a través de estos, con el modelo. El modelo es agnóstico al uso que se hace de él ya sea desde la ejecución de la aplicación en modo Standalone, como en la implementación del cliente/servidor.

Es al arrancar, cuando se llama al código que crea la lógica, y está dependerá del modo en el que se está ejecutando. En modo Servidor, la lógica instancia los dispatchers, mientras que en modo servidor la lógica instancia los controlladores que trabajan directamente con el modelo (vease LogicImplementation.java vs. LogicImplementationServer.java).

image::pkt_mastermind_distributed.svg[]

== Paquete _mastermind.views_

image::pkt_mastermind_views.svg[]

== Paquete _mastermind.models_

Incluye las clases Memento y Registry, que implementan el patrón Memento.

image::pkt_mastermind_models.svg[]

Francisco Javier Moreno Moreno <francisco.javier.moreno@ericsson.com>, <franciscojavier.moreno@alumnos.upm.es>
