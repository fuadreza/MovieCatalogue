package io.github.fuadreza.moviecatalogue.ui.detail.tv_shows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import io.github.fuadreza.moviecatalogue.data.source.local.entity.DetailEntity
import io.github.fuadreza.moviecatalogue.data.source.MovieCatalogueRepository
import io.github.fuadreza.moviecatalogue.utils.DataDummy
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {

    private lateinit var viewModel: DetailTvShowViewModel
    private var dummyTvShow = DataDummy.getDetailTvShow()
    private var tvShowId = dummyTvShow.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var tvShowObserver: Observer<DetailEntity>

    @Before
    fun setup() {
        viewModel = DetailTvShowViewModel(movieCatalogueRepository)
        viewModel.setTvShowId(tvShowId)
    }

    @Test
    fun getTvShow() {
        val tvEntity = MutableLiveData<DetailEntity>()
        tvEntity.value = dummyTvShow

        `when`(movieCatalogueRepository.getDetailTvShow(tvShowId)).thenReturn(tvEntity)
        val detailEntity = viewModel.getDetailTvShow().value as DetailEntity
        verify(movieCatalogueRepository).getDetailTvShow(tvShowId)

        assertNotNull(detailEntity)
        assertEquals(dummyTvShow.id, detailEntity.id)
        assertEquals(dummyTvShow.title, detailEntity.title)
        assertEquals(dummyTvShow.tagline, detailEntity.tagline)

        viewModel.getDetailTvShow().observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}