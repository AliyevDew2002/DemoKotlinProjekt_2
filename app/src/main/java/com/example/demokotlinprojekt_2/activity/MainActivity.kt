package com.example.demokotlinprojekt_2.activity
import android.app.Activity
import android.content.Intent
import android.graphics.ColorSpace
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.demokotlinprojekt_2.databinding.ActivityMainBinding
import com.example.demokotlinprojekt_2.model.Member

class MainActivity : AppCompatActivity() {
    var TAG=MainActivity::class.java.toString()

    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding= ActivityMainBinding.inflate(layoutInflater)
        var view: View=binding.root
        setContentView(view)

        initViews()
    }


   var detailLauncher=registerForActivityResult(
       ActivityResultContracts.StartActivityForResult()){result->
       if (result.resultCode==Activity.RESULT_OK){
           val data:Intent?=result.data
           var replies=data?.getStringExtra("replies")
           Log.d(TAG,replies.toString())
           binding.tvMain.setText(replies)
       }
   }


    fun initViews(){
        binding.btMain.setOnClickListener{
            var malumot:Member=Member("Shaxzod", "Aliyev",2002)
            openDetailPage(malumot)
        }
    }


    fun openDetailPage(malumot:Member){
        var intent=  Intent(this,DetailActivity::class.java)
        intent.putExtra("ma'lumot",malumot)
        detailLauncher.launch(intent)
    }
}