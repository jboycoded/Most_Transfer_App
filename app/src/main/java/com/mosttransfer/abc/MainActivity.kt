package com.mosttransfer.abc

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnSelectedListener {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        //Make the Http Request with retrofit and then update the RecyclerView from there
        requestTransfers(this, this)

    }

    override fun onCardViewClicked(cardGroup: Group) {
        if (cardGroup.visibility == View.VISIBLE) {
            cardGroup.visibility = View.GONE
        } else {
            cardGroup.visibility = View.VISIBLE
        }
    }

    override fun onBackPressed() {
        // If(View.visibility == View.VISIBLE) {
        //      View.visibility = View.GONE
        // } else {
        //      super.onBackPressed()
        // }

        //What the above code does is that if the view is still visible, then make it invisible
        //If it is no longer visible, then just call the normal onBackPressed() action
        //that will take you out of the activity or fragment
    }

    private fun requestTransfers(context: Context, listener: OnSelectedListener) {

        val request = TransferApi.retrofitService.getTransfers()
        request.enqueue(
            object : Callback<Transfer> {
                override fun onResponse(call: Call<Transfer>, response: Response<Transfer>) {
                    val transferObject = response.body()?.transfers
                    recyclerView.adapter =
                        transferObject?.let { CustomAdapter(context, listener, it) }

                }

                override fun onFailure(call: Call<Transfer>, t: Throwable) {

                    // If no Internet service, tell the user the reason for the failure
                    // else state the error from the server
                    if(!isInternetAvailable(context)) {
                        Toast.makeText(context, "No Internet connection", Toast.LENGTH_LONG)
                            .show()
                    } else {
                        Toast.makeText(context, "Failure: " + t.message, Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        )
        //If the request has been executed or enqueued, notify the user that it is updating
        if (request.isExecuted) {
            Toast.makeText(context, "Updating, please wait", Toast.LENGTH_LONG)
                .show()
        }

    }
}