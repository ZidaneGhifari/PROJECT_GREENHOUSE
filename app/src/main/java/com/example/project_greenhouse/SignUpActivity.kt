package com.example.project_greenhouse

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.project_greenhouse.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.regex.Pattern

class SignUpActivity : AppCompatActivity() {

    lateinit var binding : ActivitySignUpBinding
    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)

        auth = FirebaseAuth.getInstance()

        binding.textView7.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener {
            val email = binding.inputEmailaddress.text.toString()
            val password = binding.inputPassword.text.toString()

            //Validasi email
            if (email.isEmpty()){
                binding.inputEmailaddress.error = "Email Harus Diisi"
                binding.inputEmailaddress.requestFocus()
                return@setOnClickListener
            }

            //Validasi email tidak sesuai
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.inputEmailaddress.error = "Email Tidak Valid"
                binding.inputEmailaddress.requestFocus()
                return@setOnClickListener
            }

            //Validasi password
            if (password.isEmpty()){
                binding.inputPassword.error = "Password Harus Diisi"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            //Validasi panjang password
            if (password.length < 6){
                binding.inputPassword.error = "Password Minimal 6 Karakter"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            SignUpFirebase(email, password)
        }
    }

    private fun SignUpFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this, "Sign Up Berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, SignInActivity::class.java)
                    startActivity(intent)
                } else{
                    Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun txtLoginListener() {
        textView7.setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }
    }
}