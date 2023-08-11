package com.example.meal_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.*
import com.example.domain.models.Category
import com.example.meal_app.databinding.FragmentMealsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealsFragment : Fragment() {
    private var _viewBinding: FragmentMealsBinding? = null
    private val viewBinding get() = _viewBinding!!
    private lateinit var adapter: MealAdapter
    private val viewModel: MealsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentMealsBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.loadingLayout.startShimmer()
        viewModel.getMeals()
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.mealsList.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
                .collect {
                    if(it?.categories?.isNotEmpty() == true){
                        showRecyclerView()
                        initRecyclerView(it.categories)
                    }
            }
        }
    }
    private fun showRecyclerView() { 
        viewBinding.loadingLayout.apply {
            stopShimmer()
            visibility = View.GONE
        }
        viewBinding.mealsRecycleView.visibility = View.VISIBLE
    }
    private fun initRecyclerView(mealsList:List<Category>){
        adapter = MealAdapter()
        adapter.submitList(mealsList)
        viewBinding.mealsRecycleView.adapter = adapter

    }

}

