package com.practice.a20240123_murtazawali_nycschools.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel
import com.practice.a20240123_murtazawali_nycschools.repository.SchoolNameRepo

class SchoolViewModel : ViewModel() {

    private val schoolNameRepo: SchoolNameRepo = SchoolNameRepo()

    fun getSchoolName(): LiveData<List<SchoolModel>> {
        return schoolNameRepo.getSchoolName()
    }
}