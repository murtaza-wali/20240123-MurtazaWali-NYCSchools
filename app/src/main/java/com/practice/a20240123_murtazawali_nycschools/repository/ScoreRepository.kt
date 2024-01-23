package com.practice.a20240123_murtazawali_nycschools.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel
import com.practice.a20240123_murtazawali_nycschools.model.ScoreModel

import com.practice.a20240123_murtazawali_nycschools.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ScoreRepository {
    private val apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun getScore(): LiveData<List<ScoreModel>> {
        val data = MutableLiveData<List<ScoreModel>>()

        apiService.scoreData().enqueue(object : Callback<List<ScoreModel>> {
            override fun onResponse(call: Call<List<ScoreModel>>, response: Response<List<ScoreModel>>) {
                data.value = response.body()
                Log.e("Status", "Score Working")
            }

            override fun onFailure(call: Call<List<ScoreModel>>, t: Throwable) {
                data.value = null
                Log.e("", "Not Working", t)
            }
        })

        return data
    }
}
