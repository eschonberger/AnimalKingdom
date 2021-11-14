package com.example.animalkingdom

import android.os.Parcel
import android.os.Parcelable

data class dUsuarios(var nombreUsuario:String, var clave:String) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombreUsuario)
        parcel.writeString(clave)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<dUsuarios> {
        override fun createFromParcel(parcel: Parcel): dUsuarios {
            return dUsuarios(parcel)
        }

        override fun newArray(size: Int): Array<dUsuarios?> {
            return arrayOfNulls(size)
        }
    }
}
