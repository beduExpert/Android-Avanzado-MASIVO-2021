package com.bedu.librerias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.librerias.databinding.ActivityShortbreadBinding

class ShortbreadActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShortbreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityShortbreadBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}