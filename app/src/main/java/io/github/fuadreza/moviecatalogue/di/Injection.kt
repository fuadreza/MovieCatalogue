package io.github.fuadreza.moviecatalogue.di

import android.content.Context
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.data.source.local.LocalDataSource
import io.github.fuadreza.moviecatalogue.data.source.local.MovieDatabase
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource
import io.github.fuadreza.moviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieDao())
        val appExecutors = AppExecutors()

        return MovieCatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}