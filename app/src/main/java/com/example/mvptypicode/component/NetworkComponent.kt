package com.example.mvptypicode.component

import com.example.mvptypicode.BaseFragment
import com.example.mvptypicode.view.home.HomeFragment
import com.example.mvptypicode.networking.NetworkModule
import com.example.mvptypicode.view.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(fragmentPost: BaseFragment)
}