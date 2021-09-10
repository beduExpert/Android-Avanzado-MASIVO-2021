# Ejemplo 01: Implementar Firebase Authentication

## Objetivo

* Implementar y configurar Firebase Authentication en un proyecto base.

## Desarrollo

A partir de un proyecto de Android previamente creado se implementará el BaaS de Firebase Authentication para integrar sus servicios de registro e inicio de sesión.

Usaremos el [Proyecto base](./base) y le modificaremos lo que se requiera. Para hacerlo realiza los siguientes pasos:

1. Ejecutamos el proyecto base con Android Studio. Este desplegará la siguiente interfaz.


    <img src="assets/01.png" width="50%"/>

2. Ahora, agregaremos las librerías de Firebase. Para ello hacemos clic en la siguiente ruta: **Tools -> Firebase**

    <img src="assets/02.png" width="50%"/>

3. El resultado será la siguiente ventana. Es necesario identificar la opción de Authentication, hacer clic en ella, y después hacer clic en la tercera opción, enlistada como **Authentication using a custom authentication system**.

    <img src="assets/03.png" width="60%"/>

4. Aparecerá la siguiente ventana. Se debe hacer clic en **Connect to Firebase**. 

    <img src="assets/04.png" width="60%"/>

    <img src="assets/05.png" width="60%"/>

5. El resultado del botón abrirá el navegador. En la siguiente ventana debe seleccionarse el proyecto (el cual denominamos Bedu), y posteriormente es necesario hacer clic en **Conectar**.

    <img src="assets/06.png" width="60%"/>

6. Listo, hasta este paso la app ya se encuentra conectada a Firebase.

    <img src="assets/07.png" width="70%"/>

7. Ahora debe seguirse la ruta hasta el paso 3. Ahí debe seleccionarse **Add the Firebase Authentication SDK to your app** y luego se aceptan los cambios. 

    <img src="assets/08.png" width="60%"/>

    Esto Agrega *Play Services y Auth*

    <img src="assets/09.png" width="60%"/>

8. Ahora debemos dirigirnos a Firebase Console y activar **Authentication**.

    <img src="assets/10.png" width="60%"/>



¡Felicidades! Ya implementaste Firebase Authentication en tu proyecto Android.

</br>

[Siguiente ](../Ejemplo-02/README.md)(Ejemplo 2)
