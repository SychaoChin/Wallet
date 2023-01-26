package com.example.wallet.model

data class Transaction(
    val id : Int,
    val name : String,
    val money : Double,
    val icon : String
) : java.io.Serializable