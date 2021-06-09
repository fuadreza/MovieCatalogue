package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.DetailEntity
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository

class DetailTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private lateinit var detailTvShow: LiveData<DetailEntity>

    fun dataDetailTvShow() = detailTvShow

    fun getDetailTvShow(tvShowId: Int) {
        detailTvShow = movieCatalogueRepository.getDetailTvShow(tvShowId)
    }

}