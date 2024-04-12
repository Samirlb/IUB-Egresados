//package com.example.iubegresados.data.db
//
//import androidx.room.Dao
//import androidx.room.Delete
//import androidx.room.Insert
//import androidx.room.Query
//import androidx.room.Update
//import com.example.iubegresados.data.model.UserModel
//
//
//@Dao
//interface UserDao {
//    @Query("select * from users where userid=:id")
//    fun getUserById(id:String):UserModel
//
//    @Query("SELECT * FROM users")
//    fun getUsers(): List<UserModel>
//
//    @Insert
//    fun insert(user: UserModel)
//
//    @Delete
//    fun delete(user: UserModel)
//
//    @Update
//    fun update(user: UserModel)
//}