package io.github.fuadreza.moviecatalogue.ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.data.source.local.entity.MovieEntity
import io.github.fuadreza.moviecatalogue.data.vo.Resource

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private lateinit var detailMovie: LiveData<Resource<MovieEntity>>

    fun setMovieId(movieId: Int) {
        detailMovie = movieCatalogueRepository.getDetailMovie(movieId)
    }

    fun setFavoriteMovie() {
        val resource = detailMovie.value
        if (resource?.data != null) {
            val newState = !resource.data.isFav
            movieCatalogueRepository.setFavoriteMovie(resource.data, newState)
        }
    }

    fun getDetailMovie() = detailMovie

}