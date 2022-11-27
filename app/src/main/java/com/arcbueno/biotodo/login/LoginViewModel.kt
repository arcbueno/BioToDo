package com.arcbueno.biotodo.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.arcbueno.biotodo.models.UserLoginData
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel(application: Application) : AndroidViewModel(application) {

    var userData: UserLoginData? =  UserLoginData("", "");

//    private var auth: FirebaseAuth = Firebase.auth

    private val context = getApplication<Application>().applicationContext

    fun login() {
        if (userData == null) {
            Log.i("login", "NO DATA INSERTED")

        }

        FirebaseAuth.getInstance().signInWithEmailAndPassword(
            userData!!.email, userData!!.password
        )
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.i("login", "Email signup is successful")
//                    _authState.value = AuthState.Success
//                    findNavController().navigate(R.id.fragment)
                } else {
                    Log.i("Login", "Email signup failed with error ${task.exception?.localizedMessage}")

                //                        _authState.value = AuthState.AuthError(it.localizedMessage)
                }
            }

//        auth.signInWithEmailAndPassword(userData!!.email, userData!!.password)
//            .addOnCompleteListener(context) { task  ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.d("Login", "signInWithEmail:success")
//                    val user = auth.currentUser
////                    updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.w("Login", "signInWithEmail:failure", task.exception)
//                    Toast.makeText(context, "Authentication failed.",
//                        Toast.LENGTH_SHORT).show()
////                    updateUI(null)
//                }
//            }

    }


}