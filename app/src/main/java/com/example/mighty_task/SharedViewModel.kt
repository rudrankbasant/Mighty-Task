package com.example.mighty_task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mighty_task.model.User

class SharedViewModel : ViewModel() {

    val sampleUser = MutableLiveData<User>()

    fun updateUser(user: User) {
        sampleUser.value = user
    }
}