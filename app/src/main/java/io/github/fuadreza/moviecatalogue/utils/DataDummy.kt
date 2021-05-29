package io.github.fuadreza.moviecatalogue.utils

import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.TvShowEntity

object DataDummy {

    fun generateDummyMovies(): ArrayList<MovieEntity> {
        val movies = ArrayList<MovieEntity>()

//        movies.add(
//            MovieEntity("399579",
//            "Alita: Battle Angel",
//            "2019",
//            "An angel falls. A warrior rises.",
//            "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
//            listOf(MovieEntity.Genre("Adventure"), MovieEntity.Genre("Action"), MovieEntity.Genre("Science Fiction")),
//            "2h 2m",
//            "72",
//            "poster/movies/poster_alita.jpg")
//        )
//
//        movies.add(
//            MovieEntity("332562",
//                "A Star Is Born",
//                "2018",
//                "",
//                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
//                listOf(MovieEntity.Genre("Drama"), MovieEntity.Genre("Romance"), MovieEntity.Genre("Music")),
//                "2h 16m",
//                "75",
//                "poster/movies/poster_a_start_is_born.jpg")
//        )
//
//        movies.add(
//            MovieEntity("297802",
//                "Aquaman",
//                "2018",
//                "Home Is Calling",
//                "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
//                listOf(MovieEntity.Genre("Adventure"), MovieEntity.Genre("Action"), MovieEntity.Genre("Fantasy")),
//                "2h 23m",
//                "69",
//                "poster/movies/poster_aquaman.jpg")
//        )
//
//        movies.add(
//            MovieEntity("424694",
//                "Bohemian Rhapsody",
//                "2018",
//                "Fearless lives forever",
//                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
//                listOf(MovieEntity.Genre("Music"), MovieEntity.Genre("Drama"), MovieEntity.Genre("History")),
//                "2h 15m",
//                "80",
//                "poster/movies/poster_bohemian.jpg")
//        )
//
//        movies.add(
//            MovieEntity("438650",
//                "Cold Pursuit",
//                "2019",
//                "Meet Nels Coxman. Citizen of the Year.",
//                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
//                listOf(MovieEntity.Genre("Crime"), MovieEntity.Genre("Action"), MovieEntity.Genre("Thriller")),
//                "1h 59m",
//                "57",
//                "poster/movies/poster_cold_persuit.jpg")
//        )
//
//        movies.add(
//            MovieEntity("312221",
//                "Creed",
//                "2015",
//                "Your legacy is more than a name",
//                "The former World Heavyweight Champion Rocky Balboa serves as a trainer and mentor to Adonis Johnson, the son of his late friend and former rival Apollo Creed.",
//                listOf(MovieEntity.Genre("Drama")),
//                "2h 13m",
//                "74",
//                "poster/movies/poster_creed.jpg")
//        )
//
//        movies.add(
//            MovieEntity("338952",
//                "Fantastic Beasts: The Crimes of Grindelwald",
//                "2018",
//                "Fate of One. Future of All.",
//                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
//                listOf(MovieEntity.Genre("Adventure"), MovieEntity.Genre("Fantasy"), MovieEntity.Genre("Drama")),
//                "2h 14m",
//                "69",
//                "poster/movies/poster_crimes.jpg")
//        )
//
//        movies.add(
//            MovieEntity("450465",
//                "Glass",
//                "2019",
//                "You Cannot Contain What You Are",
//                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
//                listOf(MovieEntity.Genre("Thriller"), MovieEntity.Genre("Drama"), MovieEntity.Genre("Science Fiction")),
//                "2h 9m",
//                "67",
//                "poster/movies/poster_glass.jpg")
//        )
//
//        movies.add(
//            MovieEntity("166428",
//                "How to Train Your Dragon: The Hidden World",
//                "2019",
//                "The friendship of a lifetime",
//                "As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.",
//                listOf(MovieEntity.Genre("Animation"), MovieEntity.Genre("Family"), MovieEntity.Genre("Adventure")),
//                "1h 44m",
//                "78",
//                "poster/movies/poster_how_to_train.jpg")
//        )
//
//        movies.add(
//            MovieEntity("299536",
//                "Avengers: Infinity War",
//                "2018",
//                "An entire universe. Once and for all.",
//                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
//                listOf(MovieEntity.Genre("Adventure"), MovieEntity.Genre("Action"), MovieEntity.Genre("Science Fiction")),
//                "2h 29m",
//                "83",
//                "poster/movies/poster_infinity_war.jpg")
//        )

        return movies
    }

