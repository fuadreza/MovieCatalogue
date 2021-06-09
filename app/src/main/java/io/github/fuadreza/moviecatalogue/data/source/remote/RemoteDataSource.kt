package io.github.fuadreza.moviecatalogue.data.source.remote

import android.util.Log
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.data.source.remote.api.ApiClient
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MovieDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowResponse
import io.github.fuadreza.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource()
            }
    }

    fun getMovies(callback: LoadMoviesCallback) {
        EspressoIdlingResource.increment()
        val client = ApiClient.getApiService().getMovies(BuildConfig.API_KEY)
        client.enqueue(object : Callback<MoviesResponse> {
            override fun onResponse(
                call: Call<MoviesResponse>,
                response: Response<MoviesResponse>
            ) {
                callback.onMoviesLoaded(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailMovie(callback: LoadDetailMovieCallback, movieId: Int) {
        EspressoIdlingResource.increment()
        val client = ApiClient.getApiService().getMovieDetail(movieId, BuildConfig.API_KEY)
        client.enqueue(object : Callback<MovieDetailResponse> {
            override fun onResponse(
                call: Call<MovieDetailResponse>,
                response: Response<MovieDetailResponse>
            ) {
                callback.onDetailMovieLoaded(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getTvShows(callback: LoadTvShowsCallback) {
        EspressoIdlingResource.increment()
        val client = ApiClient.getApiService().getTvShows(BuildConfig.API_KEY)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                callback.onTvShowsLoaded(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    fun getDetailTvShow(callback: LoadDetailTvShowCallback, tvShowId: Int) {
        EspressoIdlingResource.increment()
        val client = ApiClient.getApiService().getTvShowDetail(tvShowId, BuildConfig.API_KEY)
        client.enqueue(object : Callback<TvShowDetailResponse> {
            override fun onResponse(
                call: Call<TvShowDetailResponse>,
                response: Response<TvShowDetailResponse>
            ) {
                callback.onDetailTvShowLoaded(response.body())
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowDetailResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailTvShow onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies: ArrayList<MoviesResponse.Movie>?)
    }

    interface LoadDetailMovieCallback {
        fun onDetailMovieLoaded(movieDetail: MovieDetailResponse?)
    }

    interface LoadTvShowsCallback {
        fun onTvShowsLoaded(tvShows: ArrayList<TvShowResponse.TvShow>?)
    }

    interface LoadDetailTvShowCallback {
        fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?)
    }
}