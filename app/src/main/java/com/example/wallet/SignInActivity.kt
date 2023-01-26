package com.example.wallet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.wallet.model.User
import com.google.gson.Gson

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val signUp : TextView = findViewById(R.id.singUPP_Button)
        signUp.setOnClickListener{
            intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }

        val sharedPref = getSharedPreferences("users_list", Context.MODE_PRIVATE)

        val button : Button = findViewById(R.id.singIN_Button)
        button.setOnClickListener{
            val username : EditText = findViewById(R.id.emailPhoneInput)
            val pass : EditText = findViewById(R.id.passwordInput)
            val gson = Gson()
            val json = sharedPref.getString("users", "")
            val user = gson.fromJson(json, User::class.java)

            if (user.username == username.text.toString() && user.password == pass.text.toString()){
                intent = Intent(this, MainActivity::class.java)
                //intent.putExtra("user", user )
                startActivity(intent)
            }
            else{
                Toast.makeText(this, "wrong info", Toast.LENGTH_SHORT).show()
            }

        }
    }
}