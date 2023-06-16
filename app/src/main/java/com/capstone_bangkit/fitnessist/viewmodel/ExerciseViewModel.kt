package com.capstone_bangkit.fitnessist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.capstone_bangkit.fitnessist.api.ApiConfig
import com.capstone_bangkit.fitnessist.api.ResponseJSON
import com.capstone_bangkit.fitnessist.model.workouts.Workout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExerciseViewModel(application: Application) : AndroidViewModel(application)  {
    val workouts: MutableLiveData<Workout?> = MutableLiveData()
    val TAG = "ExerciseViewModel"

    fun getWorkoutWithId(workoutId: String, onError: (String) -> Unit) {
        ApiConfig.getApiService().getWorkoutById(workoutId).enqueue(object :
            Callback<ResponseJSON<Workout>> {
            override fun onResponse(call: Call<ResponseJSON<Workout>>, response: Response<ResponseJSON<Workout>>) =
                if (response.isSuccessful) {
                    val workout = response.body()!!.data
                    if (workout != null) {
                        workouts.postValue(workout)
                    } else {
                        onError("Server Error Coba lagi Setelah Beberapa Saat")
                    }
                } else {
                    onError("Server Error Coba lagi Setelah Beberapa Saat")
                }

            override fun onFailure(call: Call<ResponseJSON<Workout>>, t: Throwable) {
                onError(t.message ?: "Server Error Coba lagi Setelah Beberapa Saat")
            }
        })
    }

}