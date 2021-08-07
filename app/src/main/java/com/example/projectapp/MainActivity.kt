package com.example.projectapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val data: Call<List<DataClass>> = retrofitImage.myimage.getdata()

        data.enqueue(object : Callback<List<DataClass>> {
            override fun onResponse(
                call: Call<List<DataClass>>,
                response: Response<List<DataClass>>
            ) {
                Log.d("user", response.body().toString())
                val data: List<DataClass> = response.body()!!
                var adapter = GAdapter(this@MainActivity, data)
                recyclervi.adapter = adapter
                recyclervi.layoutManager = GridLayoutManager(this@MainActivity, 2)

                var pos = 1
                toggle.setOnClickListener {
                    if (pos == 1) {
                        toggle.setImageResource(R.drawable.recy)
                        textq.setText(
                            "Grid View"
                        )
                        var adapterl = LAdapter(this@MainActivity, data)
                        recyclervi.adapter = adapterl

                        recyclervi.layoutManager = LinearLayoutManager(this@MainActivity)
                        pos = 0
                    } else if (pos == 0) {
                        toggle.setImageResource(R.drawable.list)
                        textq.setText("List View")
                        adapter = GAdapter(this@MainActivity, data)
                        recyclervi.adapter = adapter

                        recyclervi.layoutManager = GridLayoutManager(this@MainActivity, 2)
                        pos = 1


                    }
                }
            }

            override fun onFailure(call: Call<List<DataClass>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "notjng", Toast.LENGTH_SHORT).show()
            }

        })
    }


}