package com.example.penjajahku

import android.os.Parcelable

import kotlinx.parcelize.Parcelize


@Parcelize
data class Colonizer (
    val name: String,
    val description: String,
    val photo: String
) : Parcelable

