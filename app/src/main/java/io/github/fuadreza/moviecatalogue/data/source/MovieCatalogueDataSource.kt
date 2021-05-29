package io.github.fuadreza.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import io.github.fuadreza.moviecatalogue.data.MovieEntity

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<List<MovieEntity>>
//    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
//    fun getTvShows(): LiveData<List<TvShowEntity>>
//    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}