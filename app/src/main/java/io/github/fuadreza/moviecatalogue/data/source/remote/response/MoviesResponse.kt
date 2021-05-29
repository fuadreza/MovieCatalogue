package io.github.fuadreza.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

class MoviesResponse (
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: ArrayList<Movie>? = null
){
    class Movie(
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("title")
        var title: String = "",
        @SerializedName("overview")
        var overview: String = "",
        @SerializedName("poster_path")
        var poster_path: String? = null
    )
}