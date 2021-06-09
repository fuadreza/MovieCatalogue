package io.github.fuadreza.moviecatalogue.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import io.github.fuadreza.moviecatalogue.data.source.remote.RemoteDataSource
import io.github.fuadreza.moviecatalogue.utils.DataDummy
import io.github.fuadreza.moviecatalogue.utils.LiveDataTestUtil
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieCatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)

    private val movieCatalogueRepository = FakeMovieCatalogueRepository(remote)

    private val moviesResponse = DataDummy.generateDummyMovies()
    private val movieId = moviesResponse[0].id
    private val movieDetail = DataDummy.generateDummyDetailMovies(movieId)

    private val tvShowResponse = DataDummy.generateDummyTvShow()
    private val tvShowId = tvShowResponse[0].id
    private val tvShowDetail = DataDummy.generateDummyDetailTvShow(tvShowId)

    @Test
    fun getMovies() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadMoviesCallback)
                .onMoviesLoaded(moviesResponse)
            null
        }.`when`(remote).getMovies(any())
        val movieEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getMovies())
        verify(remote).getMovies(any())
        assertNotNull(movieEntity)
        assertEquals(moviesResponse.size.toLong(), movieEntity.size.toLong())
    }

    @Test
    fun getDetailMovie() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadDetailMovieCallback)
                .onDetailMovieLoaded(movieDetail)
            null
        }.`when`(remote).getDetailMovie(any(), eq(movieId))

        val movieDetailEntity =
            LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailMovie(movieId))
        verify(remote).getDetailMovie(any(), eq(movieId))
        assertNotNull(movieDetailEntity)
        assertEquals(movieDetail.id, movieDetailEntity.id)
    }

    @Test
    fun getTvShows() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadTvShowsCallback)
                .onTvShowsLoaded(tvShowResponse)
            null
        }.`when`(remote).getTvShows(any())
        val tvShowEntity = LiveDataTestUtil.getValue(movieCatalogueRepository.getTvShows())
        verify(remote).getTvShows(any())
        assertNotNull(tvShowEntity)
        assertEquals(tvShowResponse.size.toLong(), tvShowEntity.size.toLong())
    }

    @Test
    fun getDetailTvShow() {
        doAnswer { invocationOnMock ->
            (invocationOnMock.arguments[0] as RemoteDataSource.LoadDetailTvShowCallback)
                .onDetailTvShowLoaded(tvShowDetail)
            null
        }.`when`(remote).getDetailTvShow(any(), eq(tvShowId))

        val tvShowDetailEntity =
            LiveDataTestUtil.getValue(movieCatalogueRepository.getDetailTvShow(tvShowId))
        verify(remote).getDetailTvShow(any(), eq(tvShowId))
        assertNotNull(tvShowDetailEntity)
        assertEquals(tvShowDetail.id, tvShowDetailEntity.id)
    }
}