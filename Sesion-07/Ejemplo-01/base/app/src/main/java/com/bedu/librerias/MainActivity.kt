package com.bedu.librerias

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.librerias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnToasty.setOnClickListener {
            val intent = Intent(this, ToastyActivity::class.java)
            startActivity(intent)
        }
        binding.btnChart.setOnClickListener {
            val intent = Intent(this, ChartActivity::class.java)
            startActivity(intent)
        }
        binding.btnShortbread.setOnClickListener {
            val intent = Intent(this, ShortbreadActivity::class.java)
            startActivity(intent)
        }
        binding.btnFresco.setOnClickListener {
            val intent = Intent(this, FrescoActivity::class.java)
            startActivity(intent)
        }
    }
}