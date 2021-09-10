package com.bedu.terceros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.terceros.databinding.ActivitySpotifyBinding

class SpotifyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySpotifyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySpotifyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}
