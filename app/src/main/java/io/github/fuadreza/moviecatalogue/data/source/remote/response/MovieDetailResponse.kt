package io.github.fuadreza.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

class MovieDetailResponse(
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("genres")
    var genres: ArrayList<Genre>,
    @SerializedName("release_date")
    var releaseDate: String? = null,
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
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