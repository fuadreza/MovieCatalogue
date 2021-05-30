package io.github.fuadreza.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import io.github.fuadreza.moviecatalogue.data.DetailEntity
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.TvShowEntity

interface MovieCatalogueDataSource {
    fun getMovies(): LiveData<ArrayList<MovieEntity>>
//    fun getDetailMovie(movieId: String): LiveData<DetailEntity>
    fun getTvShows(): LiveData<ArrayList<TvShowEntity>>
//    fun getDetailTvShow(tvShowId: String): LiveData<DetailEntity>
}