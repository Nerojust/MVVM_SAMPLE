package com.example.mvvmsample.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.mvvmsample.R
import com.example.mvvmsample.data.db.entities.User
import com.example.mvvmsample.databinding.ActivityLoginBinding
import com.example.mvvmsample.util.hide
import com.example.mvvmsample.util.show
import com.example.mvvmsample.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel

        viewModel.authListener = this
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} is logged in")

    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        toast(message)
    }
}
