package io.github.fuadreza.moviecatalogue.ui.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fuadreza.moviecatalogue.databinding.FragmentMovieBinding
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieViewModel::class.java]

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                val movieAdapter = MovieAdapter()
                movieAdapter.setMovies(movies)
                binding.rvMovie.apply {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(false)
                    adapter = movieAdapter
                }
            })

        }
    }

}