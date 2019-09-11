package com.example.mvptypicode

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import com.example.mvptypicode.Utils.ConstantText
import com.example.mvptypicode.component.DaggerNetworkComponent
import com.example.mvptypicode.component.NetworkComponent
import com.example.mvptypicode.receiver.ConnectivityReceiver
import es.dmoral.toasty.Toasty
import me.yokeyword.fragmentation.SupportActivity

open class BaseActivity : SupportActivity(), ConnectivityReceiver.ConnectivityReceiverListener {
    lateinit var connectivityReceiver: ConnectivityReceiver
    override fun onNetworkConnectChange(isConnected: Boolean) {
        if (isConnected) {
            showToast(ConstantText.INFO, "Internet connected !!", this)
        } else {
            showToast(ConstantText.WARNING, "You are offline ,please check internet", this)
        }

    }

    private var component: NetworkComponent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component = DaggerNetworkComponent.create()
        connectivityReceiver = ConnectivityReceiver()
        ConnectivityReceiver.connectivityReceiverListener = this
        registerReceiver(
            connectivityReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        )
    }

    fun loadFragment(fragment: BaseFragment, id: Int) {
        loadRootFragment(id, fragment)
    }

    fun getNetworkComponent(): NetworkComponent {
        return component!!
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(connectivityReceiver)
    }

    private fun showToast(type: String, text: String, context: Context) {
        when (type) {
            ConstantText.SUCCESS -> Toasty.success(context, text, Toasty.LENGTH_SHORT).show()
            ConstantText.ERROR -> Toasty.error(context, text, Toasty.LENGTH_LONG).show()
            ConstantText.INFO -> Toasty.info(context, text, Toasty.LENGTH_SHORT).show()
            ConstantText.WARNING -> Toasty.warning(context, text, Toasty.LENGTH_SHORT).show()
        }
    }
}
