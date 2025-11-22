package com.example.pc2moviles_20100798_20100816__

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RegistroActivity : AppCompatActivity() {

    private lateinit var edtNombre: EditText
    private lateinit var edtEstadio: EditText
    private lateinit var edtCiudad: EditText
    private lateinit var edtFundacion: EditText
    private lateinit var btnGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)

        edtNombre = findViewById(R.id.edtNombre)
        edtEstadio = findViewById(R.id.edtEstadio)
        edtCiudad = findViewById(R.id.edtCiudad)
        edtFundacion = findViewById(R.id.edtFundacion)
        btnGuardar = findViewById(R.id.btnGuardar)

        val db = Firebase.firestore

        btnGuardar.setOnClickListener {

            val equipo = Equipo(
                nombre = edtNombre.text.toString(),
                estadio = edtEstadio.text.toString(),
                ciudad = edtCiudad.text.toString(),
                fundacion = edtFundacion.text.toString()
            )

            db.collection("equipos")
                .add(equipo)
                .addOnSuccessListener {
                    finish()  // Luego pasaremos a la pantalla 2
                }
        }
    }
}
