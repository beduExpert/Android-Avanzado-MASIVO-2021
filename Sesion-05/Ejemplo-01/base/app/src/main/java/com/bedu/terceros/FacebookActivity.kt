package com.bedu.terceros

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bedu.terceros.databinding.ActivityFacebookBinding


class FacebookActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFacebookBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFacebookBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}