    fun generateDummyTvShow(): ArrayList<TvShowEntity> {
        val shows = ArrayList<TvShowEntity>()

        shows.add(
            TvShowEntity("1412",
                "Arrow",
                "2012",
                "Heroes fall. Legends rise.",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "66",
                "poster/tv_shows/poster_arrow.jpg")
        )

        shows.add(
            TvShowEntity("79501",
                "Doom Patrol",
                "2019",
                "",
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                listOf(TvShowEntity.Genre("Sci-Fi"), TvShowEntity.Genre("Comedy"), TvShowEntity.Genre("Drama")),
                "49m",
                "76",
                "poster/tv_shows/poster_doom_patrol.jpg")
        )

        shows.add(
            TvShowEntity("12609",
                "Dragon Ball",
                "1986",
                "",
                "Long ago in the mountains, a fighting master known as Gohan discovered a strange boy whom he named Goku. Gohan raised him and trained Goku in martial arts until he died. The young and very strong boy was on his own, but easily managed. Then one day, Goku met a teenage girl named Bulma, whose search for the mystical Dragon Balls brought her to Goku's home. Together, they set off to find all seven and to grant her wish.",
                listOf(TvShowEntity.Genre("Animation"), TvShowEntity.Genre("Comedy"), TvShowEntity.Genre("Science Fiction")),
                "25m",
                "81",
                "poster/tv_shows/poster_dragon_ball.jpg")
        )

        shows.add(
            TvShowEntity("46261",
                "Fairy Tail",
                "2009",
                "Fairy Tail",
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                listOf(TvShowEntity.Genre("Adventure"), TvShowEntity.Genre("Animation"), TvShowEntity.Genre("Comedy")),
                "25m",
                "78",
                "poster/tv_shows/poster_fairytail.jpg")
        )

        shows.add(
            TvShowEntity("1434",
                "Family Guy",
                "1999",
                "Parental Discretion Advised, that's how you know it's good",
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "66",
                "poster/tv_shows/poster_family_guy.jpg")
        )

        shows.add(
            TvShowEntity("60735",
                "The Flash",
                "2014",
                "The fastest man alive.",
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \"meta-human\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "77",
                "poster/tv_shows/poster_flash.jpg")
        )

        shows.add(
            TvShowEntity("1399",
                "Game of Thrones",
                "2011",
                "Winter Is Coming",
                "Seven noble families fight for control of the mythical land of Westeros. Friction between the houses leads to full-scale war. All while a very ancient evil awakens in the farthest north. Amidst the war, a neglected military order of misfits, the Night's Watch, is all that stands between the realms of men and icy horrors beyond.",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "84",
                "poster/tv_shows/poster_god.jpg")
        )

        shows.add(
            TvShowEntity("60708",
                "Gotham",
                "2014",
                "Before Batman, there was Gotham.",
                "Everyone knows the name Commissioner Gordon. He is one of the crime world's greatest foes, a man whose reputation is synonymous with law and order. But what is known of Gordon's story and his rise from rookie detective to Police Commissioner? What did it take to navigate the multiple layers of corruption that secretly ruled Gotham City, the spawning ground of the world's most iconic villains? And what circumstances created them – the larger-than-life personas who would become Catwoman, The Penguin, The Riddler, Two-Face and The Joker?",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "75",
                "poster/tv_shows/poster_gotham.jpg")
        )

        shows.add(
            TvShowEntity("1416",
                "Grey's Anatomy",
                "2005",
                "The life you save may be your own.",
                "Follows the personal and professional lives of a group of doctors at Seattle’s Grey Sloan Memorial Hospital.",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "82",
                "poster/tv_shows/poster_grey_anatomy.jpg")
        )

        shows.add(
            TvShowEntity("54155",
                "Hanna",
                "2019",
                "",
                "This thriller and coming-of-age drama follows the journey of an extraordinary young girl as she evades the relentless pursuit of an off-book CIA agent and tries to unearth the truth behind who she is. Based on the 2011 Joe Wright film.",
                listOf(TvShowEntity.Genre("Crime"), TvShowEntity.Genre("Drama"), TvShowEntity.Genre("Mystery")),
                "42m",
                "75",
                "poster/tv_shows/poster_hanna.jpg")
        )

        return shows
    }
}