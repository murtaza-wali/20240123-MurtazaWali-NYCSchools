package com.practice.a20240123_murtazawali_nycschools

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.practice.a20240123_murtazawali_nycschools.adapter.SchoolModelAdapter
import com.practice.a20240123_murtazawali_nycschools.databinding.ActivityMainBinding
import com.practice.a20240123_murtazawali_nycschools.listener.SchoolListener
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel
import com.practice.a20240123_murtazawali_nycschools.view.SchoolViewModel

class MainActivity : AppCompatActivity(), SchoolListener {

    private lateinit var viewModel: SchoolViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    private lateinit var schoolModelAdapter: SchoolModelAdapter
    private val schoolModelList: MutableList<SchoolModel> = mutableListOf()

    private var currentPage = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        initViewModel()
        init()
    }

    private fun initViewModel() {
        viewModel = ViewModelProvider(this).get(SchoolViewModel::class.java)
    }

    private fun init() {
        setupRecyclerView()



        getSchoolNames()
    }

    private fun setupRecyclerView() {
        activityMainBinding.tvShowRecyclerView.setHasFixedSize(true)
        schoolModelAdapter = SchoolModelAdapter(this
                ,schoolModelList)
        activityMainBinding.tvShowRecyclerView.adapter = schoolModelAdapter
    }

    private fun getSchoolNames() {
        toggleLoading()
        viewModel.getSchoolName().observe(this, Observer { schoolModel ->
            toggleLoading()
            schoolModel?.let { shows ->
                schoolModelList.addAll(shows)
                schoolModelAdapter.notifyDataSetChanged()
                //showToast("Showing")
            }
        })
    }

    private fun toggleLoading() {
        if (currentPage == 1) {
            activityMainBinding.isloading = activityMainBinding.isloading != true
        } else {
            activityMainBinding.isloadingMore = activityMainBinding.isloadingMore != true
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSchoolClicked(school: SchoolModel) {
        val intent = Intent(applicationContext, SchoolDetailActivity::class.java)
        intent.putExtra("school", school)
        startActivity(intent)
    }
}
