package com.example.cityneighbours

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {

    var selected : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)

        /*

        ВЫЛЕТАЕТ ПОСЛЕ ЭТОГО КОДА

        val cities_stream = resources.openRawResource(R.raw.cities)
        val gson = Gson()
        val cities_data = gson.fromJson(InputStreamReader(cities_stream), Cities::class.java)
        Log.d("mytag", "Loaded cities ${cities_data.cities.size}")

        */

        val cities: Array<String> = resources.getStringArray(R.array.cities)
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, cities)
        spinner.adapter = adapter
        selected = spinner.selectedItem.toString()
    }



    fun onNextActivity(view: View) {
        val L = findViewById<EditText>(R.id.distance).text.toString().toInt()
        val intent = Intent(this, ListActivity::class.java);
        intent.putExtra("selected", selected)
        intent.putExtra("L", L)

        startActivity(intent)
    }
}