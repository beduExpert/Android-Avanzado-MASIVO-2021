package com.bedu.ar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.ar.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}