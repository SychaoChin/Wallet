package com.example.wallet.model

import android.media.Image

data class Transaction(
    val id : Int,
    val name : String,
    val money : Double,
    val icon : String
) : java.io.Serializable