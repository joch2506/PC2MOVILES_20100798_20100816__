package com.example.pc2moviles_20100798_20100816__



import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.liga1.adapters.EquipoAdapter
import com.example.liga1.models.Equipo
import com.google.firebase.firestore.FirebaseFirestore
import android.widget.Button

class ListadoActivity : AppCompatActivity() {

    private lateinit var lista: ArrayList<Equipo>
    private lateinit var adapter: EquipoAdapter
    private lateinit var rv: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado)

        rv = findViewById(R.id.rvEquipos)
        rv.layoutManager = LinearLayoutManager(this)

        lista = ArrayList()
        adapter = EquipoAdapter(lista)
        rv.adapter = adapter

        cargarEquipos()

        findViewById<Button>(R.id.btnNuevo).setOnClickListener {
            startActivity(Intent(this, RegistroActivity::class.java))
        }
    }

    private fun cargarEquipos() {
        FirebaseFirestore.getInstance()
            .collection("equipos")
            .get()
            .addOnSuccessListener { docs ->
                lista.clear()

                for (d in docs) {
                    lista.add(
                        Equipo(
                            nombre = d.getString("nombre") ?: "",
                            fundacion = d.getString("fundacion") ?: "",
                            titulos = d.getString("titulos") ?: "",
                            imagenUrl = d.getString("imagenUrl") ?: ""
                        )
                    )
                }

                adapter.notifyDataSetChanged()
            }
    }
}
