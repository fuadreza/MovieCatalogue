package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.R
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.vo.Resource
import io.github.fuadreza.moviecatalogue.data.vo.Status
import io.github.fuadreza.moviecatalogue.databinding.ActivityDetailTvShowBinding
import io.github.fuadreza.moviecatalogue.viewmodel.ViewModelFactory

class DetailTvShowActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TV_SHOW = "extra_tv_show"
    }

    private lateinit var binding: ActivityDetailTvShowBinding
    private lateinit var viewModel: DetailTvShowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)

        val viewModel = ViewModelProvider(this, factory)[DetailTvShowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvShowId = extras.getInt(EXTRA_TV_SHOW)
            if (tvShowId != null) {
                viewModel.setTvShowId(tvShowId)
                viewModel.getDetailTvShow().observe(this, tvShowObserver)
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

    private fun populateDataTvShow(detailTvShow: TvShowEntity) {
        binding.tvShow = detailTvShow
        Glide.with(this)
            .load(BuildConfig.IMAGE_URL + detailTvShow.posterPath)
            .into(binding.ivPoster)

//        var genres = ""
//        detailTvShow.genres.forEachIndexed { index, genre ->
//            genres += if (index < detailTvShow.genres.size)
//                "${genre.name},"
//            else
//                genre.name
//        }
//
//        binding.tvGenre.text = genres
    }

    private val tvShowObserver = Observer<Resource<TvShowEntity>> { detailTvShow ->
        if (detailTvShow != null) {
            when (detailTvShow.status) {
                Status.LOADING -> {
                    Toast.makeText(this, "Sedang memuat", Toast.LENGTH_SHORT).show()
                }
                Status.SUCCESS -> {
                    if (detailTvShow.data != null) {
                        populateDataTvShow(detailTvShow.data)
                    }
                }
                Status.ERROR -> {
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
        }
    }

}