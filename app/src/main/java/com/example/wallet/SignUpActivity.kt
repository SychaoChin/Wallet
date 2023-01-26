package com.example.wallet

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.wallet.model.User
import com.google.gson.Gson

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val signup: Button = findViewById(R.id.singUP_Button)
        signup.setOnClickListener {
            val username: EditText = findViewById(R.id.userNameInput)
            val password: EditText = findViewById(R.id.passwordInput)
            val title: EditText = findViewById(R.id.titleInput)
            val phone: EditText = findViewById(R.id.phoneInput)
            val email: EditText = findViewById(R.id.emailInput)


            val user = User(
                1,
                username.text.toString(),
                password.text.toString(),
                title.text.toString(),
                phone.text.toString(),
                email.text.toString()
            )
            saveUser(user)
            intent = Intent (this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun saveUser(user: User) {
        val gson = Gson()
        val json = gson.toJson(user)
        val sharedPref = getSharedPreferences("users_list", Context.MODE_PRIVATE)
        sharedPref.edit().clear()
        sharedPref.edit().putString("users", json).apply()
    }
}