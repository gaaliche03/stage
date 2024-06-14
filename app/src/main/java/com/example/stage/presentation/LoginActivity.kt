package com.example.stage.presentation

import android.content.Intent
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.stage.R
import com.example.stage.presentation.viewmodel.AuthVM
import com.example.stage.utils.accountValidation
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    lateinit var authVM: AuthVM
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authVM = AuthVM()

        val txtEmail = findViewById<EditText>(R.id.email)
        val txtPassword = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)

        val donthave = findViewById<TextView>(R.id.donthave)

        login.setOnClickListener {
            if (accountValidation(txtEmail.text.toString(),txtPassword.text.toString())) {
                authVM.login(txtEmail.text.toString(), txtPassword.text.toString()).observeForever {
                    if (it) {
                        val intent1 = Intent(this@LoginActivity, SignUpActivity::class.java)
                        startActivity(intent1)
                    }
                }
            }
        }

        donthave.setOnClickListener {
            val intent1 = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent1)
            /*auth = Firebase.auth

        auth.createUserWithEmailAndPassword("test@test.com", "password")
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d("Login with firebase", "createUserWithEmail:success")
                    val user = auth.currentUser

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w("Create user", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext,
                        "Authentication failed.",
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }*/


        }
    }
}