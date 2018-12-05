package com.example.fastlanex

import android.support.multidex.MultiDexApplication
import com.example.fastlanex.model.GmiSdkWrapper
import com.example.fastlanex.model.GmiSdkWrapperImpl
import com.example.fastlanex.model.UserRepository
import com.example.fastlanex.viewmodel.UserProfileViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

@Suppress("unused", "SpellCheckingInspection") //This is definitely used, specified in AndroidManifest.xml
class GvidApplication : MultiDexApplication() {

    private val appModule = module {

        single { UserRepository() }

        single<GmiSdkWrapper> { GmiSdkWrapperImpl() }

        viewModel { UserProfileViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        // Start Koin
        startKoin(this, listOf(appModule))
    }
}
