package com.example.mvptypicode

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import me.yokeyword.fragmentation.ISupportActivity
import me.yokeyword.fragmentation.SupportActivity

open class BaseActivity : SupportActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
