package io.github.fuadreza.moviecatalogue.ui.detail.movies

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.R
import io.github.fuadreza.moviecatalogue.databinding.ActivityDetailMovieBinding
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory


class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val factory = ViewModelFactory.getInstance(this)

        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setMovieId(movieId)
                viewModel.getDetailMovie().observe(this, { detailMovie ->
                    binding.movie = detailMovie
                    Glide.with(this)
                        .load(BuildConfig.IMAGE_URL + detailMovie.posterPath)
                        .into(binding.ivPoster)

                    var genres = ""
                    detailMovie.genres.forEachIndexed { index, genre ->
                        genres += if (index < detailMovie.genres.size)
                            "${genre.name},"
                        else
                            genre.name
                    }
                    binding.tvGenre.text = genres
                })
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

}