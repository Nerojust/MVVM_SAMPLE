package com.example.mvvmsample.ui.auth

import com.example.mvvmsample.data.db.entities.User

interface AuthListener {

    fun onStarted()

    fun onSuccess(loginResponse: User)

    fun onFailure(message : String)
}