package com.taweewong.mymvvmsample.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.taweewong.mymvvmsample.extension.observe

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResource())
        bindViewModel().apply {
            observe(mediatorLiveData) {
                //Just observe to make handleResponse works
            }
        }
        setup()
        prepareAction()
        attachObserver()
    }

    abstract fun layoutResource() : Int

    abstract fun bindViewModel() : BaseViewModel

    abstract fun setup()

    abstract fun prepareAction()

    abstract fun attachObserver()
}