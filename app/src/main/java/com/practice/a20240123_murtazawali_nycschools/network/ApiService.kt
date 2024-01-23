package com.practice.a20240123_murtazawali_nycschools.network

import android.telecom.Call
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel
import com.practice.a20240123_murtazawali_nycschools.model.ScoreModel
import retrofit2.http.GET

interface ApiService {

    //school list
    @GET("s3k6-pzi2.json")
    fun fetchData(): retrofit2.Call<List<SchoolModel>>

    //Score list

    @GET("f9bf-2cp4.json")
    fun scoreData(): retrofit2.Call<List<ScoreModel>>



}


