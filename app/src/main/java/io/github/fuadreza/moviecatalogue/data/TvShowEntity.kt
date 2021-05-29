package io.github.fuadreza.moviecatalogue.data

data class TvShowEntity (
    var tvShowId: String,
    var title: String,
    var releaseYear: String,
    var tagline: String,
    var overview: String,
    var genre: List<Genre>,
    var duration: String,
    var score: String,
    var imagePath: String
){
    data class Genre(
        var name: String
    )
}