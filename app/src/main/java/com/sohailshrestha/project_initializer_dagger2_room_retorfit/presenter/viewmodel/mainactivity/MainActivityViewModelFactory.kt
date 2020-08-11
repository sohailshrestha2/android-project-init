package com.sohailshrestha.project_initializer_dagger2_room_retorfit.presenter.viewmodel.mainactivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.sohailshrestha.project_initializer_dagger2_room_retorfit.repository.Repository

/*
*Created by Sohail Shrestha on 8/11/2020 20
*/class MainActivityViewModelFactory(private val repository: Repository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainActivityViewModel(repository) as T
    }
}