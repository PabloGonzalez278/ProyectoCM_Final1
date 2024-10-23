package com.example.emprendimientoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.emprendimientoapp.AccountActivity
import com.example.emprendimientoapp.CartActivity
import com.example.emprendimientoapp.EntrepreneurshipsActivity
import com.example.emprendimientoapp.R
import com.example.emprendimientoapp.SearchActivity

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.widget.Toast

import com.google.android.material.bottomnavigation.BottomNavigationView

class PayActivity : AppCompatActivity(), SensorEventListener {

    private lateinit var sensorManager: SensorManager
    private var accelerometer: Sensor? = null
    private var shakeThreshold = 15.0f
    private var lastShakeTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        // Implementación del BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_home -> {
                    // Navegar a la pantalla de inicio
                    val intent = Intent(this, SearchActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_entrepreneurships -> {
                    // Navegar a la pantalla de emprendimientos
                    val intent = Intent(this, EntrepreneurshipsActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_account -> {
                    // Navegar a la pantalla de cuenta
                    val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.action_cart -> {
                    // Navegar a la pantalla del carrito
                    val intent = Intent(this, CartActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

        // Mostrar el mensaje al usuario
        Toast.makeText(this, "¡Agita tu teléfono para obtener un 20% de descuento!", Toast.LENGTH_LONG).show()

        // Inicializar el sensor de acelerómetro
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        if (accelerometer != null) {
            sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No se necesita implementar
    }

    override fun onSensorChanged(event: SensorEvent) {
        val x = event.values[0]
        val y = event.values[1]
        val z = event.values[2]

        val acceleration = Math.sqrt((x * x + y * y + z * z).toDouble()).toFloat()

        if (acceleration > shakeThreshold) {
            val currentTime = System.currentTimeMillis()

            // Evitar múltiples activaciones en poco tiempo
            if (currentTime - lastShakeTime > 2000) {
                lastShakeTime = currentTime
                // Mostrar la promoción
                showPromotionDialog()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this, accelerometer, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    private fun showPromotionDialog() {
        // Aquí mostrarás el anuncio de la promoción del 20%
        val dialog = PromotionDialogFragment() // Fragmento de diálogo que mostraría el anuncio
        dialog.show(supportFragmentManager, "PromotionDialog")
    }

}
