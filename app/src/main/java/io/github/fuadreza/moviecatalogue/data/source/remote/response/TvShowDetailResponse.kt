package io.github.fuadreza.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

class TvShowDetailResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("first_air_date")
    var firstAirDate: String? = null,
    @SerializedName("genres")
    var genre: ArrayList<Genre>,
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Int? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null
){
    class Genre(
        @SerializedName("id")
        var id: Int? = null,
        @SerializedName("name")
        var name: String? = null
    )
}