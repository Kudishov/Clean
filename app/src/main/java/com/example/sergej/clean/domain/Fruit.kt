package com.example.sergej.clean.domain

import android.os.Parcel
import android.os.Parcelable
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Fruit(

    /**
     * id фрукта
     */
    @PrimaryKey
    var id: Int = 0,

    /**
     * имя фрукта
     */

    var name: String = "",
    /**
     * цвет фрукта
     */

    var color: String = "",
    /**
     * вес фрукта
     */

    var weight: String = "",

    /**
     * Насколько вкусен фрукт
     */

    var delicious: String = "",

    /**
     * дата создания фрукта
     */

    var created_at: String = "",

    /**
     * дата обновления фрукта
     */

    var updated_at: String = ""

) : RealmObject(), Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(color)
        parcel.writeString(weight)
        parcel.writeString(delicious)
        parcel.writeString(created_at)
        parcel.writeString(updated_at)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Fruit> {
        override fun createFromParcel(parcel: Parcel): Fruit {
            return Fruit(parcel)
        }

        override fun newArray(size: Int): Array<Fruit?> {
            return arrayOfNulls(size)
        }
    }
}