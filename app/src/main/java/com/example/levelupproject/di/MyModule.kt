package com.example.levelupproject.di

import com.example.levelupproject.ui.ProductViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel {
        ProductViewModel()
    }

}