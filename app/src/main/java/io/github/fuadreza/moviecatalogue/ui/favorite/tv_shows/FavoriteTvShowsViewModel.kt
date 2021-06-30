package io.github.fuadreza.moviecatalogue.ui.favorite.tv_shows

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository

class FavoriteTvShowsViewModel(private val repository: MovieCatalogueRepository) : ViewModel() {

    fun getFavoriteTvShows() = repository.getFavoriteTvShows()

}