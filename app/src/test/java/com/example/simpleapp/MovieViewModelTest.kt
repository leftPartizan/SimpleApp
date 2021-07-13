package com.example.simpleapp

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.simpleapp.data.entities.People
import com.example.simpleapp.domain.entities.MovieFullModel
import com.example.simpleapp.domain.usecases.MovieUseCase
import com.example.simpleapp.ui.activity.fragments.movie.MovieViewModelImpl
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.observers.TestObserver
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.times
import org.mockito.kotlin.verify
import org.mockito.kotlin.verifyNoMoreInteractions
import org.mockito.kotlin.whenever


class MovieViewModelTest {

    @Rule
    @JvmField
    val timeoutRule = RxImmediateSchedulerRule()

    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    lateinit var viewModelImpl: MovieViewModelImpl

    @Mock
    private lateinit var testObserver: Observer<MovieFullModel>

    @Mock
    private lateinit var testObserverError: TestObserver<Throwable>

    @Mock
    private lateinit var useCase: MovieUseCase

    @Mock
    private lateinit var router: Router

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)

        viewModelImpl = MovieViewModelImpl(useCase, router)
        viewModelImpl.movie.observeForever(testObserver)
        viewModelImpl.error.observeForever { testObserverError.onNext(it) }
    }

    @Test
    fun `movie data load success`() {
        val movieId = "1"

        val people = mock(People::class.java).apply {
            whenever(id).thenReturn(1)
            whenever(name).thenReturn("a")
            whenever(height).thenReturn("120")
            whenever(mass).thenReturn("30")
            whenever(birthYear).thenReturn("25.08.1995")
            whenever(gender).thenReturn("m")
        }
        val fullMovieModel = mock(MovieFullModel::class.java).apply {
            whenever(title).thenReturn("title")
            whenever(episodeId).thenReturn("1")
            whenever(openingCrawl).thenReturn("title")
            whenever(producer).thenReturn("title")
            whenever(releaseDate).thenReturn("title")
            whenever(charactersInfo).thenReturn(listOf(people))
        }

        whenever(useCase.getMovieInfo(movieId)).thenReturn(Single.just(fullMovieModel))

        viewModelImpl.getMovie(movieId)
        verify(useCase, times(1)).getMovieInfo(movieId)
        verify(testObserver, times(1)).onChanged(fullMovieModel)
        verifyNoMoreInteractions(useCase, router)
    }

    @Test
    fun `movie data load failed`() {
        val movieId = "1"

        `when`(useCase.getMovieInfo(movieId)).thenReturn(Single.error(Throwable("error")))

        viewModelImpl.getMovie(movieId)
        verify(useCase, times(1)).getMovieInfo(movieId)
        testObserverError.assertError(Throwable("error"))
        verifyNoMoreInteractions(useCase, router)
    }
}