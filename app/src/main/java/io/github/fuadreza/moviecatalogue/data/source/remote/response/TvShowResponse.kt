package io.github.fuadreza.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

class TvShowResponse (
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("results")
    var results: ArrayList<TvShow>? = null
){
    class TvShow(
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("name")
        var name: String = "",
        @SerializedName("overview")
        var overview: String = "",
        @SerializedName("poster_path")
        var poster_path: String? = null
    )
}