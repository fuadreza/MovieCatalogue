package io.github.fuadreza.moviecatalogue.data

class DetailEntity (
    var id: Int,
    var title: String,
    var genres: ArrayList<Genre>,
    var releaseYear: String,
    var tagline: String,
    var overview: String,
    var popularity: String,
    var posterPath: String,
){
    class Genre(
        var id: Int,
        var name: String
    )
}