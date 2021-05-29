package io.github.fuadreza.moviecatalogue.ui.detail.movies

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class DetailMovieViewModel : ViewModel() {

    private var movieId: Int? = null

    fun setSelectedMovie(movieId: Int) {
        this.movieId = movieId
    }

    fun getMovie(): MovieEntity {
        val moviesEntities = DataDummy.generateDummyMovies()

        return moviesEntities.single { m -> m.id == movieId }
    }

}