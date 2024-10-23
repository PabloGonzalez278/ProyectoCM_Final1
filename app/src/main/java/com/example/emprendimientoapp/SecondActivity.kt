package com.example.emprendimientoapp


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        // Botón de Login
        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            // Iniciar LoginActivity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        // Botón de Register
        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            // Iniciar RegisterActivity
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Botón de Mostrar Tiendas
        val btnShowStores: Button = findViewById(R.id.btnShowStores)
        btnShowStores.setOnClickListener {
            // Iniciar MapsActivity
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        // Icono de información
        val infoIcon: ImageView = findViewById(R.id.infoIcon)
        infoIcon.setOnClickListener {
            // Podrías mostrar un diálogo con información o redirigir a otra pantalla
        }
    }
}
