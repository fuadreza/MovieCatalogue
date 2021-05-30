package io.github.fuadreza.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.fuadreza.moviecatalogue.data.DetailEntity
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowResponse

class MovieCatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource) : MovieCatalogueDataSource{
    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(remoteData: RemoteDataSource): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData)
            }
    }

    override fun getMovies(): LiveData<ArrayList<MovieEntity>> {
        val movieResult = MutableLiveData<ArrayList<MovieEntity>>()

        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: ArrayList<MoviesResponse.Movie>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null) {
                    for (response in movies) {
                        with(response) {
                            val poster = poster_path ?: ""
                            val movie = MovieEntity(id, title, overview, poster)
                            movieList.add(movie)
                        }
                    }
                    movieResult.postValue(movieList)
                }
            }
        })
        return movieResult
    }

    override fun getTvShows(): LiveData<ArrayList<TvShowEntity>> {
        val tvShowResult = MutableLiveData<ArrayList<TvShowEntity>>()

        remoteDataSource.getTvShows(object: RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsLoaded(tvShows: ArrayList<TvShowResponse.TvShow>?) {
                val tvShowList = ArrayList<TvShowEntity>()
                if(tvShows != null){
                    for (response in tvShows){
                        with(response){
                            val poster = poster_path ?: ""
                            val tvShow = TvShowEntity(id, name, overview, poster)
                            tvShowList.add(tvShow)
                        }
                    }
                    tvShowResult.postValue(tvShowList)
                }
            }
        })
        return  tvShowResult
    }

}