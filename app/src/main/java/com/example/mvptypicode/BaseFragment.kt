package com.example.mvptypicode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvptypicode.component.DaggerNetworkComponent
import com.example.mvptypicode.component.NetworkComponent
import me.yokeyword.fragmentation.SupportFragment

open class BaseFragment : SupportFragment() {
    lateinit var component: NetworkComponent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerNetworkComponent.create()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    fun replaceFragment(fragment: BaseFragment, isAddStack: Boolean) {
        replaceFragment(fragment, isAddStack)
    }

    fun startFragment(fragment: BaseFragment) {
        start(fragment)
    }

    fun startWithPopFragment(fragment: BaseFragment) {
        startWithPop(fragment)
    }

    fun getNetworkComponent(): NetworkComponent {
         return component
    }
}