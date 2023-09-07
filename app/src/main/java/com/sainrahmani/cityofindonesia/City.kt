package com.sainrahmani.cityofindonesia

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class City(
    val name: String,
    val description: String,
    val photo: Int
): Parcelable
