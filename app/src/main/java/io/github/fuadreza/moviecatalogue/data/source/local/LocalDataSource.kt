package io.github.fuadreza.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import io.github.fuadreza.moviecatalogue.data.source.local.dao.MovieDao
import io.github.fuadreza.moviecatalogue.data.source.local.entity.MovieEntity
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity

class LocalDataSource(private val mMovieDao: MovieDao) {
    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(movieDao)
    }

    fun getAllMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getMovies()

    fun getMovieById(id: Int): LiveData<MovieEntity> = mMovieDao.getMovieById(id)

    fun getFavMovies(): DataSource.Factory<Int, MovieEntity> = mMovieDao.getFavMovies()

    fun getAllTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getTvShows()

    fun getTvShowById(id: Int): LiveData<TvShowEntity> = mMovieDao.getTvShowById(id)

    fun getFavTvShows(): DataSource.Factory<Int, TvShowEntity> = mMovieDao.getFavTvShows()

    fun insertMovies(movies: List<MovieEntity>) = mMovieDao.insertMovies(movies)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        mMovieDao.updateMovie(movie)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFav = newState
        mMovieDao.updateMovie(movie)
    }

    fun insertTvShows(tvShows: List<TvShowEntity>) = mMovieDao.insertTvShows(tvShows)

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFav = newState
        mMovieDao.updateTvShow(tvShow)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFav = newState
        mMovieDao.updateTvShow(tvShow)
    }
}