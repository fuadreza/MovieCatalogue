package io.github.fuadreza.moviecatalogue.ui.detail.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.R
import io.github.fuadreza.moviecatalogue.data.source.local.entity.MovieEntity
import io.github.fuadreza.moviecatalogue.data.vo.Resource
import io.github.fuadreza.moviecatalogue.data.vo.Status
import io.github.fuadreza.moviecatalogue.databinding.ActivityDetailMovieBinding
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory


class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)

        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setMovieId(movieId)
                viewModel.getDetailMovie().observe(this, movieObserver)
            }
        }

        binding.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favorite -> {
                    favorite()
                    true
                }
                R.id.action_share -> {
                    share()
                    true
                }
                else -> false
            }
        }
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun populateDataMovie(detailMovie: MovieEntity) {
        binding.movie = detailMovie
        Glide.with(this)
            .load(BuildConfig.IMAGE_URL + detailMovie.posterPath)
            .into(binding.ivPoster)

//        var genres = ""
//        detailMovie.genres.forEachIndexed { index, genre ->
//            genres += if (index < detailMovie.genres.size)
//                "${genre.name},"
//            else
//                genre.name
//        }
//        binding.tvGenre.text = genres
    }

    private val movieObserver = Observer<Resource<MovieEntity>> { detailMovie ->
        if (detailMovie != null) {
            when (detailMovie.status) {
                Status.LOADING -> {
                    showProgress(true)
                }
                Status.SUCCESS -> {
                    showProgress(false)
                    if (detailMovie.data != null) {
                        populateDataMovie(detailMovie.data)
                    }
                }
                Status.ERROR -> {
                    showProgress(false)
                    Toast.makeText(this, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun favorite() {
        binding.toolbar.menu.findItem(R.id.favorite).setIcon(R.drawable.ic_baseline_favorite_24)
    }

    private fun share() {
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
            val shareMessage = "Let me recommend you movie"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Choose one"))
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("SHARE", "SHARE MOVIE")
        }
    }

    private fun showProgress(state: Boolean){
        binding.progressBar.isVisible = state
    }
}