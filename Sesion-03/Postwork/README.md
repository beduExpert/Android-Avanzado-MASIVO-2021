# Postwork 3 - Nueva API y definición de proyecto

## Objetivo

- Modificar un proyecto base de Android para implementar una API que aún no tiene agregada.
- Definir las funciones generales del proyecto Android Avanzado.

## Desarrollo

En los ejemplos de esta sesión aprendimos la inyección de dependencias con y sin Dagger Hilt. Para el Postwork 03 queremos complementar lo aprendido.

La inyección de dependencias le proporciona a tu app las siguientes ventajas:

- **Reutilización de clases y desacoplamiento de dependencias.** Es más fácil cambiar las implementaciones de una dependencia. Se mejora la reutilización de código debido a la inversión del control, y las clases ya no controlan cómo se crean sus dependencias, sino que funcionan con cualquier configuración.

- **Facildad de refactorización.** Las dependencias se convierten en una parte verificable de la superficie de la API, por lo que pueden verificarse durante el tiempo de creación de objetos o el tiempo de compilación, en lugar de ocultarse como detalles de implementación.

- **Facilidad de prueba.** Una clase no administra sus dependencias, por lo que cuando la pruebas es posible pasar diferentes implementaciones para probar todos los casos diferentes.

</br>

### Indicaciones generales:
1. Modifica el proyecto base de la sesión para que implemente alguna API de tu preferencia. A continuación se comparten algunas API’s que puede implementar:
    - REQ | RES --> [URL](https://reqres.in/)
    - Pokémon API --> [URL](https://pokeapi.co/)
    - Digimon API --> [URL](https://digimon-api.vercel.app/index.html)

    </br>

    > Nota: La URL base está declarada en el Gradle del proyecto.

</br>

2. Ha llegado la hora de **seleccionar el proyecto con el que trabajarás** el resto de las sesiones, y que sería candidato a presentar como proyecto final. Para elegir te recomendamos darte el tiempo de pensarlo.

    Hasta ahora sabes cómo trabajar con usuarios el **“Login** y registro” gracias a **Firebase Auth**, así como optimizar la gestión de errores con **Crashlytics**, y en esta sesión aprendiste cómo realizar la inyección de dependencias con **Dagger Hilt**.

    Ten presentes los temas instruidos y los temas restantes del módulo, pues debes elegir algún proyecto en el que puedas implementarlos. 

    Existe la probabilidad de que en el proyecto no sea posible implementar todas las dependencias, ya que existe un límite de clases a emplear. Ahora puedes entender por qué algunas empresas tienen varias apps, como Facebook “Messenger” y Facebook “App”. No te preocupes por ese tema por ahora, pues hay una forma de actuar ante ese escenario. Ponemos a tu disposición la documentación que habla del multidex por si deseas echar un vistazo. 

    [Haz clic aquí para consultar la documentación de cómo habilitar multidex.](https://developer.android.com/studio/build/multidex?hl=es)

</br>

[Regresar ](../README.md)(Sesión 03)

[Siguiente ](../../Sesion-04/README.md)(Sesión 04)