package io.github.fuadreza.moviecatalogue.ui.tv_shows

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class TvShowViewModel(private val movieCatalogueRepository: MovieCatalogueRepository) : ViewModel() {

    fun getTvShows() = movieCatalogueRepository.getTvShows()

}