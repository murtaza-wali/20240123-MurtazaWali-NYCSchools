package com.practice.a20240123_murtazawali_nycschools

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel
import com.practice.a20240123_murtazawali_nycschools.repository.SchoolNameRepo
import com.practice.a20240123_murtazawali_nycschools.view.SchoolViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SchoolViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var viewModel: SchoolViewModel
    private lateinit var repository: SchoolNameRepo

    @Before
    fun setUp() {
        repository = mock()
        viewModel = SchoolViewModel(repository)
    }

    @Test
    fun `test getSchoolName`() {
        val observer: Observer<List<SchoolModel>> = mock()

        // Attach observer
        viewModel.getSchoolName().observeForever(observer)



        // Verify that the observer was notified
        verify(observer).onChanged(any())
    }
}
