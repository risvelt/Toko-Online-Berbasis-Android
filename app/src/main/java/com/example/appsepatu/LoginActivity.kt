package com.example.appsepatu

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.appsepatu.databinding.ActivityLoginBinding
import com.example.appsepatu.MainActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btnLogin.setOnClickListener{
            val email = binding.etEmaillogin.text.toString()
            val password = binding.etPasswordlogin.text.toString()

            if (email.isEmpty()) {
                binding.etEmaillogin.error = "Email Harus Di isi"
                binding.etEmaillogin.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.etEmaillogin.error = "Email Tidak Valid"
                binding.etEmaillogin.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.etPasswordlogin.error = "Password Harus Di isi"
                binding.etPasswordlogin.requestFocus()
                return@setOnClickListener
            }
            if (password.length < 4) {
                binding.etPasswordlogin.error = "Password Minimal 4 karakter"
                binding.etPasswordlogin.requestFocus()
                return@setOnClickListener
            }

            Loginfirebase(email,password)
        }
    }

    private fun Loginfirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Selamat Datang $email", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

}