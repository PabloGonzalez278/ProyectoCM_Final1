package com.example.emprendimientoapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener, SensorEventListener {

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var sensorManager: SensorManager
    private var lightSensor: Sensor? = null
    private var isMapInitialized = false  // Variable para verificar la inicialización del mapa
    private val LOCATION_PERMISSION_REQUEST_CODE = 1

    // Lista de tiendas ficticias ubicadas en Chapinero y alrededores en Bogotá, Colombia
    private val tiendas = listOf(
        Pair(LatLng(4.6584, -74.0647), "Tienda Chapinero 1"),
        Pair(LatLng(4.6533, -74.0628), "Tienda Chapinero 2"),
        Pair(LatLng(4.6614, -74.0622), "Tienda Chapinero 3"),
        Pair(LatLng(4.6589, -74.0614), "Tienda Chapinero 4"),
        Pair(LatLng(4.6560, -74.0634), "Tienda Chapinero 5"),
        Pair(LatLng(4.6486, -74.0655), "Tienda Teusaquillo"),
        Pair(LatLng(4.6727, -74.0487), "Tienda Parque de la 93"),
        Pair(LatLng(4.7106, -74.0719), "Tienda Centro Histórico"),
                Pair(LatLng(4.6584, -74.0647), "Urban Trend"),             // Chapinero
        Pair(LatLng(4.6486, -74.0655), "Street Vogue"),             // Teusaquillo
        Pair(LatLng(4.6727, -74.0487), "Fashion District"),         // Parque de la 93
        Pair(LatLng(4.7106, -74.0719), "Style Wave"),               // Centro Histórico
        Pair(LatLng(4.6934, -74.0304), "Latin Flair"),              // Usaquén
        Pair(LatLng(4.6489, -74.0793), "Modern Look"),              // Galerías
        Pair(LatLng(4.6585, -74.1111), "Boho Spirit"),              // Salitre Plaza
        Pair(LatLng(4.6387, -74.0888), "Metro Wear"),               // Corferias
        Pair(LatLng(4.6527, -74.0578), "Chic Drop"),                // Zona G
        Pair(LatLng(4.5981, -74.0758), "Fashion Loft"),             // La Candelaria
        Pair(LatLng(4.6644, -74.1105), "Urban Pulse"),              // Ciudad Salitre
        Pair(LatLng(4.7141, -74.0341), "Casual Street"),            // San Rafael
        Pair(LatLng(4.7485, -74.0929), "Vintage Spot"),             // Suba
        Pair(LatLng(4.6247, -74.1289), "Style House"),              // Kennedy
        Pair(LatLng(4.6836, -74.1417), "Trendy Corner"),            // Fontibón
        Pair(LatLng(4.6026, -74.0714), "Fashion Lane"),             // Santa Fe
        Pair(LatLng(4.6902, -74.1081), "Urban Style"),              // Engativá
        Pair(LatLng(4.6272, -74.1352), "Latin Wave"),               // Plaza de las Américas
        Pair(LatLng(4.6510, -74.0999), "Style Vault"),              // Gran Estación
        Pair(LatLng(4.7264, -74.0592), "Retro Drop")                // Colina Campestre
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        // Inicializar FusedLocationProviderClient para obtener la ubicación actual
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        // Inicializar el SensorManager para manejar el sensor de luz
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        lightSensor = sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT)

        // Obtener el SupportMapFragment y recibir notificación cuando el mapa esté listo
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        // Verificar y solicitar permisos de localización
        checkLocationPermission()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        isMapInitialized = true  // Marcar que el mapa ha sido inicializado

        // Habilitar el botón de mi ubicación si el permiso está concedido
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            mMap.isMyLocationEnabled = true
            getCurrentLocation()  // Obtener ubicación actual
        }

        // Mostrar tiendas cercanas directamente en el mapa
        showAllStores()

        // Listener para clics en los marcadores
        mMap.setOnMarkerClickListener(this)
    }

    // Mostrar todas las tiendas en el mapa
    private fun showAllStores() {
        for ((tiendaLocation, tiendaNombre) in tiendas) {
            mMap.addMarker(MarkerOptions().position(tiendaLocation).title(tiendaNombre))
        }
        // Mover la cámara al área de Chapinero
        val chapineroLocation = LatLng(4.6584, -74.0647)
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(chapineroLocation, 14f))
    }

    // Obtener la ubicación actual
    private fun getCurrentLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {

            fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                if (location != null) {
                    val currentLatLng = LatLng(location.latitude, location.longitude)
                    mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
                    mMap.addMarker(MarkerOptions().position(currentLatLng).title("Mi ubicación actual"))
                } else {
                    Toast.makeText(this, "No se pudo obtener la ubicación", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    // Verificar y solicitar permisos de localización
    private fun checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }
    }

    // Manejar cambios en el sensor de luz
    override fun onSensorChanged(event: SensorEvent?) {
        if (event?.sensor?.type == Sensor.TYPE_LIGHT) {
            val lightValue = event.values[0]

            // Registrar en el log para depuración
            Log.d("SensorDeLuz", "Valor de luz: $lightValue")

            // Cambiar el estilo del mapa solo si el mapa ha sido inicializado
            if (isMapInitialized) {
                if (lightValue < 10) {  // Si está oscuro
                    Log.d("SensorDeLuz", "Aplicando estilo oscuro")
                    mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style_dark))
                } else {  // Si hay suficiente luz
                    Log.d("SensorDeLuz", "Aplicando estilo claro")
                    mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style_light))
                }
            }
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
        // No se necesita implementar para este caso
    }

    // Manejo de clics en los marcadores
    override fun onMarkerClick(marker: Marker): Boolean {
        return false
    }

    override fun onResume() {
        super.onResume()
        // Registrar el listener del sensor de luz
        lightSensor?.let {
            sensorManager.registerListener(this, it, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    override fun onPause() {
        super.onPause()
        // Desregistrar el listener cuando la actividad esté en pausa
        sensorManager.unregisterListener(this)
    }

    // Manejo del resultado de la solicitud de permisos
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<out String>, grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                    mMap.isMyLocationEnabled = true
                    getCurrentLocation()
                }
            } else {
                Toast.makeText(this, "Permiso de localización denegado", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
