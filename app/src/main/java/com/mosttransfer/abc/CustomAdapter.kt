package com.mosttransfer.abc

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(
    private val context: Context,
    private var listener: OnSelectedListener,
    private var transferObject: List<TransfersItem>
) :
    RecyclerView.Adapter<CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        return CustomViewHolder(
            LayoutInflater.from(context).inflate(R.layout.recycler_container, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val playerName = transferObject[position].player.name
        val playerId = transferObject[position].player.id.toString()
        val playerImgUrl = "https://api.sofascore.com/api/v1/player/$playerId/image"

        //TODO: find a way to retrieve Glide's result to determine if there is an error.
        //***** If there is, set a drawable image for the player image
        try {
            setImage(context, playerImgUrl, holder.playerImage)
        } catch (e: Exception) {
            Log.i("HI THERE", "IT'S AN EXCEPTION")
            holder.playerImage.setImageResource(R.drawable.ic_launcher_background)
        }

        var fromTeamName = transferObject[position].transferFrom.name
        if (fromTeamName == "") {
            fromTeamName = transferObject[position].fromTeamName
        }
        val toClubName = transferObject[position].toTeamName

        val fromTeamId = transferObject[position].transferFrom.id.toString()
        val clubImgUrl = "https://api.sofascore.com/api/v1/team/$fromTeamId/image"
        setImage(context, clubImgUrl, holder.teamImage)

        val toTeamId = transferObject[position].id.toString()
        val toClubImgUrl = "https://api.sofascore.com/api/v1/team/$toTeamId/image"
        setImage(context, toClubImgUrl, holder.toTeamImage)

        var transferDate = transferObject[position].transferDateTimestamp.toString()
        transferDate = getDate(transferDate.toLong())

        val transferValue = transferObject[position].transferFeeRaw.value
        val transferCurrency = transferObject[position].transferFeeRaw.currency
        val transferAmount = "$transferValue $transferCurrency"

        holder.firstName.text = playerName.split(" ")[0]
        try {
            holder.lastName.text = playerName.split(" ")[1]
        }catch (e: Exception) {
            holder.lastName.text = ""
        }

        //For playerImage, will make another http request for the image
        //holder.playerImage.setImageResource(R.drawable.ic_launcher_background)

        holder.fromClubTextView.text = fromTeamName
        holder.toClubTextView.text = toClubName

        holder.transferDateTextView.text = transferDate
        holder.transferAmountTextView.text = transferAmount

        holder.container.setOnClickListener {
            listener.onCardViewClicked(holder.cardGroup)
        }
    }

    override fun getItemCount(): Int {
        return transferObject.size
    }

}