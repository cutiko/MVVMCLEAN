package cl.cutiko.mvvmclean.data.source.firebase

import com.google.firebase.database.FirebaseDatabase

private val root = FirebaseDatabase.getInstance().reference

val mvvm = root.child("mvvm")