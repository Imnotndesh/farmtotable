package com.example.farmtotable

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.fragment.app.FragmentActivity

class sqlHelper(context: FragmentActivity?) : SQLiteOpenHelper(context,"users.db", null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("CREATE TABLE Users (username TEXT primary key, password TEXT, email TEXT)")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS Users")
    }
    fun insertdata(username :String, password: String, email: String): Boolean {
        val db = this.writableDatabase
        val cv = ContentValues()
        cv.put("username",username)
        cv.put("password",password)
        cv.put("email",email)
        val result = db.insert("users",null,cv)
        if (result == -1 .toLong()){
            return false
        }
        return true
    }
    fun checkUserPass(username: String,password: String): Boolean {
        val db = this.readableDatabase
        val query = "SELECT * FROM Users where username = '$username' and password = '$password'"
        val cursor = db.rawQuery(query,null)
        if (cursor.count==0){
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }
}