package com.assignments.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var generatedOtp: String? = null // Store the generated OTP

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Reference views
        val otpTextView: TextView = findViewById(R.id.otpTextView)
        val generateOtpButton: Button = findViewById(R.id.generateOtpButton)
        val inputOtpEditText: EditText = findViewById(R.id.inputOtpEditText)
        val verifyOtpButton: Button = findViewById(R.id.verifyOtpButton)

        // Generate OTP button logic
        generateOtpButton.setOnClickListener {
            generatedOtp = generateOtp(6) // Generate a 6-digit OTP
            otpTextView.text = "Generated OTP: $generatedOtp"
            Toast.makeText(this, "OTP Generated: $generatedOtp", Toast.LENGTH_SHORT).show()
        }

        // Verify OTP button logic
        verifyOtpButton.setOnClickListener {
            val enteredOtp = inputOtpEditText.text.toString()
            if (enteredOtp == generatedOtp) {
                Toast.makeText(this, "OTP Verified Successfully!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid OTP. Please try again.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Function to generate a numeric OTP of a given length
    private fun generateOtp(length: Int): String {
        return (1..length).map { Random.nextInt(0, 10) }.joinToString("")
    }
}
