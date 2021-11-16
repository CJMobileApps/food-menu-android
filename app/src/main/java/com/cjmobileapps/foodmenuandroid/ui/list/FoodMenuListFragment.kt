package com.cjmobileapps.foodmenuandroid.ui.list

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cjmobileapps.foodmenuandroid.R
import com.cjmobileapps.foodmenuandroid.databinding.FragmentFoodMenuListBinding
import com.cjmobileapps.foodmenuandroid.ui.FoodMenuActivity
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodMenuListFragment : Fragment() {

    private val foodMenuActivity by lazy { activity as? FoodMenuActivity }

    private var binding: FragmentFoodMenuListBinding? = null

    private val foodMenuListViewModel: FoodMenuListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFoodMenuListBinding.inflate(inflater, container, false)
        return binding?.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.foodMenuListMenuList?.layoutManager = LinearLayoutManager(requireContext())

        val adapter = FoodMenuListAdapter()
        binding?.foodMenuListMenuList?.adapter = adapter

        foodMenuListViewModel.mealsLiveData.observe(
            viewLifecycleOwner,
            { meals ->
                if(meals.isNotEmpty()) {
                    adapter.meals = meals
                    adapter.notifyDataSetChanged()
                    binding?.foodMenuListNoSongsFound?.visibility = View.GONE
                } else {
                    binding?.foodMenuListNoSongsFound?.visibility = View.VISIBLE
                }
            }
        )

        foodMenuListViewModel.mealsAreLoading.observe(
            viewLifecycleOwner,
            { areLoading ->
                if(areLoading) {
                    binding?.foodMenuListProgress?.visibility = View.VISIBLE
                } else {
                    binding?.foodMenuListProgress?.visibility = View.GONE
                }
            }
        )

        foodMenuListViewModel.showDefaultErrorMessageLiveData.observe(
            viewLifecycleOwner,
            { _ ->
                foodMenuActivity?.binding?.root?.let {
                    Snackbar.make(
                        it,
                        getString(R.string.error_occurred),
                        Snackbar.LENGTH_LONG
                    ).show()
                }
            }
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}