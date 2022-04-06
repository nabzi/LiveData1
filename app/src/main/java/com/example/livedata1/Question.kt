package com.example.livedata1

import androidx.room.*

@Entity
data class Question(
    @PrimaryKey(autoGenerate = true) val number: Int,
    @ColumnInfo(name = "descr") val descr: String,
    @ColumnInfo(name = "answer") val answer: Int?
)
@Dao
interface QuestionDao {
    @Query("SELECT * FROM Question")
    fun getAll(): List<Question>

    @Insert
    fun insertAll(vararg questions: Question)

    @Delete
    fun delete(question : Question)
}

@Database(entities = [Question::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
}