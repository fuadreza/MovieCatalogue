package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.R
import io.github.fuadreza.moviecatalogue.databinding.ActivityDetailTvShowBinding
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var binding: ActivityDetailTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        val viewModel = ViewModelProvider(
            this,
            factory
        )[DetailTvShowViewModel::class.java]


        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.getDetailTvShow(tvShowId)
                viewModel.dataDetailTvShow().observe(this, { detailTvShow ->
                    binding.tvShow = detailTvShow
                    Glide.with(this)
                        .load(BuildConfig.IMAGE_URL + detailTvShow.posterPath)
                        .into(binding.ivPoster)

                    var genres = ""
                    detailTvShow.genres.forEachIndexed { index, genre ->
                        genres += if (index < detailTvShow.genres.size)
                            "${genre.name},"
                        else
                            genre.name
                    }

                    binding.tvGenre.text = genres
                })
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        R.id.action_share -> {
            share()
            true
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
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
        }
    }

}