package com.practice.a20240123_murtazawali_nycschools

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.practice.a20240123_murtazawali_nycschools.databinding.ActivitySchoolDetailBinding
import com.practice.a20240123_murtazawali_nycschools.model.ScoreModel
import com.practice.a20240123_murtazawali_nycschools.view.ScoreViewModel

class SchoolDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: ScoreViewModel
    private lateinit var binding: ActivitySchoolDetailBinding

    private val scoreModelList: MutableList<ScoreModel> = mutableListOf()

    private var schoolDbn: String = ""  // Provide a default value if it's null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_school_detail)

        initViewModel()
    }

    private fun initViewModel() {
        binding.imageBack.setOnClickListener { onBackPressed() }
        schoolDbn = intent.getStringExtra("school") ?: ""
        //Toast.makeText(this, "$schoolDbn Score", Toast.LENGTH_SHORT).show()
        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)

        viewModel.getScore(schoolDbn).observe(this, { filteredScoreModels ->
            filteredScoreModels?.let {
                scoreModelList.clear()
                scoreModelList.addAll(it)

                val matchingScoreModel = scoreModelList.firstOrNull { scoreModel -> scoreModel.dbn == schoolDbn }

                binding.score = matchingScoreModel

                if (matchingScoreModel == null) {
                    Toast.makeText(this, "No matching ScoreModel found for dbn: $schoolDbn", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
