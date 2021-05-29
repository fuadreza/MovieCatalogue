package io.github.fuadreza.moviecatalogue.di

import android.content.Context
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {
    fun provideRepository(context: Context): MovieCatalogueRepository {

        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieCatalogueRepository.getInstance(remoteDataSource)
    }
}