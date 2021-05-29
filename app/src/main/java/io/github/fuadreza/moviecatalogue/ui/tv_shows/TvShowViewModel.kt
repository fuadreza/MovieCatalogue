package io.github.fuadreza.moviecatalogue.ui.tv_shows

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.MovieEntity
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShows(): ArrayList<TvShowEntity> = DataDummy.generateDummyTvShow()

}