package io.github.fuadreza.moviecatalogue.ui.detail.movies

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class DetailMovieViewModel : ViewModel() {

    private lateinit var movieId: String

    fun setSelectedMovie(movieId: String) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        val moviesEntities = DataDummy.generateDummyMovies()

        return moviesEntities.single { m -> m.movieId == movieId }
    }

}