package com.example.livedata1

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun testGetLength_isCorrect(){
        var str = "salam"
        assertEquals(5  ,   getLength(str))
    }



    fun getLength(str : String) : Int{
        return str.length
    }



    @Test
    fun testLongRunningTask_withoutThread(){
        var  before = System.currentTimeMillis()
        longRunningTask()
        var after = System.currentTimeMillis()

        assertTrue(after - before >= 3000)

    }


    fun longRunningTask(){
        //database
        //network
        Thread.sleep(3000)
    }
}