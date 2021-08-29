package com.example.testcompanyapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testcompanyapp.base.BaseFragment
import com.example.testcompanyapp.databinding.FragmentDataBinding
import com.example.testcompanyapp.ui.adapters.DataAdapter
import com.example.testcompanyapp.ui.viewModels.DataViewModel
import com.example.testcompanyapp.utils.createViewModel

class DataFragment : BaseFragment<FragmentDataBinding>() {

    private val viewModel: DataViewModel by lazy {
        createViewModel {
            DataViewModel()
        }
    }
    private val usersAdapter: DataAdapter by lazy {
        DataAdapter(
            clickListener = {
                replaceFragment(CategoriesFragment.newInstance(it.id))
            }
        )
    }

    override val viewBindingProvider: (LayoutInflater, ViewGroup?) -> FragmentDataBinding =
        { inflater, container ->
            FragmentDataBinding.inflate(inflater, container, false)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.items.observe(viewLifecycleOwner, { response ->
            usersAdapter.submitList(response)
        })
    }

    private fun setupRecyclerView() {
        binding.rvDataItems.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = usersAdapter
        }

    }

    companion object {
        fun newInstance() = DataFragment()
    }

}