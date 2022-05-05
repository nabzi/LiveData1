package com.example.livedata1

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true)
    val number: Int,
    val descr: String,
    val answer: Int?,
    val info : List<Info>
)

data class Info(
    val plantType : String,
    val waterNeed : Int
)

@Dao
interface QuestionDao {
    @Query("SELECT * FROM Question")
    fun getAll(): List<Question>

    @Query("SELECT * FROM Question WHERE number = :num")
    fun getQuestion(num : Int): Question?

    @Query("SELECT COUNT(number) FROM Question")
    fun getQuestionCount(): LiveData<Int>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg questions: Question)

    @Delete
    fun delete(question : Question)

    @Query("DELETE FROM Question")
    fun clear()

}


@Database(entities = [Question::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        var INSTANCE: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase {
            val db : AppDatabase by lazy {
                Room.databaseBuilder(context.applicationContext,
                            AppDatabase::class.java, "myDB")
                            .allowMainThreadQueries()
                            .build()
            }
            return db
//            if (INSTANCE == null){
//                synchronized(AppDatabase::class){
//                    INSTANCE =
//                        Room.databaseBuilder(context.applicationContext,
//                            AppDatabase::class.java, "myDB")
//                            .allowMainThreadQueries()
//                            .build()
//                }
//            }
//            return INSTANCE
        }

        fun destroyDataBase(){
            INSTANCE = null
        }
    }

}

