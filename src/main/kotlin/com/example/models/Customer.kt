package com.example.models

import kotlinx.serialization.Serializable


// This annotation helps Ktor generate a JSON representation of this class
// automatically using kotlin's Serialization lib
@Serializable
data class Customer(
    val id: String,
    val firstName: String,
    val lastName: String,
    val email: String,
)

/*
* In a 'Real' application we would use a Database to store our customers.
* But for demonstration purposes, this list will simply store our Customers in
* Memory while the server is running
* */
val customerStorage = mutableListOf<Customer>()
