package com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.activity.mainactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.databinding.ActivityMainBinding
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.viewmodel.mainactivity.MainActivityViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModel: MainActivityViewModel

    private var _binding: ActivityMainBinding? = null
    private val binding : ActivityMainBinding?
    get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeActivityMainBinding()
    }

    private fun initializeActivityMainBinding(){
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}