// AuthRepository.kt

package com.example.stage.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.stage.domain.entity.User
import com.example.stage.domain.repository.IAuth
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthRepository : IAuth {

    private lateinit var auth: FirebaseAuth
    private val TAG = "AuthRepository"

    init {
        auth = FirebaseAuth.getInstance()
    }

    override fun login(user: User): MutableLiveData<Boolean> {

        val mutableLiveData = MutableLiveData<Boolean>()
        auth.signInWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    val firebaseUser = auth.currentUser

                    mutableLiveData.value = true
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)

                    mutableLiveData.value = false
                }
            }
        return mutableLiveData
    }

    override fun register(user: User): MutableLiveData<Boolean> {
        var mutableLiveData = MutableLiveData<Boolean>()
        auth.createUserWithEmailAndPassword(user.email, user.password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "createUserWithEmail:success")
                    val firebaseUser = auth.currentUser

                    mutableLiveData.value = true
                } else {
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)

                    mutableLiveData.value = false
                }
            }
        return mutableLiveData
    }

    // Méthode pour récupérer l'utilisateur actuellement connecté
    fun getCurrentUser(): FirebaseUser? {
        return auth.currentUser
    }

}
