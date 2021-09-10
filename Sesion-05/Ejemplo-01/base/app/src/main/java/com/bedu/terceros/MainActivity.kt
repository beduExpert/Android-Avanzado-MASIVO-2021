package com.bedu.terceros

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.terceros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnFacebook.setOnClickListener {
            val intent = Intent(this, FacebookActivity::class.java)
            startActivity(intent)
        }
        binding.btnSpotify.setOnClickListener {
            val intent = Intent(this, SpotifyActivity::class.java)
            startActivity(intent)
        }
        binding.btnConekta.setOnClickListener {
            val intent = Intent(this, ConektaActivity::class.java)
            startActivity(intent)
        }

    }
}