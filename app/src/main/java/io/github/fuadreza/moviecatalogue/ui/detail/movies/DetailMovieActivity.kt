package io.github.fuadreza.moviecatalogue.ui.detail.movies

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.R
import io.github.fuadreza.moviecatalogue.databinding.ActivityDetailMovieBinding


class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }

    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        binding.toolbar.post {
//            binding.toolbar.inflateMenu(R.menu.menu_detail)
//        }

        val viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[DetailMovieViewModel::class.java]


//        val extras = intent.extras
//        if (extras != null) {
//            val movieId = extras.getString(EXTRA_MOVIE)
//            if (movieId != null) {
//                viewModel.setSelectedMovie(movieId)
//                val movie = viewModel.getMovie()
//                binding.movie = movie
//                Glide.with(this)
//                    .load("file:///android_asset/${movie.imagePath}")
//                    .into(binding.ivPoster)
//                var genres = ""
//                movie.genre.forEachIndexed { index, genre ->
//                    genres += if(index<movie.genre.size)
//                        "${genre.name},"
//                    else
//                        genre.name
//                }
//                binding.tvGenre.text = genres
//            }
//        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.action_share -> {
            share()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun share(){
        try {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_name))
            val shareMessage = "Let me recommend you movie"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Choose one"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}