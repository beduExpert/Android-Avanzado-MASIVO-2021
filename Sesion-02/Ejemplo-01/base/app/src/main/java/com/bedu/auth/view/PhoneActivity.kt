package com.bedu.auth.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.bedu.auth.R
import com.bedu.auth.databinding.ActivityPhoneBinding
import com.bedu.auth.utils.Utility
import com.bedu.auth.utils.Utility.hideKeyboard
import com.google.firebase.FirebaseException
import com.google.firebase.FirebaseTooManyRequestsException
import com.google.firebase.auth.*
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit


class PhoneActivity : Activity() {

    private lateinit var binding: ActivityPhoneBinding

    //Declaramos las variables
    private lateinit var auth: FirebaseAuth

    private var storedVerificationId: String? = ""
    private lateinit var resendToken: PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = Firebase.auth

        binding.btnContinue.setOnClickListener {
            it.hideKeyboard()

            val phone = binding.edtPhone.text.toString()

            when {
                binding.btnContinue.text == "Resend code" -> {
                    binding.btnContinue.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                    binding.edtCode.text.clear()
                    resendVerificationCode(phone, resendToken)
                    binding.btnContinue.text = "Continue"
                }
                binding.edtPhone.visibility == View.VISIBLE -> {
                    binding.btnContinue.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                    binding.edtPhone.visibility = View.INVISIBLE

                    startPhoneNumberVerification(phone)
                }
                binding.edtCode.text.isNotEmpty() -> {
                    binding.btnContinue.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                    binding.edtCode.visibility = View.GONE

                    val code = binding.edtCode.text.toString()

                    storedVerificationId?.let { it1 -> verifyPhoneNumberWithCode(it1, code) }
                }
            }
        }

        binding.edtPhone.doAfterTextChanged {
            val phone = binding.edtPhone.text.toString()

            binding.btnContinue.isEnabled = phone.isNotEmpty()
        }

        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            override fun onVerificationCompleted(credential: PhoneAuthCredential) {
                Log.d(TAG, "onVerificationCompleted:$credential")
                signInWithPhoneAuthCredential(credential)
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Log.w(TAG, "onVerificationFailed", e)

                binding.edtPhone.visibility = View.VISIBLE
                binding.btnContinue.visibility = View.VISIBLE
                binding.loading.visibility = View.GONE

                when (e) {
                    is FirebaseAuthInvalidCredentialsException -> {
                        // Invalid request
                        Utility.displaySnackBar(
                            binding.root,
                            "Invalid request",
                            this@PhoneActivity,
                            R.color.red
                        )
                    }
                    is FirebaseTooManyRequestsException -> {
                        // The SMS quota for the project has been exceeded
                        Utility.displaySnackBar(
                            binding.root,
                            "The SMS quota for the project has been exceeded",
                            this@PhoneActivity,
                            R.color.red
                        )
                    }
                    else -> {
                        Utility.displaySnackBar(
                            binding.root,
                            e.message.toString(),
                            this@PhoneActivity,
                            R.color.red
                        )
                    }
                }
            }

            override fun onCodeSent(
                verificationId: String,
                token: PhoneAuthProvider.ForceResendingToken
            ) {
                Log.d(TAG, "onCodeSent:$verificationId")

                binding.btnContinue.visibility = View.VISIBLE
                binding.edtCode.visibility = View.VISIBLE
                binding.loading.visibility = View.GONE

                Utility.displaySnackBar(
                    binding.root,
                    "Code sent",
                    this@PhoneActivity,
                    R.color.green
                )

                storedVerificationId = verificationId
                resendToken = token
            }
        }
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")

                    val user = task.result?.user
                    updateUI(user, null)
                } else {
                    // Sign in failed, display a message and update the UI
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    if (task.exception is FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid

                        binding.loading.visibility = View.GONE
                        binding.btnContinue.visibility = View.VISIBLE
                        binding.btnContinue.text = "Resend code"

                        Utility.displaySnackBar(
                            binding.root,
                            "The verification code entered was invalid",
                            this@PhoneActivity,
                            R.color.red
                        )
                    } else {
                        task.exception?.let { updateUI(null, it) }
                    }
                    // Update UI
                }
            }
    }

    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
        val credential = PhoneAuthProvider.getCredential(verificationId, code)
        signInWithPhoneAuthCredential(credential)
    }

    private fun resendVerificationCode(
        phoneNumber: String,
        token: PhoneAuthProvider.ForceResendingToken?
    ) {
        val optionsBuilder = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(phoneNumber)       // Phone number to verify
            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
            .setActivity(this)                 // Activity (for callback binding)
            .setCallbacks(callbacks)          // OnVerificationStateChangedCallbacks
        if (token != null) {
            optionsBuilder.setForceResendingToken(token) // callback's ForceResendingToken
        }
        PhoneAuthProvider.verifyPhoneNumber(optionsBuilder.build())
    }
    // [END resend_verification]

    private fun updateUI(user: FirebaseUser?, exception: Exception?) {
        binding.edtPhone.visibility = View.VISIBLE
        if (exception != null) {
            binding.loading.visibility = View.GONE
            binding.btnContinue.visibility = View.VISIBLE
            Utility.displaySnackBar(binding.root, exception.message.toString(), this, R.color.red)
        } else {
            Utility.displaySnackBar(binding.root, "Login was successful", this, R.color.green)
            binding.loading.visibility = View.GONE
            binding.btnContinue.visibility = View.VISIBLE
        }
    }

    companion object {
        private const val TAG = "PhoneAuthActivity"
    }

}