package com.example.demokotlinprojekt_2.model

class Member(var ism:String, var familya:String,var yili:Int):java.io.Serializable {
    override fun toString(): String {
        return "Ism:"+ism+", Familya:"+familya+", Yili:"+yili;

    }
}