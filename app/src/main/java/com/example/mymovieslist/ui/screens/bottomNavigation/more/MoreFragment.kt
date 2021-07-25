package com.example.mymovieslist.ui.screens.bottomNavigation.more

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mymovieslist.R
import com.example.mymovieslist.databinding.FragmentMoreBinding
import com.example.mymovieslist.ui.screens.bottomNavigation.more.adapter.MoreAdapter

class MoreFragment : Fragment() {

    private lateinit var binding: FragmentMoreBinding
    private lateinit var headerView: View
    private val viewModel: MoreViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        headerView = inflater.inflate(R.layout.default_header_fragment, container, false)
        binding = FragmentMoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        headerView.findViewById<TextView>(R.id.title).text = resources.getText(R.string.more)
        binding.customHeaderView.setView(headerView)
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = MoreAdapter(requireContext(), viewModel.dataList)
        }
    }
}