package io.github.fuadreza.moviecatalogue.ui.tv_shows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.github.fuadreza.moviecatalogue.databinding.FragmentTvShowBinding
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory

class TvShowFragment : Fragment() {

    private lateinit var binding: FragmentTvShowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {

            val factory = ViewModelFactory.getInstance(requireActivity())

            val viewModel = ViewModelProvider(
                this,
                factory
            )[TvShowViewModel::class.java]

            viewModel.getTvShows().observe(viewLifecycleOwner, { tvShows ->
                val tvShowAdapter = TvShowAdapter()
                tvShowAdapter.setTvShows(tvShows)
                binding.rvTvShow.apply {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(false)
                    adapter = tvShowAdapter
                }
            })

        }
    }

}