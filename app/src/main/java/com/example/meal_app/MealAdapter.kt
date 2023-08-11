package com.example.meal_app
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.models.Category
import com.example.meal_app.databinding.MealItemInListBinding

class MealAdapter() : ListAdapter<Category, MealAdapter.MealsViewHolder>(CategoryDiffCallback()) {
    inner class MealsViewHolder(private val itemViewBinding: MealItemInListBinding):RecyclerView.ViewHolder(itemViewBinding.root){
        fun bind(category: Category) {
            itemViewBinding.categoryNameTv.text = category.strCategory
            itemViewBinding.categoryDesTv.text = category.strCategoryDescription
            Glide.with(itemViewBinding.root.context).load(category.strCategoryThumb).into(itemViewBinding.categoryIv)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsViewHolder {
        val mealItemViewBinding= MealItemInListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MealsViewHolder(mealItemViewBinding)
    }

    override fun onBindViewHolder(holder: MealsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem.idCategory == newItem.idCategory
        }

        override fun areContentsTheSame(
            oldItem: Category,
            newItem: Category
        ): Boolean {
            return oldItem == newItem
        }
    }

}