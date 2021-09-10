package com.bedu.librerias

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.librerias.databinding.ActivityFrescoBinding

class FrescoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFrescoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFrescoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}