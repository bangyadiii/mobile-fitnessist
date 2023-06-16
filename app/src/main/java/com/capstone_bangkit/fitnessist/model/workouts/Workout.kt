package com.capstone_bangkit.fitnessist.model.workouts


import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.Keep
import com.capstone_bangkit.fitnessist.api.Links
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Keep
data class Workout(
    @SerializedName("id")
    @Expose
    val id: String?,

    @SerializedName("links")
    @Expose
    val links: Links?,

    @SerializedName("day")
    @Expose
    val day: String?,

    @SerializedName("exercises")
    @Expose
    val exercises: ArrayList<Exercise>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readParcelable(Links::class.java.classLoader),
        parcel.readString(),
        parcel.createTypedArrayList(Exercise.CREATOR)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeParcelable(links, flags)
        parcel.writeString(day)
        parcel.writeTypedList(exercises)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Workout> {
        override fun createFromParcel(parcel: Parcel): Workout {
            return Workout(parcel)
        }

        override fun newArray(size: Int): Array<Workout?> {
            return arrayOfNulls(size)
        }
    }
}
