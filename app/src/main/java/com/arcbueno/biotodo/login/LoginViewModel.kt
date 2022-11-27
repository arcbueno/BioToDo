package com.arcbueno.biotodo.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arcbueno.biotodo.models.UserLoginData
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var userData: MutableLiveData<UserLoginData> = MutableLiveData<UserLoginData>();


    fun login(): Boolean {

        var result = false;
        if ((userData.value == null) || userData.value!!.email.isEmpty() || userData.value!!.password.isEmpty() ) {
            Log.i("login", "NO DATA INSERTED")
            return result
        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(
            userData.value!!.email, userData.value!!.password
        )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.i("login", "Email signup is successful")
                } else {
                    Log.i(
                        "Login",
                        "Email signup failed with error ${task.exception?.localizedMessage}"
                    )

                }
                result = task.isSuccessful
            }

        return result
    }
}
