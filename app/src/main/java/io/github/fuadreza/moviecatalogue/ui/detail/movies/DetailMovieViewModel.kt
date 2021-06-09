package io.github.fuadreza.moviecatalogue.ui.detail.movies

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository

class DetailMovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) :
    ViewModel() {

    private lateinit var movieId: String

    fun setMovieId(movieId: Int) {
        this.movieId = movieId.toString()
    }

    fun getDetailMovie() = movieCatalogueRepository.getDetailMovie(movieId.toInt())

}