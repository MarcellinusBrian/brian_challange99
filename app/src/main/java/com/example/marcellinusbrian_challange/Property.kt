package com.example.marcellinusbrian_challange

data class Property(
    val id: String,
    val apartment: String,
    val category: String,
    val completed_at: Int,
    val tenure: Int,
    val address: String,
    val attributes: Attributes,
    val photo: String
)

data class Address(
    val district: String,
    val street_name: String
)

data class Attributes(
    val area_size: Int,
    val bedrooms: Int,
    val bathrooms: Int,
    val price: Int
)
