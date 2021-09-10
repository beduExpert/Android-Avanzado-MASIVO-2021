# Reto 02: Reproduciendo contenido

## Objetivo

* Adaptar el código de un proyecto base Android para agregar la función de reproducción de contenido de Spotify, con su SDK, mediante sus URI´s: podcast, canción, álbum, artista, playlist.

## Desarrollo

En el ejemplo 03 aprendimos a reproducir el contenido previamente cargado en Spotify. 

La interfaz empleada tiene una cinta con varias opciones, y al presionar las opciones debe reproducirse el contenido que indica. Por ejemplo, si se hace clic en Álbum la acción debería reproducir un álbum. “Puedes elegir el contenido que tu quieras”. 

A continuación te mostramos algunos puntos importantes, y es necesario que adaptes el código para sumar la función de reproducción mediante los identificadores de Spotify:

</br>

- Puedes utilizar assertAppRemoteConnected para indicar el contenido a reproducir. El código es similar al de la función onSkipPreviousButtonClicked(), sólo que sse necesita pasar el URI del contenido deseado en la opción .play(uri).

- Para obtener el URI dentro de Spotify, puedes hacer clic en el contenido y seleccionar la opción de compartir, seguido de copiar el enlace.

  - Una vez copiado pegas el enlace en algún editor de texto: https://open.spotify.com/track/2Foc5Q5nqNiosCNqttzHof?si=8292b1e9b6174ce9

    - Una vez pegado el enlace, se copia la cadena que se encuentra después de la diagonal, que indica qué tipo de contenido es: **“track, album, artist, playlist, show”**, hasta antes del signo **“?”**. 
    
      Resulta de la siguiente manera: **2Foc5Q5nqNiosCNqttzHof**

    - Ahora se añade la cadena **spotify**. Esto es seguido del tipo de contenido con dos puntos, y por último la cadena del punto previo. 
    
      En este ejemplo la cadena resultaría así: spotify:track:**2Foc5Q5nqNiosCNqttzHof**

</br>
</br>

<details>
    <summary>Solución</summary>

  Variables
  ```kotlin
  object SpotifySampleContexts {
    const val TRACK_URI = "spotify:track:2Foc5Q5nqNiosCNqttzHof"
    const val ALBUM_URI = "spotify:album:50oWFJ0mDEeMa74ElsdAp3"
    const val ARTIST_URI = "spotify:artist:3WrFJ7ztbogyGnTHbHJFl2"
    const val PLAYLIST_URI = "spotify:playlist:37i9dQZF1E8OchtdOZK7KR"
    const val PODCAST_URI = "spotify:show:5pMNIoy0SoxMBiWZ1qtk4h"
  }
  ```

  Funciones
  ```kotlin
  fun onPlayPodcastButtonClicked(notUsed: View) {
    playUri(PODCAST_URI)
  }

  fun onPlayTrackButtonClicked(notUsed: View) {
    playUri(TRACK_URI)
  }

  fun onPlayAlbumButtonClicked(notUsed: View) {
    playUri(ALBUM_URI)
  }

  fun onPlayArtistButtonClicked(notUsed: View) {
    playUri(ARTIST_URI)
  }

  fun onPlayPlaylistButtonClicked(notUsed: View) {
    playUri(PLAYLIST_URI)
  }
  ```

  Función PlayUri
  ```kotlin
  private fun playUri(uri: String) {
    assertAppRemoteConnected()
      .playerApi
      .play(uri)
      .setResultCallback { logMessage(getString(R.string.command_feedback, "play")) }
      .setErrorCallback(errorCallback)
  }
  ```

  **¡Perfecto!** Ahora tu app reproduce el contenido que agregaste desde los Uri’s de Spotify.

</details>

</br>
</br>

[Siguiente ](../Postwork/README.md)(Postwork)
