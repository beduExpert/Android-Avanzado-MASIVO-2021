package com.bedu.ar

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.ar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnFaces.setOnClickListener {
//            val intent = Intent(this, Activity::class.java)
//            startActivity(intent)
        }
        binding.btnModels.setOnClickListener {
//            val intent = Intent(this, Activity::class.java)
//            startActivity(intent)
        }
        binding.btnIntents.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }
    }
}