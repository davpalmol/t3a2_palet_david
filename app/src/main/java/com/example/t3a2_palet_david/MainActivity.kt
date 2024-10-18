package com.example.t3a2_palet_david

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.t3a2_palet_david.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btEntrar.setOnClickListener {
            //Obtindre el dni
            val dni = binding.textFieldDNI.text.toString().trim()
            val contrasenya = binding.textFieldPass.text.toString().trim()

            if (dni.isEmpty()) {
                binding.layaoutDNI.error = "Error"
            } else {
                binding.layaoutDNI.error = null;
            }

            if (contrasenya.isEmpty()) {
                binding.layaoutPass.error = "Error"
            } else {
                binding.layaoutPass.error = null
            }

            if (dni.isNotEmpty() && contrasenya.isNotEmpty()) {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("USER_DNI", dni)
                startActivity(intent)

            }


        }

        binding.btSalir.setOnClickListener {
            finishAffinity()
        }

        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}