package com.bedu.librerias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.librerias.databinding.ActivityToastyBinding

class ToastyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToastyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityToastyBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}