package io.github.fuadreza.moviecatalogue.utils

import io.github.fuadreza.moviecatalogue.data.source.local.entity.MovieEntity
import io.github.fuadreza.moviecatalogue.data.source.local.entity.TvShowEntity
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MovieDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.MoviesResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowDetailResponse
import io.github.fuadreza.moviecatalogue.data.source.remote.response.TvShowResponse

object DataDummy {

    fun generateDummyMovies(): ArrayList<MoviesResponse.Movie> {
        val zeroMovie = ArrayList<MoviesResponse.Movie>()

        return zeroMovie
    }

    fun generateDummyTvShow(): ArrayList<TvShowResponse.TvShow> {
        val zeroTvShow = ArrayList<TvShowResponse.TvShow>()

        return zeroTvShow
    }

    fun getMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

        movies.add(
            MovieEntity(
                337404,
                "tagline",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
                "2021-05-26",
                "Cruella",
                4373.846,
            )
        )

        movies.add(
            MovieEntity(
                385128,
                "tagline",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
                "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
                "2021-05-19",
                "F9",
                4560.866,
            )
        )

        movies.add(
            MovieEntity(
                399566,
                "tagline",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
                "2021-03-24",
                "Godzilla vs. Kong",
                1745.979,
            )
        )

        return movies
    }

    fun getDetailMovie(): MovieEntity {
        return MovieEntity(
            337404,
            "tagline",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
            "2021-05-26",
            "Cruella",
            4373.846,
        )
    }

    fun getTvShows(): ArrayList<TvShowEntity> {
        val tvShows = ArrayList<TvShowEntity>()

        tvShows.add(
            TvShowEntity(
                1399,
                "Nice",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
                "2011-04-17",
                "Game of Thrones",
                499.131,
            )
        )

        tvShows.add(
            TvShowEntity(
                60625,
                "Yoo",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                "/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
                "2013-12-02",
                "Rick and Morty",
                968.583,
            )
        )

        tvShows.add(
            TvShowEntity(
                60735,
                "Wush",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
                "2014-10-07",
                "The Flash",
                1071.493,
            )
        )

        return tvShows
    }

    fun getDetailTvShow(): TvShowEntity {
        return TvShowEntity(
            1399,
            "Nice",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            "2011-04-17",
            "Game of Thrones",
            499.131,
        )
    }

    fun getRemoteMovies(): List<MoviesResponse.Movie> {
        val genres = ArrayList<MoviesResponse.Movie.Genre>()
        genres.add(
            MoviesResponse.Movie.Genre(
                1,
                "Adventure"
            )
        )

        genres.add(
            MoviesResponse.Movie.Genre(
                2,
                "Action"
            )
        )

        return listOf(
            MoviesResponse.Movie(
                337404,
                "Cruella",
                genres,
                "2021-05-26",
                "tagline",
                "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
                4373.846,
                "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
            ),
            MoviesResponse.Movie(
                385128,
                "F9",
                genres,
                "2021-05-19",
                "tagline",
                "Dominic Toretto and his crew battle the most skilled assassin and high-performance driver they've ever encountered: his forsaken brother.",
                4560.866,
                "/bOFaAXmWWXC3Rbv4u4uM9ZSzRXP.jpg",
            ),
            MoviesResponse.Movie(
                399566,
                "Godzilla vs. Kong",
                genres,
                "2021-03-24",
                "tagline",
                "In a time when monsters walk the Earth, humanity’s fight for its future sets Godzilla and Kong on a collision course that will see the two most powerful forces of nature on the planet collide in a spectacular battle for the ages.",
                1745.979,
                "/pgqgaUx1cJb5oZQQ5v0tNARCeBp.jpg",
            )
        )
    }

    fun getRemoteTvShows(): List<TvShowResponse.TvShow> {
        val genres = ArrayList<TvShowResponse.TvShow.Genre>()
        genres.add(
            TvShowResponse.TvShow.Genre(
                1,
                "Adventure"
            )
        )

        genres.add(
            TvShowResponse.TvShow.Genre(
                2,
                "Action"
            )
        )

        return listOf(
            TvShowResponse.TvShow(
                1399,
                "Game of Thrones",
                "2011-04-17",
                genres,
                "Nice",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                499.131,
                "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
            ),
            TvShowResponse.TvShow(
                60625,
                "Rick and Morty",
                "2013-12-02",
                genres,
                "Yoo",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                968.583,
                "/8kOWDBK6XlPUzckuHDo3wwVRFwt.jpg",
            ),
            TvShowResponse.TvShow(
                60735,
                "The Flash",
                "2014-10-07",
                genres,
                "Wush",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                1071.493,
                "/lJA2RCMfsWoskqlQhXPSLFQGXEJ.jpg",
            ),
        )
    }

    fun getRemoteDetailMovie(): MovieDetailResponse {
        val genres = ArrayList<MovieDetailResponse.Genre>()
        genres.add(
            MovieDetailResponse.Genre(
                1,
                "Adventure"
            )
        )

        genres.add(
            MovieDetailResponse.Genre(
                2,
                "Action"
            )
        )

        return MovieDetailResponse(
            337404,
            "Cruella",
            genres,
            "2021-05-26",
            "tagline",
            "In 1970s London amidst the punk rock revolution, a young grifter named Estella is determined to make a name for herself with her designs. She befriends a pair of young thieves who appreciate her appetite for mischief, and together they are able to build a life for themselves on the London streets. One day, Estella’s flair for fashion catches the eye of the Baroness von Hellman, a fashion legend who is devastatingly chic and terrifyingly haute. But their relationship sets in motion a course of events and revelations that will cause Estella to embrace her wicked side and become the raucous, fashionable and revenge-bent Cruella.",
            4373.846,
            "/rTh4K5uw9HypmpGslcKd4QfHl93.jpg",
        )
    }

    fun getRemoteDetailTvShow(): TvShowDetailResponse {
        val genres = ArrayList<TvShowDetailResponse.Genre>()
        genres.add(
            TvShowDetailResponse.Genre(
                1,
                "Adventure"
            )
        )

        genres.add(
            TvShowDetailResponse.Genre(
                2,
                "Action"
            )
        )

        return TvShowDetailResponse(
            1399,
            "Game of Thrones",
            "2011-04-17",
            genres,
            "Nice",
            "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
            499.131,
            "/u3bZgnGQ9T01sWNhyveQz0wH0Hl.jpg",
        )
    }
}