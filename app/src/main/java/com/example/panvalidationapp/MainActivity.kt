package com.example.panvalidationapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var etPan: EditText
    lateinit var etPincode: EditText
    lateinit var btnValidate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPan = findViewById(R.id.etPan)
        etPincode = findViewById(R.id.etPincode)
        btnValidate = findViewById(R.id.btnValidate)

        btnValidate.setOnClickListener {
            validateFields()
        }
    }

    private fun validateFields() {

        val pan = etPan.text.toString().trim()
        val pincode = etPincode.text.toString().trim()

        // i) Check Empty Fields
        if (pan.isEmpty() || pincode.isEmpty()) {
            Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
            return
        }

        // ii) PAN: 10 character Alphanumeric
        if (!pan.matches(Regex("^[A-Za-z0-9]{10}$"))) {
            etPan.error = "PAN must be 10 alphanumeric characters"
            return
        }

        // iii) Pincode: Exactly 6 digits
        if (!pincode.matches(Regex("^\\d{6}$"))) {
            etPincode.error = "Pincode must be exactly 6 digits"
            return
        }

        Toast.makeText(this, "Validation Successful", Toast.LENGTH_SHORT).show()
    }
}