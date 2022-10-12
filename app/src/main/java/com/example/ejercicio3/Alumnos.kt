package com.example.ejercicio3

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Alumnos(var id:Int,val nombre:String, val edad:Int,val grupo:String):Parcelable