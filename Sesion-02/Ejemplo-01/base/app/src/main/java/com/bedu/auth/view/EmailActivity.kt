package com.bedu.auth.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import com.bedu.auth.R
import com.bedu.auth.databinding.ActivityEmailBinding
import com.bedu.auth.utils.Utility
import com.bedu.auth.utils.Utility.hideKeyboard
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.lang.Exception

class EmailActivity : Activity() {

    private lateinit var binding: ActivityEmailBinding

    private lateinit var auth: FirebaseAuth

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

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
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user, null)
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    updateUI(null, task.exception)
                }
            }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(user, null)
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    task.exception?.let { updateUI(null, it) }
                }
            }
    }

    private fun sendEmailVerification() {
    }

    private fun updateUI(user: FirebaseUser?, exception: Exception?) {
        if (exception != null) {
            binding.loading.visibility = View.GONE
            binding.btnLogin.visibility = View.VISIBLE
            Utility.displaySnackBar(binding.root, exception.message.toString(), this, R.color.red)
        } else {
            Utility.displaySnackBar(binding.root, "Login was successful", this, R.color.green)
            binding.loading.visibility = View.GONE
            binding.btnLogin.visibility = View.VISIBLE
        }
    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}