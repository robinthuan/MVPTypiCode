package com.example.mvptypicode.component

import com.example.mvptypicode.FragmentPost
import com.example.mvptypicode.networking.NetworkModule
import com.example.mvptypicode.view.home.HomeActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(homeActivity: HomeActivity)
    fun inject(fragmentPost: FragmentPost)
}