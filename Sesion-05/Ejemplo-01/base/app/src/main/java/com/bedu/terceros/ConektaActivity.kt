package com.bedu.terceros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.terceros.databinding.ActivityConektaBinding

class ConektaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConektaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityConektaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}