package com.mosttransfer.abc

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

@SuppressLint("SimpleDateFormat")
fun getDate(dateTimestamp: Long): String {
    return SimpleDateFormat("dd/MM/yyyy").format(Date(dateTimestamp * 1000))
}

fun setImage(context: Context, imgUrl: String, imgView: ImageView) {
    if(imgView.id == R.id.playerImage) {
        Glide.with(context).load(imgUrl).apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.profile_image)
            .into(imgView)
    } else {
        Glide.with(context).load(imgUrl).apply(RequestOptions.circleCropTransform())
            .into(imgView)
    }
}

fun isInternetAvailable(context: Context): Boolean {
    val result: Boolean
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val networkCapabilities = connectivityManager.activeNetwork ?: return false
    val activeNetwork =
        connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

    result = when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
    return result

    /*
    ** The check below is redundant since my minSdk is always 23 or above, thereby making it
    ** always true. Build.VERSION_CODES.M = 23(API level 23, Android 6.0 MarshMallow)
    **
    ** if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
    ** The if statement part starts from val networkCapabilities up to the closing bracket of
    ** result variable before the return statement
    **
    ** The else statement is given below, will use the deprecated activeNetworkInfo method
    ** else {
    **  connectivityManager.run {
    **      connectivityManager.activeNetworkInfo?.run {
    **          result = when(type) {
    **              ConnectivityManager.TYPE_WIFI -> true
    **              ConnectivityManager.TYPE_WIFI -> true
    **              ConnectivityManager.TYPE_WIFI -> true
    **              else -> false
    **          }
    **      }
    **  }
    ** }
    */
}