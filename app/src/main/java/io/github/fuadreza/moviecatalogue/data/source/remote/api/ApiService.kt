package io.github.fuadreza.moviecatalogue.data.source.remote.api

import io.github.fuadreza.moviecatalogue.data.source.remote.response.MovieDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovies(
        @Query("api_key") apiKey: String
    ) : Call<MoviesResponse>

    @GET("movie/{id}")
    fun getMovieDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ) : Call<MovieDetailResponse>

    @GET("discover/tv")
    fun getTvShows(
        @Query("api_key") apiKey: String
    ) : Call<TvShowResponse>

    @GET("tv/{id}")
    fun getTvShowDetail(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String
    ) : Call<TvShowDetailResponse>

}