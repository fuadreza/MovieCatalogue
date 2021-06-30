package io.github.fuadreza.moviecatalogue.ui.favorite.tv_shows

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fuadreza.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import io.github.fuadreza.moviecatalogue.ui.detail.tv_shows.DetailTvShowActivity
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowsFragment : Fragment(), FavoriteTvShowsAdapter.OnItemClickCallback {

    private lateinit var binding: FragmentFavoriteTvShowBinding

    private lateinit var viewModel: FavoriteTvShowsViewModel
    private lateinit var favoriteTvShowsAdapter: FavoriteTvShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, { tvShows ->
            if (tvShows != null) {
                favoriteTvShowsAdapter.submitList(tvShows)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[FavoriteTvShowsViewModel::class.java]

            favoriteTvShowsAdapter = FavoriteTvShowsAdapter()
            favoriteTvShowsAdapter.setOnItemClickCallback(this)

            with(binding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(false)
                this.adapter = favoriteTvShowsAdapter
            }
        }
    }

    override fun onItemClicked(id: Int) {
        val intent = Intent(context, DetailTvShowActivity::class.java)
        intent.putExtra(DetailTvShowActivity.EXTRA_TV_SHOW, id)

        context?.startActivity(intent)
    }
}