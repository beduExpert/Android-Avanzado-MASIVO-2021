package com.bedu.auth.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.bedu.auth.databinding.ActivityOptionsBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityOptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOptionsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        handleClick()
    }

    override fun onStart() {
        super.onStart()

    }

    private fun handleClick() {

        binding.btnEmail.setOnClickListener {
            val intent = Intent(this, EmailActivity::class.java)
            startActivity(intent)
        }
        binding.btnPhone.setOnClickListener {
            val intent = Intent(this, PhoneActivity::class.java)
            startActivity(intent)
        }
        binding.btnGoogle.setOnClickListener {
        }
    }



    private fun updateUI() {

    }

    companion object {
        private const val TAG = "GoogleActivity"
        private const val RC_SIGN_IN = 9001
    }

}