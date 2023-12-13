package com.example.marcellinusbrian_challange
import android.content.ContentValues.TAG
import android.content.res.AssetManager
import android.util.Log
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.util.ArrayList


class JsonParser {
    companion object {
        fun parseMyDataFromAssets(assetManager: AssetManager): List<Property> {
            val myDataList = ArrayList<Property>()
            try {
                val is = assetManager.open("propertydata.json")
                val size = is.available()
                val buffer = ByteArray(size)
                is.read(buffer)
                is.close()

                val json = String(buffer, Charsets.UTF_8)
                val jsonArray = JSONArray(json)

                for (i in 0 until jsonArray.length()) {
                    val jsonObject = jsonArray.getJSONObject(i)
                    val property = jsonObject.getString("apartment")
                    val address = jsonObject.getString("address")
                    val attributes = jsonObject.getString("attributes")
                    val price = jsonObject.getInt("price")
                    val rentPrice = jsonObject.getInt("rentPrice")
                    val location = jsonObject.getString("location")

                    val myData = com.example.marcellinusbrian_challange.Property(property, address, attributes, price, rentPrice, location)
                    myDataList.add(myData)
                }
            } catch (e: IOException) {
                Log.e(TAG, "Error parsing propertydata.json", e)
            } catch (e: JSONException) {
                Log.e(TAG, "Error parsing propertydata.json", e)
            }
            return myDataList
        }
    }
}