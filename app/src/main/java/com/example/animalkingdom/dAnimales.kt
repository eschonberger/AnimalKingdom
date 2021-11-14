package com.example.animalkingdom

import android.os.Parcel
import android.os.Parcelable

data class dAnimales(var nombre: String,var clase: String,var conservacion: String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(clase)
        parcel.writeString(conservacion)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<dAnimales> {
        override fun createFromParcel(parcel: Parcel): dAnimales {
            return dAnimales(parcel)
        }

        override fun newArray(size: Int): Array<dAnimales?> {
            return arrayOfNulls(size)
        }
    }
}
