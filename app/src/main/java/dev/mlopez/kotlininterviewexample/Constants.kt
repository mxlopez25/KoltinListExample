package dev.mlopez.kotlininterviewexample

import androidx.lifecycle.MutableLiveData
import dev.mlopez.kotlininterviewexample.models.User
import java.util.*

object Constants {
    var userList : MutableList<User> = mutableListOf(
        User("First User", "809-555-3322", Date()),
        User("Second User", "809-443-2223", Date())
    )
}