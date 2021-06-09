package io.github.fuadreza.moviecatalogue.ui.movies

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository

class MovieViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getMovies() = movieCatalogueRepository.getMovies()

}