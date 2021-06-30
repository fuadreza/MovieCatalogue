package io.github.fuadreza.moviecatalogue.ui.favorite.movies

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fuadreza.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import io.github.fuadreza.moviecatalogue.ui.detail.movies.DetailMovieActivity
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMoviesFragment : Fragment(), FavoriteMoviesAdapter.OnItemClickCallback {

    private lateinit var binding: FragmentFavoriteMovieBinding

    private lateinit var viewModel: FavoriteMoviesViewModel
    private lateinit var favoriteMoviesAdapter: FavoriteMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavoriteMovies().observe(viewLifecycleOwner, { movies ->
            if (movies != null) {
                favoriteMoviesAdapter.submitList(movies)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteMoviesViewModel::class.java]

            favoriteMoviesAdapter = FavoriteMoviesAdapter()
            favoriteMoviesAdapter.setOnItemClickCallback(this)

            with(binding.rvMovie) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(false)
                this.adapter = favoriteMoviesAdapter
            }
        }
    }

    override fun onItemClicked(id: Int) {
        val intent = Intent(context, DetailMovieActivity::class.java)
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, id)

        context?.startActivity(intent)
    }
}