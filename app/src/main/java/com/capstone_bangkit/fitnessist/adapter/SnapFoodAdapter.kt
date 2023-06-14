package com.capstone_bangkit.fitnessist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.capstone_bangkit.fitnessist.databinding.ItemFoodHorizontalBinding
import com.capstone_bangkit.fitnessist.model.Food

class SnapFoodAdapter: RecyclerView.Adapter<SnapFoodAdapter.SnapFoodViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback
    private val food = ArrayList<Food>()
    inner class SnapFoodViewHolder(private val binding: ItemFoodHorizontalBinding): RecyclerView.ViewHolder(binding.root) {
        fun getSnapFood(food: Food) {
            binding.apply {
                Glide.with(itemView)
                    .load(food.image_url)
                    .centerCrop()
                    .into(imgFoodPicture)
                tvFoodName.text = food.food_name
                tvFoodCalories.text = food.calories_per_100gr.toString()

                root.setOnClickListener {
                    onItemClickCallback.onItemClicked(food)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SnapFoodAdapter.SnapFoodViewHolder {
        val data = ItemFoodHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SnapFoodViewHolder(data)
    }

    override fun onBindViewHolder(holder: SnapFoodAdapter.SnapFoodViewHolder, position: Int) {
        holder.getSnapFood(food[position])
    }

    override  fun getItemCount(): Int = food.size

    fun getSnapFoods(listFood: ArrayList<Food>) {
        food.clear()
        food.addAll(listFood)
        notifyDataSetChanged()
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(food: Food)
    }
}