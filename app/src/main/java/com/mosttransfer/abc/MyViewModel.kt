package com.mosttransfer.abc

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel(context: Context, listener: OnSelectedListener): ViewModel() {

    private val _transferObject = MutableLiveData<List<TransfersItem>>()
    val transferObject : LiveData<List<TransfersItem>>
        get() = _transferObject

    /*
    init {
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

    }*/
}

/*
class MyViewModelFactory(
    private val scheduleDao: ScheduleDatabaseDao): ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FullScheduleViewModel::class.java)) {
            return FullScheduleViewModel(scheduleDao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/