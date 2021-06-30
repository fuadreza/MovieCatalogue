package io.github.fuadreza.moviecatalogue.ui.favorite.movies

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository

class FavoriteMoviesViewModel(private val repository: MovieCatalogueRepository) : ViewModel() {

    fun getFavoriteMovies() = repository.getFavoriteMovies()

}