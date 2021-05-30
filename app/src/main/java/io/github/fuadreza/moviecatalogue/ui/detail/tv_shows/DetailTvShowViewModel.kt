package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import androidx.lifecycle.ViewModel
import io.github.fuadreza.moviecatalogue.data.TvShowEntity
import io.github.fuadreza.moviecatalogue.utils.DataDummy

class DetailTvShowViewModel : ViewModel() {

    private var tvShowId: Int? = null

    fun setSelectedTvShow(tvShowId: Int) {
        this.tvShowId = tvShowId
    }

    fun getTvShow(): TvShowEntity {
        val tvShowEntities = DataDummy.generateDummyTvShow()

        return tvShowEntities.single { m -> m.id == tvShowId }
    }

}