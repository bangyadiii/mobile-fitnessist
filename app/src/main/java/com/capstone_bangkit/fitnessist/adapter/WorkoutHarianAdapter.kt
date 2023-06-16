package com.capstone_bangkit.fitnessist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.capstone_bangkit.fitnessist.databinding.ItemWorkoutharianBinding
import com.capstone_bangkit.fitnessist.model.workouts.Workout

class WorkoutHarianAdapter: RecyclerView.Adapter<WorkoutHarianAdapter.WorkoutListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private val workouts = ArrayList<Workout>()

    inner class WorkoutListViewHolder(private val binding: ItemWorkoutharianBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(workout: Workout) {
            binding.apply {
                tvDay.text = "Hari ${workout.day}"
                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(workout)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WorkoutHarianAdapter.WorkoutListViewHolder {
        val data = ItemWorkoutharianBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WorkoutListViewHolder(data)
    }

    override fun onBindViewHolder(holder: WorkoutHarianAdapter.WorkoutListViewHolder, position: Int) {
        holder.bind(workouts[position])
    }

    override  fun getItemCount(): Int {
        return workouts.size
    }

    fun setWorkouts(listWorkouts: ArrayList<Workout>) {
        workouts.clear()
        workouts.addAll(listWorkouts)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(workout: Workout)
    }
}