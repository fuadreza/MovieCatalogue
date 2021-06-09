package io.github.fuadreza.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.fuadreza.moviecatalogue.data.DetailEntity
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MovieDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowDetailResponse
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

    override fun getDetailMovie(movieId: Int): LiveData<DetailEntity> {
        val movieResult = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailMovie(object: RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
                if (movieDetail != null){
                    with(movieDetail){
                        val listGenres = ArrayList<DetailEntity.Genre>()

                        for (genre in genres){
                            listGenres.add(DetailEntity.Genre(genre.id, genre.name))
                        }

                        val detailMovie = DetailEntity(
                            id = id,
                            title = title,
                            genres = listGenres,
                            releaseYear = releaseYear ?: "empty",
                            tagline = tagline ?: "empty",
                            overview = overview ?: "empty",
                            popularity = popularity.toString(),
                            posterPath = posterPath ?: "empty"
                        )
                        movieResult.postValue(detailMovie)
                    }
                }
            }
        }, movieId)
        return movieResult
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailEntity> {
        val tvShowResult = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailTvShow(object: RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?) {
                if(tvShowDetail != null){
                    with(tvShowDetail) {
                        val listGenres = ArrayList<DetailEntity.Genre>()

                        for (genre in genres) {
                            listGenres.add(DetailEntity.Genre(genre.id, genre.name))
                        }

                        val detailTvShow = DetailEntity(
                            id = id,
                            title = name,
                            genres = listGenres,
                            releaseYear = firstAirDate,
                            tagline = tagline,
                            overview = overview,
                            popularity = popularity.toString(),
                            posterPath = posterPath ?: "empty"
                        )
                        tvShowResult.postValue(detailTvShow)
                    }
                }
            }
        }, tvShowId)
        return tvShowResult
    }
}