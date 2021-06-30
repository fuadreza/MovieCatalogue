package io.github.fuadreza.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.di.Injection
import io.github.fuadreza.moviecatalogue.ui.detail.movies.DetailMovieViewModel
import io.github.fuadreza.moviecatalogue.ui.detail.tv_shows.DetailTvShowViewModel
import io.github.fuadreza.moviecatalogue.ui.favorite.movies.FavoriteMoviesViewModel
import io.github.fuadreza.moviecatalogue.ui.favorite.tv_shows.FavoriteTvShowsViewModel
import io.github.fuadreza.moviecatalogue.ui.movies.MovieViewModel
import io.github.fuadreza.moviecatalogue.ui.tv_shows.TvShowViewModel

class ViewModelFactory private constructor(private val mMovieCatalogueRepository: MovieCatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                MovieViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                TvShowViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                DetailMovieViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                DetailTvShowViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMoviesViewModel::class.java) -> {
                FavoriteMoviesViewModel(mMovieCatalogueRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowsViewModel::class.java) -> {
                FavoriteTvShowsViewModel(mMovieCatalogueRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }

    }
}