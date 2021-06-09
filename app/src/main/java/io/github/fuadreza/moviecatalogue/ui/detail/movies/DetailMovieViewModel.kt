package io.github.fuadreza.moviecatalogue.ui.detail.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.DetailEntity
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository)  : ViewModel() {

    private lateinit var detailMovie: LiveData<DetailEntity>

    fun dataDetailMovie() = detailMovie

    fun getDetailMovie(movieId: Int){
        detailMovie = movieCatalogueRepository.getDetailMovie(movieId)
    }

}