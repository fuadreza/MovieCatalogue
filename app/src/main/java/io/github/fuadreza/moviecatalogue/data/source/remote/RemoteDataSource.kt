package io.github.fuadreza.moviecatalogue.data.source.remote

import android.util.Log
import io.github.fuadreza.moviecatalogue.BuildConfig
import io.github.fuadreza.moviecatalogue.data.source.remote.api.ApiClient
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
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
            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                callback.onMoviesLoaded(response.body()?.results)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })
    }

    interface LoadMoviesCallback {
        fun onMoviesLoaded(movies : ArrayList<MoviesResponse.Movie>?)
    }

//    interface LoadDetailMovieCallback {
//        fun onDetailMovieLoaded(movieDetail : MovieDetailResponse?)
//    }
//
//    interface LoadTvShowsCallback {
//        fun onTvShowsLoaded(tvShows : List<TvShow>?)
//    }
//
//    interface LoadDetailTvShowCallback {
//        fun onDetailTvShowLoaded(tvShowDetail: TvShowDetailResponse?)
//    }
}