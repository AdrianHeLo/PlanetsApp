package com.adrianhelo.planetsapp.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adrianhelo.planetsapp.R
import com.adrianhelo.planetsapp.ui.adapters.PlanetsAdapter
import com.adrianhelo.planetsapp.ui.models.PlanestsModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // 1.- ListView
        val itemList: RecyclerView = findViewById(R.id.main_recycler_view)
        itemList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        // 2.- Data Source
        val planets = ArrayList<PlanestsModel>()
        val planet1 = PlanestsModel("Mercury", "0 Moons", R.drawable.mercury)
        val planet2 = PlanestsModel("Venus", "0 Moons", R.drawable.venus)
        val planet3 = PlanestsModel("Earth", "1 Moons", R.drawable.earth)
        val planet4 = PlanestsModel("Mars", "2 Moons", R.drawable.mars)
        val planet5 = PlanestsModel("Jupiter", "79 Moons", R.drawable.jupiter)
        val planet6 = PlanestsModel("Saturn", "83 Moons", R.drawable.saturn)
        val planet7 = PlanestsModel("Uranus", "27 Moons", R.drawable.uranus)
        val planet8 = PlanestsModel("Neptune", "14 Moons", R.drawable.neptune)
        planets.add(planet1)
        planets.add(planet2)
        planets.add(planet3)
        planets.add(planet4)
        planets.add(planet5)
        planets.add(planet6)
        planets.add(planet7)
        planets.add(planet8)

        // 3.- Adapter
        val adapter = PlanetsAdapter(planets)
        itemList.adapter = adapter

    }
}