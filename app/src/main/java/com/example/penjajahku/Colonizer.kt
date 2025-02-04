package com.example.penjajahku

import android.os.Parcelable
import android.provider.Settings.Global.getString
import kotlinx.parcelize.Parcelize


@Parcelize
data class Colonizer (
    val name: String,
    val description: String,
    val photo: String
) : Parcelable

