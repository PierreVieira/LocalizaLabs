package com.example.mymovieslist.ui.screens.bottomNavigation.movies

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mymovieslist.data.model.api.MovieItem
import com.example.mymovieslist.databinding.FragmentMoviesBinding
import com.example.mymovieslist.enums.FragmentNavigationType
import com.example.mymovieslist.ui.screens.bottomNavigation.BaseNavigationFragment
import com.example.mymovieslist.ui.screens.bottomNavigation.movies.adapter.HorizontalMoviesAdapter

class MoviesFragment : BaseNavigationFragment(FragmentNavigationType.MOVIES) {

    private val viewModel: MoviesViewModel by viewModels()
    private lateinit var binding: FragmentMoviesBinding
    private lateinit var requiredContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requiredContext = requireContext()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.apply {
            setHasFixedSize(true)
            adapter = createAdapter()
        }
    }

    private fun createAdapter() =
        HorizontalMoviesAdapter(viewModel.data, requiredContext) { homeItemType, callback ->
            viewModel.getMovieList(
                homeItemType,
                requiredContext
            ) { movies: List<MovieItem> -> callback(movies) }
        }

}