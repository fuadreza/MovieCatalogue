package io.github.fuadreza.moviecatalogue.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueDataSource
import io.github.fuadreza.moviecatalogue.data.source.local.entity.DetailEntity
import io.github.fuadreza.moviecatalogue.data.source.local.entity.MovieEntity
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MovieDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowResponse

class FakeMovieCatalogueRepository(private val remoteDataSource: RemoteDataSource) :
    MovieCatalogueDataSource {

    override fun getMovies(): LiveData<ArrayList<MovieEntity>> {
        val moviesResult = MutableLiveData<ArrayList<MovieEntity>>()

        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
            override fun onMoviesLoaded(movies: ArrayList<MoviesResponse.Movie>?) {
                val movieList = ArrayList<MovieEntity>()
                if (movies != null) {
                    for (movie in movies) {
                        with(movie) {
                            movieList.add(MovieEntity(id, title, overview, poster_path.toString()))
                        }
                    }
                    moviesResult.postValue(movieList)
                }
            }
        })

        return moviesResult
    }

    override fun getDetailMovie(movieId: Int): LiveData<DetailEntity> {
        val movieDetailResult = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
                if (movieDetail != null) {
                    with(movieDetail) {
                        val listGenre = ArrayList<DetailEntity.Genre>()

                        for (genre in genres) {
                            listGenre.add(DetailEntity.Genre(genre.id, genre.name))
                        }

                        val detailMovie = DetailEntity(
                            id = id,
                            title = title,
                            genres = listGenre,
                            releaseYear = releaseYear.toString(),
                            tagline = tagline.toString(),
                            overview = overview.toString(),
                            popularity = popularity.toString(),
                            posterPath = posterPath ?: "empty"
                        )
                        movieDetailResult.postValue(detailMovie)
                    }
                }
            }
        }, movieId)
        return movieDetailResult
    }

    override fun getTvShows(): LiveData<ArrayList<TvShowEntity>> {
        val tvShowsResult = MutableLiveData<ArrayList<TvShowEntity>>()

        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
            override fun onTvShowsLoaded(tvShows: ArrayList<TvShowResponse.TvShow>?) {
                val tvShowsList = ArrayList<TvShowEntity>()
                if (tvShows != null) {
                    for (tvShow in tvShows) {
                        with(tvShow) {
                            tvShowsList.add(
                                TvShowEntity(
                                    id,
                                    name,
                                    overview,
                                    poster_path.toString()
                                )
                            )
                        }
                    }
                    tvShowsResult.postValue(tvShowsList)
                }
            }
        })

        return tvShowsResult
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailEntity> {
        val tvShowDetailResult = MutableLiveData<DetailEntity>()

        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback {
            override fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?) {
                if (tvShowDetail != null) {
                    with(tvShowDetail) {
                        val listGenre = ArrayList<DetailEntity.Genre>()

                        for (genre in genres) {
                            listGenre.add(DetailEntity.Genre(genre.id, genre.name))
                        }

                        val detailTvShow = DetailEntity(
                            id = id,
                            title = name,
                            genres = listGenre,
                            releaseYear = firstAirDate,
                            tagline = tagline,
                            overview = overview,
                            popularity = popularity.toString(),
                            posterPath = posterPath ?: "empty"
                        )
                        tvShowDetailResult.postValue(detailTvShow)
                    }
                }
            }
        }, tvShowId)
        return tvShowDetailResult
    }
}