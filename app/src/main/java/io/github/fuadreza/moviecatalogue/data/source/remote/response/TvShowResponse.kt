package io.github.fuadreza.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

class TvShowResponse (
    @SerializedName("page")
    var page: Int,
    @SerializedName("results")
    var results: ArrayList<TvShow>? = null,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
){
    class TvShow(
        @SerializedName("id")
        var id: Int,
        @SerializedName("name")
        var name: String,
        @SerializedName("first_air_date")
        var firstAirDate: String,
        @SerializedName("genres")
        var genres: ArrayList<Genre>,
        @SerializedName("tagline")
        var tagline: String,
        @SerializedName("overview")
        var overview: String,
        @SerializedName("popularity")
        var popularity: Double,
        @SerializedName("poster_path")
        var posterPath: String? = null
    ){
        class Genre(
            @SerializedName("id")
            var id: Int,
            @SerializedName("name")
            var name: String
        )
    }
}