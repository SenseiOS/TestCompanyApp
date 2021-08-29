package com.example.testcompanyapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testcompanyapp.base.BaseFragment
import com.example.testcompanyapp.databinding.FragmentSubcategoriesBinding
import com.example.testcompanyapp.ui.adapters.SubcategoryAdapter
import com.example.testcompanyapp.ui.viewModels.SubcategoryViewModel
import com.example.testcompanyapp.utils.createViewModel


class SubcategoriesFragment : BaseFragment<FragmentSubcategoriesBinding>() {

    private val viewModel: SubcategoryViewModel by lazy {
        createViewModel {
            SubcategoryViewModel(
                arguments?.getString(SubcategoriesFragment.GET_NAME_DATA_ID) ?: "",
                arguments?.getString(SubcategoriesFragment.GET_NAME_CATEGORY_ID) ?: ""
            )
        }
    }

    private val usersAdapter: SubcategoryAdapter by lazy {
        SubcategoryAdapter()
    }

    override val viewBindingProvider: (LayoutInflater, ViewGroup?) -> FragmentSubcategoriesBinding =
        { inflater, container ->
            FragmentSubcategoriesBinding.inflate(inflater, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.items.observe(viewLifecycleOwner, { response ->
            response.subcategories.let { usersResponse ->
                usersAdapter.submitList(usersResponse?.toList())
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvSubcategoriesItems.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }

    }

    companion object {

        private const val GET_NAME_DATA_ID = "dataId"
        private const val GET_NAME_CATEGORY_ID = "categoryId"

        fun newInstance(itemDataId: String, itemCategoryId: String) =
            SubcategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(GET_NAME_DATA_ID, itemDataId)
                    putString(GET_NAME_CATEGORY_ID, itemCategoryId)
                }
            }
    }
}