package io.github.fuadreza.moviecatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import io.github.fuadreza.moviecatalogue.R
import io.github.fuadreza.moviecatalogue.utils.DataDummy
import org.junit.Rule
import org.junit.Test

class HomeActivityTest {
    private val dummyMovie = DataDummy.generateDummyMovies()
    private val dummyTvShow = DataDummy.generateDummyTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(HomeActivity::class.java)

    @Test
    fun loadMovie() {
        onView(withId(R.id.rv_movie)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyMovie.size))
    }

    @Test
    fun loadDetailMovie() {
        onView(withId(R.id.rv_movie)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyMovie[0].title)))
        onView(withId(R.id.tvReleaseYear)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseYear)).check(matches(withText(dummyMovie[0].releaseYear)))
        onView(withId(R.id.tvTagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTagline)).check(matches(withText(dummyMovie[0].tagline)))
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyMovie[0].overview)))
        onView(withId(R.id.tvDuration)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDuration)).check(matches(withText(dummyMovie[0].duration)))
        onView(withId(R.id.tvScore)).check(matches(isDisplayed()))
        onView(withId(R.id.tvScore)).check(matches(withText(dummyMovie[0].score)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
    }

    @Test
    fun loadTvShow(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dummyTvShow.size))
    }

    @Test
    fun loadDetailTvShow(){
        onView(withText("TV Show")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tvTitle)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTitle)).check(matches(withText(dummyTvShow[0].title)))
        onView(withId(R.id.tvReleaseYear)).check(matches(isDisplayed()))
        onView(withId(R.id.tvReleaseYear)).check(matches(withText(dummyTvShow[0].releaseYear)))
        onView(withId(R.id.tvTagline)).check(matches(isDisplayed()))
        onView(withId(R.id.tvTagline)).check(matches(withText(dummyTvShow[0].tagline)))
        onView(withId(R.id.tvOverview)).check(matches(isDisplayed()))
        onView(withId(R.id.tvOverview)).check(matches(withText(dummyTvShow[0].overview)))
        onView(withId(R.id.tvDuration)).check(matches(isDisplayed()))
        onView(withId(R.id.tvDuration)).check(matches(withText(dummyTvShow[0].duration)))
        onView(withId(R.id.tvScore)).check(matches(isDisplayed()))
        onView(withId(R.id.tvScore)).check(matches(withText(dummyTvShow[0].score)))
        onView(withId(R.id.tvGenre)).check(matches(isDisplayed()))
    }

}