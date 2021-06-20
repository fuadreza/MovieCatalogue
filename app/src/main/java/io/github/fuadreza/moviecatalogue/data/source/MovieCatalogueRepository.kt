package io.github.fuadreza.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.github.fuadreza.moviecatalogue.data.source.local.LocalDataSource
import io.github.fuadreza.moviecatalogue.data.source.local.entity.MovieEntity
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource
import io.github.fuadreza.moviecatalogue.data.source.remote.api.ApiResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MovieDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowResponse
import io.github.fuadreza.moviecatalogue.data.vo.Resource
import io.github.fuadreza.moviecatalogue.utils.AppExecutors

class MovieCatalogueRepository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) :
    MovieCatalogueDataSource {
    companion object {
        @Volatile
        private var instance: MovieCatalogueRepository? = null
        fun getInstance(
            remoteData: RemoteDataSource,
            localDataSource: LocalDataSource,
            appExecutors: AppExecutors
        ): MovieCatalogueRepository =
            instance ?: synchronized(this) {
                instance ?: MovieCatalogueRepository(remoteData, localDataSource, appExecutors)
            }
    }

    //    override fun getMovies(): LiveData<ArrayList<MovieEntity>> {
//        val movieResult = MutableLiveData<ArrayList<MovieEntity>>()
//
//        remoteDataSource.getMovies(object : RemoteDataSource.LoadMoviesCallback {
//            override fun onMoviesLoaded(movies: ArrayList<MoviesResponse.Movie>?) {
//                val movieList = ArrayList<MovieEntity>()
//                if (movies != null) {
//                    for (response in movies) {
//                        with(response) {
//                            val poster = poster_path ?: ""
//                            val movie = MovieEntity(id, title, overview, poster)
//                            movieList.add(movie)
//                        }
//                    }
//                    movieResult.postValue(movieList)
//                }
//            }
//        })
//        return movieResult
//    }

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object :
            NetworkBoundResource<PagedList<MovieEntity>, List<MoviesResponse.Movie>>(appExecutors) {

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesResponse.Movie>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<MoviesResponse.Movie>) {
                val movieList = ArrayList<MovieEntity>()
                for (response in data) {
                    val movie = MovieEntity(
                        id = response.id,
                        tagline = response.tagline ?: "",
                        overview = response.overview ?: "",
                        posterPath = response.posterPath ?: "",
                        releaseDate = response.releaseDate ?: "",
                        title = response.title,
                        popularity = response.popularity,
                        isFav = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }

            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }
        }.asLiveData()
    }

//    override fun getTvShows(): LiveData<ArrayList<TvShowEntity>> {
//        val tvShowResult = MutableLiveData<ArrayList<TvShowEntity>>()
//
//        remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowsCallback {
//            override fun onTvShowsLoaded(tvShows: ArrayList<TvShowResponse.TvShow>?) {
//                val tvShowList = ArrayList<TvShowEntity>()
//                if (tvShows != null) {
//                    for (response in tvShows) {
//                        with(response) {
//                            val poster = poster_path ?: ""
//                            val tvShow = TvShowEntity(id, name, overview, poster)
//                            tvShowList.add(tvShow)
//                        }
//                    }
//                    tvShowResult.postValue(tvShowList)
//                }
//            }
//        })
//        return tvShowResult
//    }

    override fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object :
            NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowResponse.TvShow>>(appExecutors) {

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowResponse.TvShow>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<TvShowResponse.TvShow>) {
                val movieList = ArrayList<TvShowEntity>()
                for (response in data) {
                    val movie = TvShowEntity(
                        id = response.id,
                        overview = response.overview,
                        tagline = response.tagline,
                        posterPath = response.posterPath ?: "",
                        firstAirDate = response.firstAirDate,
                        name = response.name,
                        popularity = response.popularity,
                        isFav = false
                    )
                    movieList.add(movie)
                }
                localDataSource.insertTvShows(movieList)
            }

            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }
        }.asLiveData()
    }

