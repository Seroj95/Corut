package com.example.corut

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.corut.Utils.Status
import com.example.corut.adapter.MainAdapter
import com.example.corut.api.ApiHelper
import com.example.corut.api.RetrofitBulider
import com.example.corut.model.User
import com.example.corut.viewmodel.MainViewModel
import com.example.corut.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*
import java.security.Provider

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObserves()
    }

    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(
            this, ViewModelFactory(ApiHelper(RetrofitBulider.apiService))
        )
            .get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            //https://developer.android.com/reference/androidx/recyclerview/widget/DividerItemDecoration
            //https://startandroid.ru/ru/courses/architecture-components/27-course/architecture-components/525-urok-2-livedata.html
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObserves() {
        //https://developer.android.com/topic/libraries/architecture/livedata
        viewModel.getUsers().observe(this
            , Observer {
                //https://kotlinlang.org/docs/reference/scope-functions.html#let
                it?.let { resource ->
                    when (resource.status) {
                        Status.SUCCESS -> {
                            recyclerView.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                            resource.data?.let { users-> retriveList(users) }
                        }
                        Status.ERROR ->{
                            recyclerView.visibility=View.VISIBLE
                            progressBar.visibility=View.GONE
                            Toast.makeText(this,"You"+it.message, Toast.LENGTH_SHORT).show()
                        }
                        Status.LOADING ->{
                            progressBar.visibility=View.VISIBLE
                            recyclerView.visibility=View.GONE

                        }
                    }
                }
            })
    }

    private fun retriveList(users: List<User>) {
       adapter.apply {
           addUser(users)
           notifyDataSetChanged()
       }
    }
}