package com.example.marcellinusbrian_challange

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PropertyAdapter(private val propertyList: List<Property>) :
    RecyclerView.Adapter<PropertyAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val apartment: TextView = view.findViewById(R.id.apartment)
        val address: TextView = view.findViewById(R.id.address)
        val attributes: TextView = view.findViewById(R.id.attributes)
        val price: TextView = view.findViewById(R.id.price)
        val photo: ImageView = view.findViewById(R.id.photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.property_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val property = propertyList[position]
        holder.apartment.text = property.apartment
        holder.address.text = property.address.street_name
        holder.attributes.text = "BHK: ${property.attributes.bedrooms}, Bath: ${property.attributes.bathrooms}, Area: ${property.attributes.area_size} sqft"
        holder.price.text = "\$ ${property.attributes.price}"
        Glide.with(holder.photo.context).load(property.photo).into(holder.photo)
    }

    override fun getItemCount() = propertyList.size
}