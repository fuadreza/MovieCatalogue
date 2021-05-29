package io.github.fuadreza.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

class MovieDetailResponse(
    @SerializedName("id")
    var id: Int? = null,
    @SerializedName("title")
    var title: String? = null,
    @SerializedName("release_year")
    var releaseYear: String? = null,
    @SerializedName("tagline")
    var tagline: String? = null,
    @SerializedName("overview")
    var overview: String? = null,
    @SerializedName("popularity")
    var popularity: Int? = null,
    @SerializedName("poster_path")
    var posterPath: String? = null
)