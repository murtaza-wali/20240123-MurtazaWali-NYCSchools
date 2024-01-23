package com.practice.a20240123_murtazawali_nycschools.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.practice.a20240123_murtazawali_nycschools.R
import com.practice.a20240123_murtazawali_nycschools.SchoolDetailActivity
import com.practice.a20240123_murtazawali_nycschools.databinding.SchoolListItemBinding
import com.practice.a20240123_murtazawali_nycschools.listener.SchoolListener
import com.practice.a20240123_murtazawali_nycschools.model.SchoolModel

class SchoolModelAdapter(private val context: Context,private val schoolList: List<SchoolModel>) : RecyclerView.Adapter<SchoolModelAdapter.SchoolViewHolder>() {

        private var layoutInflater: LayoutInflater? = null



        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchoolViewHolder {
                if (layoutInflater == null) {
                        layoutInflater = LayoutInflater.from(parent.context)
                }

                val schoolBinding: SchoolListItemBinding = DataBindingUtil.inflate(
                        layoutInflater!!, R.layout.school_list_item, parent, false
                )
                return SchoolViewHolder(schoolBinding)
        }

        override fun onBindViewHolder(holder: SchoolViewHolder, position: Int) {
                holder.bindSchool(schoolList[position])

        }

        override fun getItemCount(): Int {
                return schoolList.size
        }


        inner class SchoolViewHolder(private val itemContainerTvShowBinding: SchoolListItemBinding) :
                RecyclerView.ViewHolder(itemContainerTvShowBinding.root) {

                fun bindSchool(school: SchoolModel) {
                        itemContainerTvShowBinding.schoolmodel = school
                        itemContainerTvShowBinding.executePendingBindings()

                        itemContainerTvShowBinding.root.setOnClickListener {
                                val intent = Intent(context, SchoolDetailActivity::class.java)
                                intent.putExtra("school", school.dbn)
                                context.startActivity(intent)
                        }

                }
        }
}
