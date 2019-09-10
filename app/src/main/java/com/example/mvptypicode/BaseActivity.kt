package com.example.mvptypicode

import android.os.Bundle
import com.example.mvptypicode.component.DaggerNetworkComponent
import com.example.mvptypicode.component.NetworkComponent
import me.yokeyword.fragmentation.SupportActivity

open class BaseActivity : SupportActivity() {
    private var component: NetworkComponent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerNetworkComponent.create()
    }

    fun loadFragment(fragment: BaseFragment, id: Int) {
        loadRootFragment(id, fragment)
    }

    fun getNetworkComponent(): NetworkComponent {
        return component!!
    }
}
