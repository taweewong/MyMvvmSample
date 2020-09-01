package com.taweewong.mymvvmsample.ui.profile

import com.taweewong.mymvvmsample.R
import com.taweewong.mymvvmsample.extension.observe
import com.taweewong.mymvvmsample.ui.base.BaseActivity
import com.taweewong.mymvvmsample.ui.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserProfileActivity : BaseActivity() {
    private val viewModel: ProfileViewModel by viewModel()

    override fun layoutResource(): Int = R.layout.activity_profile

    override fun bindViewModel(): BaseViewModel = viewModel

    override fun setup() {
        viewModel.getUserProfile()
    }

    override fun prepareAction() {
        //TODO: Set on click event
    }

    override fun attachObserver() {
        with(viewModel) {
            observe(getUserProfileSuccess) {
                //TODO: Do something after get user profile
            }
            observe(getUserProfileError) {
                //TODO: Do something when get user profile error
            }
            observe(getUserProfileLoading) {
                //TODO: Do something when start getting user profile
            }
        }
    }
}