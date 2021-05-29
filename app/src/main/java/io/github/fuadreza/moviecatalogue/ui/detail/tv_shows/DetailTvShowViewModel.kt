package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {

    private lateinit var tvShowId: String

    fun setSelectedTvShow(tvShowId: String) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        val tvShowEntities = DataDummy.generateDummyTvShow()

        return tvShowEntities.single { m -> m.tvShowId == tvShowId }
    }

}