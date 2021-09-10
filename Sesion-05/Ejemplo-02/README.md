# Ejemplo 02: Agregando multidex

## Objetivo

* Implementar multidex en un proyecto base Android.

## Desarrollo

Como se mencionó en el postwork de la sesión 3, cuando agregamos varias librerías se corre el riesgo de llegar al límite de clases permitido en los proyectos de Android.

1. Nos dirigimos al Gradle del módulo y agregamos la siguiente línea dentro de defaultConfig:

    ```gradle
    multiDexEnabled = true
    ```

2. En el mismo **Gradle** agregamos la siguiente dependencia:

    ```gradle
    implementation 'androidx.multidex:multidex:2.0.1'
    ```

3. Ejecutamos el proyecto base con Android Studio. Debería de funcionar igual que antes, sólo que ahora tiene un límite mayor de clases permitidas.

</br>

[Siguiente ](../Ejemplo-03/README.md)(Ejemplo 3)