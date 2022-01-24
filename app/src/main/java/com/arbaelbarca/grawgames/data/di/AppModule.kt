package com.arbaelbarca.grawgames.data.di

import com.arbaelbarca.grawgames.data.api.ApiServices
import com.arbaelbarca.grawgames.data.api.AuthInterceptor
import com.arbaelbarca.grawgames.data.api.createWebService
import com.arbaelbarca.grawgames.data.api.provideOkHttpClient
import com.arbaelbarca.grawgames.presentation.repository.RepositoryHome
import com.arbaelbarca.grawgames.presentation.viewmodel.ViewModelHome
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val networkModule = module {
    single { provideOkHttpClient(get(), get()) }
    single { createWebService<ApiServices>(get()) }
    single { AuthInterceptor() }
}

val viewModelModule = module {
    viewModel {
        ViewModelHome(
            get()
        )
    }
}


val repositoryModule = module {
    single { RepositoryHome(get()) }
}

val myAppModule = listOf(networkModule, repositoryModule, viewModelModule)