//    override fun getDetailMovie(movieId: Int): LiveData<DetailEntity> {
//        val movieResult = MutableLiveData<DetailEntity>()
//
//        remoteDataSource.getDetailMovie(object : RemoteDataSource.LoadDetailMovieCallback {
//            override fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?) {
//                if (movieDetail != null) {
//                    with(movieDetail) {
//                        val listGenres = ArrayList<DetailEntity.Genre>()
//
//                        for (genre in genres) {
//                            listGenres.add(DetailEntity.Genre(genre.id, genre.name))
//                        }
//
//                        val detailMovie = DetailEntity(
//                            id = id,
//                            title = title,
//                            genres = listGenres,
//                            releaseYear = releaseYear ?: "empty",
//                            tagline = tagline ?: "empty",
//                            overview = overview ?: "empty",
//                            popularity = popularity.toString(),
//                            posterPath = posterPath ?: "empty"
//                        )
//                        movieResult.postValue(detailMovie)
//                    }
//                }
//            }
//        }, movieId)
//        return movieResult
//    }

    override fun getDetailMovie(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MovieDetailResponse>(appExecutors) {

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data != null && data.popularity == 0.0

            override fun createCall(): LiveData<ApiResponse<MovieDetailResponse>> =
                remoteDataSource.getDetailMovie(movieId)

            override fun saveCallResult(data: MovieDetailResponse) {
                val genres = StringBuilder().append("")

                for (i in data.genres.indices) {
                    if (i < data.genres.size - 1) {
                        genres.append("${data.genres[i].name}, ")
                    } else {
                        genres.append(data.genres[i].name)
                    }
                }

                val movie = MovieEntity(
                    id = data.id,
                    tagline = data.tagline ?: "",
                    overview = data.overview ?: "",
                    posterPath = data.posterPath ?: "",
                    releaseDate = data.releaseDate ?: "",
                    title = data.title,
                    popularity = data.popularity,
                    isFav = false
                )
                localDataSource.updateMovie(movie, false)
            }

            override fun loadFromDB(): LiveData<MovieEntity> = localDataSource.getMovieById(movieId)
        }.asLiveData()
    }

//    override fun getDetailTvShow(tvShowId: Int): LiveData<DetailEntity> {
//        val tvShowResult = MutableLiveData<DetailEntity>()
//
//        remoteDataSource.getDetailTvShow(object : RemoteDataSource.LoadDetailTvShowCallback {
//            override fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?) {
//                if (tvShowDetail != null) {
//                    with(tvShowDetail) {
//                        val listGenres = ArrayList<DetailEntity.Genre>()
//
//                        for (genre in genres) {
//                            listGenres.add(DetailEntity.Genre(genre.id, genre.name))
//                        }
//
//                        val detailTvShow = DetailEntity(
//                            id = id,
//                            title = name,
//                            genres = listGenres,
//                            releaseYear = firstAirDate,
//                            tagline = tagline,
//                            overview = overview,
//                            popularity = popularity.toString(),
//                            posterPath = posterPath ?: "empty"
//                        )
//                        tvShowResult.postValue(detailTvShow)
//                    }
//                }
//            }
//        }, tvShowId)
//        return tvShowResult
//    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowDetailResponse>(appExecutors) {
            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data != null && data.popularity == 0.0

            override fun createCall(): LiveData<ApiResponse<TvShowDetailResponse>> =
                remoteDataSource.getDetailTvShow(tvShowId)

            override fun saveCallResult(data: TvShowDetailResponse) {
                val genres = StringBuilder().append("")

                for (i in data.genres.indices) {
                    if (i < data.genres.size - 1) {
                        genres.append("${data.genres[i].name}, ")
                    } else {
                        genres.append(data.genres[i].name)
                    }
                }

                val tvShow = TvShowEntity(
                    id = data.id,
                    tagline = data.tagline,
                    overview = data.overview,
                    posterPath = data.posterPath ?: "",
                    firstAirDate = data.firstAirDate,
                    name = data.name,
                    popularity = data.popularity,
                    isFav = false
                )
                localDataSource.updateTvShow(tvShow, false)
            }

            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getTvShowById(tvShowId)
        }.asLiveData()
    }


    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovie(movie, state)
        }
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavTvShows(), config).build()
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteTvShow(tvShow, state)
        }
    }
}