package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.local.entity.DetailEntity
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository

class DetailTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private lateinit var detailTvShow: LiveData<DetailEntity>

    private lateinit var tvShowId: String

    fun setTvShowId(tvShowId: Int) {
        this.tvShowId = tvShowId.toString()
    }

    fun dataDetailTvShow() = detailTvShow

    fun getDetailTvShow() = movieCatalogueRepository.getDetailTvShow(tvShowId.toInt())


}