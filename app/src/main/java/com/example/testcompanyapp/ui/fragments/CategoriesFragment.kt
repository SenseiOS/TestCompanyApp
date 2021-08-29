package com.example.testcompanyapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testcompanyapp.base.BaseFragment
import com.example.testcompanyapp.databinding.FragmentCategoriesBinding
import com.example.testcompanyapp.ui.adapters.CategoriesAdapter
import com.example.testcompanyapp.ui.viewModels.CategoriesViewModel
import com.example.testcompanyapp.utils.createViewModel

class CategoriesFragment : BaseFragment<FragmentCategoriesBinding>() {

    var dataId = ""
    private val viewModel: CategoriesViewModel by lazy {
        createViewModel {
            CategoriesViewModel(dataId)
        }
    }

    private val usersAdapter: CategoriesAdapter by lazy {
        CategoriesAdapter(
            clickListener = {
                replaceFragment(SubcategoriesFragment.newInstance(dataId, it.id))
            }
        )
    }

    override val viewBindingProvider: (LayoutInflater, ViewGroup?) -> FragmentCategoriesBinding =
        { inflater, container ->
            FragmentCategoriesBinding.inflate(inflater, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataId = arguments?.getString(GET_NAME_ID).toString()
        setupRecyclerView()

        viewModel.items.observe(viewLifecycleOwner, { response ->
            response.categories.let { usersResponse ->
                usersAdapter.submitList(usersResponse.toList())
            }
        })
    }

    private fun setupRecyclerView() {
        binding.rvCategoriesItems.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }

    }

    companion object {

        private const val GET_NAME_ID = "id"

        fun newInstance(itemId: String) = CategoriesFragment().apply {
            arguments = Bundle().apply {
                putString(GET_NAME_ID, itemId)
            }
        }
    }
}