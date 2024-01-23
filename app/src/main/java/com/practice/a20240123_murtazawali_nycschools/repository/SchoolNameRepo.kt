package com.practice.a20240123_murtazawali_nycschools.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel

import com.practice.a20240123_murtazawali_nycschools.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SchoolNameRepo {
    private val apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)

    fun getSchoolName(): LiveData<List<SchoolModel>> {
        val data = MutableLiveData<List<SchoolModel>>()

        apiService.fetchData().enqueue(object : Callback<List<SchoolModel>> {
            override fun onResponse(call: Call<List<SchoolModel>>, response: Response<List<SchoolModel>>) {
                data.value = response.body()
                Log.e("Status", "Working")
            }

            override fun onFailure(call: Call<List<SchoolModel>>, t: Throwable) {
                data.value = null
                Log.e("", "Not Working", t)
            }
        })

        return data
    }
}
