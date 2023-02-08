package com.cs.movieapp.model.movie
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(
//    entities = [Movie::class],
//    version = 1
//)
//abstract class MovieDatabase: RoomDatabase() {
//
//    abstract fun movieDao(): MovieDao
//
//    companion object{
//        private var INSTANCE: MovieDatabase? = null
//        fun getDatabase(context: Context): MovieDatabase {
//            if (INSTANCE == null) {
//                synchronized(this) {
//                    INSTANCE =
//                        Room.databaseBuilder(context, MovieDatabase::class.java, "movie.db")
//                            .build()
//                }
//            }
//            return INSTANCE!!
//        }
//    }
//
//}