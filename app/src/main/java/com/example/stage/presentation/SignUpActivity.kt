package com.example.stage.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.stage.R
import com.example.stage.presentation.viewmodel.AuthVM
import com.example.stage.utils.accountValidation
import com.example.stage.utils.registerValidation
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    lateinit var authVM: AuthVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        authVM = AuthVM()

        val txtUsername = findViewById<EditText>(R.id.username)
        val txtEmail = findViewById<EditText>(R.id.email)
        val txtPassword = findViewById<EditText>(R.id.password)
        val txtConfirmPassword = findViewById<EditText>(R.id.confirm_password)
        val login = findViewById<Button>(R.id.sign)

        val have = findViewById<TextView>(R.id.have)

        login.setOnClickListener {
            if (registerValidation(txtUsername.text.toString(),txtEmail.text.toString(), txtPassword.text.toString(),txtConfirmPassword.text.toString())) {
                authVM.login(txtEmail.text.toString(), txtPassword.text.toString()).observeForever {
                    if (it) {
                        val intent1 = Intent(this@SignUpActivity, LoginActivity::class.java)
                        startActivity(intent1)
                    }
                }
            }

            have.setOnClickListener {
                val intent2 = Intent(this@SignUpActivity, LoginActivity::class.java)
                startActivity(intent2)

            }
        }
    }
}