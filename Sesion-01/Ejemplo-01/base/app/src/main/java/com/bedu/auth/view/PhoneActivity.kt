package com.bedu.auth.view

import android.app.Activity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.core.widget.doAfterTextChanged
import com.bedu.auth.databinding.ActivityPhoneBinding
import com.bedu.auth.utils.Utility.hideKeyboard


class PhoneActivity : Activity() {

    private lateinit var binding: ActivityPhoneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnContinue.setOnClickListener {
            it.hideKeyboard()

            val phone = binding.edtPhone.text.toString()

            when {
                binding.btnContinue.text == "Resend code" -> {
                    binding.btnContinue.visibility = View.GONE
                    binding.loading.visibility = View.VISIBLE
                    binding.edtCode.text.clear()
                    resendVerificationCode(phone, "resendToken")
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

                    verifyPhoneNumberWithCode("verificationId", code)
                }
            }
        }

        binding.edtPhone.doAfterTextChanged {
            val phone = binding.edtPhone.text.toString()

            binding.btnContinue.isEnabled = phone.isNotEmpty()
        }
    }

    private fun startPhoneNumberVerification(phoneNumber: String) {
        updateUI()
    }

    private fun verifyPhoneNumberWithCode(verificationId: String, code: String) {
        updateUI()
    }

    private fun resendVerificationCode(
        phoneNumber: String,
        token: String
    ) {
        updateUI()
    }
    // [END resend_verification]

    private fun updateUI() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.btnContinue.visibility = View.VISIBLE
            binding.loading.visibility = View.GONE
            binding.edtPhone.visibility = View.VISIBLE
        }, 2000)
    }

    companion object {
        private const val TAG = "PhoneAuthActivity"
    }

}