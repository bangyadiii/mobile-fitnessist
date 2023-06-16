package com.capstone_bangkit.fitnessist.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.capstone_bangkit.fitnessist.api.ApiConfig
import com.capstone_bangkit.fitnessist.api.PaginationData
import com.capstone_bangkit.fitnessist.api.ResponseJSON
import com.capstone_bangkit.fitnessist.model.workouts.Workout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WorkoutViewModel (application: Application) : AndroidViewModel(application) {
    val workouts: MutableLiveData<List<Workout>> = MutableLiveData()
    val TAG = "WorkokutViewModel"

    fun getAllWorkouts(token: String, programId: String) {
        // Mengirim permintaan ke backend
        ApiConfig.getApiService().getAllWorkoutsWithProgramId(programId).enqueue(object :
            Callback<ResponseJSON<PaginationData<Workout>>> {
            override fun onResponse(call: Call<ResponseJSON<PaginationData<Workout>>>, response: Response<ResponseJSON<PaginationData<Workout>>>) {
                if (response.isSuccessful) {
                    workouts.postValue(response.body()?.data?.items!!)
                } else {
                    Log.d(TAG, "ERRORRR")
                    Toast.makeText(getApplication(), response.message(), Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<ResponseJSON<PaginationData<Workout>>>, t: Throwable) {
                Log.d(TAG, t.message ?: "ERRORRR")
                Toast.makeText(getApplication(), t.message, Toast.LENGTH_SHORT).show()
            }
        })
    }
}