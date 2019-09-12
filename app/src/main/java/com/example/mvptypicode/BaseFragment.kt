package com.example.mvptypicode

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mvptypicode.utils.ConstantText
import com.example.mvptypicode.component.DaggerNetworkComponent
import com.example.mvptypicode.component.NetworkComponent
import com.example.mvptypicode.networking.ApiService
import es.dmoral.toasty.Toasty
import me.yokeyword.fragmentation.SupportFragment
import javax.inject.Inject

open class BaseFragment : SupportFragment() {
    lateinit var component: NetworkComponent
    @Inject
    lateinit var apiService: ApiService

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

    fun showToast(type: String, text: String, context: Context) {
        when (type) {
            ConstantText.SUCCESS -> Toasty.success(context, text, Toasty.LENGTH_SHORT).show()
            ConstantText.ERROR -> Toasty.error(context, text, Toasty.LENGTH_LONG).show()
            ConstantText.INFO -> Toasty.info(context, text, Toasty.LENGTH_SHORT).show()
            ConstantText.WARNING -> Toasty.warning(context, text, Toasty.LENGTH_SHORT).show()
        }
    }
}