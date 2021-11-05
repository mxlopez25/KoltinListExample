package dev.mlopez.kotlininterviewexample.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.mlopez.kotlininterviewexample.Constants
import dev.mlopez.kotlininterviewexample.models.User

class DashboardViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is dashboard Fragment"
//    }
//    val text: LiveData<String> = _text

    private val _userList = MutableLiveData<MutableList<User>>().apply {
        value = Constants.userList
    }

    val userList: LiveData<MutableList<User>> = _userList
}