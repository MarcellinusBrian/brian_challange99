package com.example.marcellinusbrian_challange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import utils.JsonParser

class MainActivity : AppCompatActivity() {

    private lateinit var propertyList: List<Property>
    private lateinit var propertyAdapter: PropertyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val assetManager = this.assets
        val myDataList = JsonParser.parseMyDataFromAssets(assets)

        propertyList = getStaticData()
        propertyAdapter = PropertyAdapter(propertyList)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = propertyAdapter

    }

    private fun getStaticData(): List<Property> {
        val jsonData = """
            [
            ]
            """

        val gson = Gson()
        val propertyType = object : TypeToken<List<Property>>() {}.type
        return gson.fromJson(jsonData, propertyType)

    }
}