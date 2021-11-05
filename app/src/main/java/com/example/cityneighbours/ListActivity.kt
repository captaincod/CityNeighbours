package com.example.cityneighbours

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.InputStreamReader

class ListActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val selected = intent.getStringExtra("selected")
        val L = intent.getIntExtra("L",0)
        val output = findViewById<TextView>(R.id.output)

        val cities_stream = resources.openRawResource(R.raw.cities)
        val gson = Gson()
        val cities_data = gson.fromJson(InputStreamReader(cities_stream), Cities::class.java)
        val cities_arr: Array<City> = cities_data.cities
        val beginning_city : City

        for (i in cities_arr){
            if (i.name == selected){
                beginning_city = i
                break
            }
        }

        for (i in cities_arr){
            
        }


    }
}