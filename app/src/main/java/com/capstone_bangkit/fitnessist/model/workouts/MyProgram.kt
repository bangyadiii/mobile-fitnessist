package com.capstone_bangkit.fitnessist.model.workouts

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import androidx.annotation.Keep
import com.capstone_bangkit.fitnessist.model.User
import com.google.gson.annotations.Expose

@Keep
data class MyProgram(
    @SerializedName("id")
    @Expose
    val id: String?,

    @SerializedName("program_id")
    @Expose
    val programId: String?,

    @SerializedName("user")
    @Expose
    val user: User?,

    @SerializedName("user_id")
    @Expose
    val userId: String?,

    @SerializedName("exercise_completed_counter")
    @Expose
    val exerciseCompletedCounter: Int?,

    @SerializedName("workout_completed_counter")
    @Expose
    val workoutCompletedCounter: Int?,

    @SerializedName("progress_percent")
    @Expose
    val progressPercent: Int?,

    @SerializedName("program")
    @Expose
    val program: Program?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(User::class.java.classLoader),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readParcelable(Program::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(programId)
        parcel.writeParcelable(user, flags)
        parcel.writeString(userId)
        parcel.writeValue(exerciseCompletedCounter)
        parcel.writeValue(workoutCompletedCounter)
        parcel.writeValue(progressPercent)
        parcel.writeParcelable(program, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyProgram> {
        override fun createFromParcel(parcel: Parcel): MyProgram {
            return MyProgram(parcel)
        }

        override fun newArray(size: Int): Array<MyProgram?> {
            return arrayOfNulls(size)
        }
    }
}