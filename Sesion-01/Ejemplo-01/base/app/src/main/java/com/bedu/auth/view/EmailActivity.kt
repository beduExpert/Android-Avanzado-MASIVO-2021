package com.bedu.auth.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.bedu.auth.databinding.ActivityEmailBinding
import com.bedu.auth.utils.Utility.hideKeyboard

class EmailActivity : Activity() {

    private lateinit var binding: ActivityEmailBinding

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        handleClick()
    }

    private fun handleClick() {

        binding.btnLogin.setOnClickListener {
            it.hideKeyboard()

            binding.btnLogin.visibility = View.GONE
            binding.loading.visibility = View.VISIBLE

            val email = binding.editText.text.toString()
            val password = binding.editText2.text.toString()

            signIn(email, password)
        }
        binding.btnRegister.setOnClickListener {
            it.hideKeyboard()

            binding.btnLogin.visibility = View.GONE
            binding.loading.visibility = View.VISIBLE

            val email = binding.editText.text.toString()
            val password = binding.editText2.text.toString()

            createAccount(email, password)
        }

        binding.editText.doAfterTextChanged {
            val email = binding.editText.text.toString()
            val password = binding.editText2.text.toString()

            binding.btnLogin.isEnabled = email.isNotEmpty() && password.isNotEmpty()
            binding.btnRegister.isEnabled = email.isNotEmpty() && password.isNotEmpty()
        }

        binding.editText2.doAfterTextChanged {
            val email = binding.editText.text.toString()
            val password = binding.editText2.text.toString()

            binding.btnLogin.isEnabled = email.isNotEmpty() && password.isNotEmpty()
            binding.btnRegister.isEnabled = email.isNotEmpty() && password.isNotEmpty()
        }
    }

    private fun createAccount(email: String, password: String) {
        updateUI()
    }

    private fun signIn(email: String, password: String) {
        updateUI()
    }

    private fun sendEmailVerification() {
    }

    private fun updateUI() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.loading.visibility = View.GONE
            binding.btnLogin.visibility = View.VISIBLE
        }, 2000)
    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}