package com.mosttransfer.abc

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val view = itemView
    var firstName: TextView = view.findViewById(R.id.firstNameText)
    var lastName: TextView = view.findViewById(R.id.lastNameText)

    var fromClubTextView: TextView = view.findViewById(R.id.from_club)
    var toClubTextView: TextView = view.findViewById(R.id.to_club)

    var transferDateTextView: TextView = view.findViewById(R.id.transfer_date)
    var transferAmountTextView: TextView = view.findViewById(R.id.transfer_currency)

    var playerImage: ImageView = view.findViewById(R.id.playerImage)
    var teamImage: ImageView = view.findViewById(R.id.club_image1)
    var toTeamImage: ImageView = view.findViewById(R.id.club_image)

    var container: CardView = view.findViewById(R.id.container)
    var cardGroup: Group = view.findViewById(R.id.card_group)

}