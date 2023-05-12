package com.example.demokotlinprojekt_2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.demokotlinprojekt_2.databinding.ActivityDetailBinding


@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {
     lateinit var detailBinding:ActivityDetailBinding
     var TAG=DetailActivity::class.java.toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailBinding= ActivityDetailBinding.inflate(layoutInflater)
        val view: View=detailBinding.root
        setContentView(view)
        initViews()
    }
    fun initViews():Unit{
        getSerializable()
        detailBinding.btDetail.setOnClickListener{
            exitDetail()
        }
    }

    fun getSerializable(){
        var malumot = intent.getSerializableExtra("ma'lumot");
        Log.d(TAG,malumot.toString())
        detailBinding.tvDetail.setText(malumot.toString())
    }

    fun exitDetail(){
        var intent= Intent()
        intent.putExtra("replies","Thanks a lot!")
        setResult(RESULT_OK,intent)
        finish()
        //sas
    }

}