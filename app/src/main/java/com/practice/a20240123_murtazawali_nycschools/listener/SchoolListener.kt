package com.practice.a20240123_murtazawali_nycschools.listener

import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel

interface SchoolListener {
    fun onSchoolClicked(schoolModel: SchoolModel)
}
