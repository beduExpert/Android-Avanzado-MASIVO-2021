
# :wave: Sesión 03: Dependencias - Simplifica el código

## 🎯  Objetivo de la sesión:

- Formular el código de la app con dependencias manuales o desde Dagger Hilt para construir una app con una arquitectura sólida.

## 🎯 Qué aprenderán

- Creación de un proyecto Android con y sin la inyección de dependencias.
- Implementación de diversas herramientas para inyección de dependencias.
- Implementación de Dagger Hilt en proyecto de app Android.

## ⚙ Requisitos

+ Revisión previa del Prework de la sesión.
+ Android Studio.

## 🎩 Desarrollo

En esta sesión aprenderemos la inyección de dependencias, o DI, técnica frecuente en programación y adecuada para el desarrollo de Android que es la base de una arquitectura sólida de apps.

Al programar una app las clases suelen requerir referencias a otras clases. Por ejemplo, una clase Car podría necesitar una referencia a una clase Engine. A estas clases se les denomina dependencias. En el mismo ejemplo, la clase Car necesita una instancia de la clase Engine, de la que depende para ejecutarse.

En ese sentido, una clase puede obtener un objeto que necesita mediante alguna de las siguientes tres maneras:
1. La clase construye la dependencia que necesita. En el ejemplo anterior, Car crea e inicializa su propia instancia de Engine.
2. La clase la toma de otro lugar. Algunas API de Android, como los métodos get de Context y getSystemService(), funcionan de esta forma.
3. La clase la recibe como parámetro. La app puede proporcionar estas dependencias cuando se construye la clase, o pasarlas a las funciones que necesitan cada dependencia. En el ejemplo anterior, el constructor Car recibe Engine como parámetro.

En general, implementar la inyección de dependencias suma las siguientes ventajas:
- Reutilización de código.
- Facilidad de refactorización.
- Facilidad de prueba.

</br>

## 📂 Organización de la clase

- [Ejemplo 01: Dependencias manuales](./Ejemplo-01/README.md)
- [Ejemplo 02: Implementar Dagger Hilt](./Ejemplo-02/README.md)
    - [Reto 01: Agregar dependencias](./Reto-01/README.md)
- [Ejemplo 03: Consumir API](./Ejemplo-03/README.md)
    - [Reto  02: Nuevo módulo](./Reto-02/README.md)
- [Postwork: Nueva API y definición de proyecto](./Postwork/README.md)