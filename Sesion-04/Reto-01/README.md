# Reto 01: Agregando transiciones

## Objetivo

* Agregar transiciones al entrar y salir de las pantallas de un proyecto Android determinado.

## Desarrollo

En el ejemplo 03 se agregó la navegación por medio del **id** asignado en el gráfico de navegación. El objetivo de este reto es asignar animaciones que serán mostradas cada vez que naveguemos entre las pantallas de la app del mismo ejemplo.
Es posible definir animaciones en la carpeta anim de los recursos. A continuación se presenta el código XML de algunas animaciones.

</br>

slide_in_right.xml
```Kotlin
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">

  <translate android:fromXDelta="100%" android:toXDelta="0%"
              android:fromYDelta="0%" android:toYDelta="0%"
              android:duration="700"/>
</set>
```

</br>

slide_out_left.xml
```Kotlin
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">

  <translate android:fromXDelta="0%" android:toXDelta="-100%"
              android:fromYDelta="0%" android:toYDelta="0%"
              android:duration="700"/>
</set>
```

</br>

slide_in_left.xml
```Kotlin
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">

  <translate android:fromXDelta="-100%" android:toXDelta="0%"
              android:fromYDelta="0%" android:toYDelta="0%"
              android:duration="700"/>
</set>
```

</br>

slide_out_right.xml
```Kotlin
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android">

  <translate android:fromXDelta="0%" android:toXDelta="100%"
              android:fromYDelta="0%" android:toYDelta="0%"
              android:duration="700"/>
</set>
```

Para resolver el reto 1 sigue las instrucciones expuestas a continuación.

1. Crea **navOptions** con las animaciones. Puedes utilizar las presentadas en este reto o agregar las tuyas.
  
    > Nota: las animaciones son asignadas según la transición que tienen definida; considera las siguientes opciones: enter, exit, popEnter y popExit.

2. Agregar **navOptions** al evento del botón **navigate**. 

</br>
</br>

<details>
    <summary>Solución 1</summary>

  ```Kotlin
  val options = navOptions {
      anim {
          enter = R.anim.slide_in_right
          exit = R.anim.slide_out_left
          popEnter = R.anim.slide_in_left
          popExit = R.anim.slide_out_right
      }
  }
  ```

</details>

</br>

<details>
    <summary>Solución 2</summary>
  
  ```Kotlin
  val button = view.findViewById<Button>(R.id.navigate_destination_button)
  button?.setOnClickListener {
      findNavController().navigate(R.id.flow_step_one_dest, null, options)
  }
  ```
</details>

</br>
</br>

[Siguiente ](../Reto-02/README.md)(Reto 2)
