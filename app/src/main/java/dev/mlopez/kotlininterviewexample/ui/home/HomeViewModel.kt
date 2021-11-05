package dev.mlopez.kotlininterviewexample.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.mlopez.kotlininterviewexample.Constants
import dev.mlopez.kotlininterviewexample.models.User
import java.util.*

class HomeViewModel : ViewModel() {
    private val _name = MutableLiveData<String>().apply {
        value = ""
    }

    private val _phone = MutableLiveData<String>().apply {
        value = ""
    }

    private val _userList = MutableLiveData<MutableList<User>>().apply {
        value = Constants.userList
    }


    val userList: LiveData<MutableList<User>> = _userList
    val name: LiveData<String> = _name
    val phone: LiveData<String> = _phone

    fun setName(n: String) {
        _name.value = n
    }

    fun setPhone(p: String) {
        _phone.value = p
    }

    fun addUser(u: User) {
        _userList.value?.add(u)
    }
}