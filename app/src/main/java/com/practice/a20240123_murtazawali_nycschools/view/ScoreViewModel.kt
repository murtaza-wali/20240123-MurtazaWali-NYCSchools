package com.practice.a20240123_murtazawali_nycschools.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel
import com.practice.a20240123_murtazawali_nycschools.model.ScoreModel
import com.practice.a20240123_murtazawali_nycschools.repository.SchoolNameRepo
import com.practice.a20240123_murtazawali_nycschools.repository.ScoreRepository

class ScoreViewModel : ViewModel() {

    private val scoreRepository: ScoreRepository = ScoreRepository()

    fun getScore(dbn: String): LiveData<List<ScoreModel>>{
        return scoreRepository.getScore()
    }
}