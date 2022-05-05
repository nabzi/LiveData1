package com.example.livedata1

import androidx.room.TypeConverter


//Info("kaj" , 1)
//kaj,1
class Converters {
    @TypeConverter
    fun stringFromInfoList(infos: List<Info>): String {
        var str = ""
        for (info in infos) {
            str += info.plantType + "," + info.waterNeed + "-"
        }
        return str
    }

    @TypeConverter
    fun stringToInfoList(infosString: String): List<Info> {
        var list = arrayListOf<Info>()
        var strs = infosString.split('-')
        for (str in strs) {
            if(str.isNullOrBlank())
                break
            var items = str.split(',')
            list.add(Info(items[0], items[1].toInt()))
        }
        return list
    }
}