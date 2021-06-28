package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.local.entity.DetailEntity
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.vo.Resource

class DetailTvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private lateinit var detailTvShow: LiveData<Resource<TvShowEntity>>

    fun setTvShowId(tvShowId: Int) {
        detailTvShow = movieCatalogueRepository.getDetailTvShow(tvShowId)
    }

    fun setFavoriteTvShow() {
        val resource = detailTvShow.value
        if (resource?.data != null) {
            val newState = !resource.data.isFav
            movieCatalogueRepository.setFavoriteTvShow(resource.data, newState)
        }
    }

    fun getDetailTvShow() = detailTvShow


}