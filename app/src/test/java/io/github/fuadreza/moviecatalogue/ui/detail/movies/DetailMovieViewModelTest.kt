package io.github.fuadreza.moviecatalogue.ui.detail.movies


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify

import io.github.fuadreza.moviecatalogue.data.DetailEntity
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
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.getDetailMovie()
    private val movieId = dummyMovie.id

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieCatalogueRepository: MovieCatalogueRepository

    @Mock
    private lateinit var movieObserver: Observer<DetailEntity>

    @Before
    fun setup(){
        viewModel = DetailMovieViewModel(movieCatalogueRepository)
    }

    @Test
    fun getMovie() {
        val movieEntity = MutableLiveData<DetailEntity>()
        movieEntity.value = dummyMovie

        `when`(movieCatalogueRepository.getDetailMovie(movieId)).thenReturn(movieEntity)
        val detailEntity = viewModel.dataDetailMovie().value as DetailEntity
        verify(movieCatalogueRepository).getDetailMovie(movieId)

        assertNotNull(detailEntity)
        assertEquals(dummyMovie.id, detailEntity.id)
        assertEquals(dummyMovie.title, detailEntity.title)
        assertEquals(dummyMovie.tagline, detailEntity.tagline)

        viewModel.dataDetailMovie().observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }
}