package com.mosttransfer.abc


import com.squareup.moshi.Json

//@JsonClass(generateAdapter = true)
data class Transfer(@Json(name = "transfers")
                    val transfers: List<TransfersItem>?)


data class TransfersItem(@Json(name = "transferFeeRaw")
                         val transferFeeRaw: TransferFeeRaw = TransferFeeRaw(),
                         @Json(name = "transferFeeDescription")
                         val transferFeeDescription: String = "",
                         @Json(name = "transferFrom")
                         val transferFrom: TransferFrom = TransferFrom(),
                         @Json(name = "toTeamName")
                         val toTeamName: String = "",
                         @Json(name = "transferFee")
                         val transferFee: Int = 0,
                         @Json(name = "transferDateTimestamp")
                         val transferDateTimestamp: Int = 0,
                         @Json(name = "id")
                         val id: Int = 0,
                         @Json(name = "type")
                         val type: Int = 0,
                         @Json(name = "player")
                         val player: Player,
                         @Json(name = "fromTeamName")
                         val fromTeamName: String = "")


data class Player(@Json(name = "userCount")
                  val userCount: Int = 0,
                  @Json(name = "name")
                  val name: String = "",
                  @Json(name = "id")
                  val id: Int = 0,
                  @Json(name = "shortName")
                  val shortName: String = "",
                  @Json(name = "slug")
                  val slug: String = "")


data class TransferFeeRaw(@Json(name = "currency")
                          val currency: String = "EUR",
                          @Json(name = "value")
                          val value: Int = 0)


data class TransferFrom(@Json(name = "userCount")
                        val userCount: Int = 0,
                        @Json(name = "name")
                        val name: String = "",
                        @Json(name = "id")
                        val id: Int = 0,
                        @Json(name = "shortName")
                        val shortName: String = "",
                        @Json(name = "type")
                        val type: Int = 0,
                        @Json(name = "sport")
                        val sport: Sport = Sport(),
                        @Json(name = "slug")
                        val slug: String = "",
                        @Json(name = "teamColors")
                        val teamColors: TeamColors = TeamColors())


data class Sport(@Json(name = "name")
                 val name: String = "",
                 @Json(name = "id")
                 val id: Int = 0,
                 @Json(name = "slug")
                 val slug: String = "")


data class TeamColors(@Json(name = "secondary")
                      val secondary: String = "",
                      @Json(name = "text")
                      val text: String = "",
                      @Json(name = "primary")
                      val primary: String = "")



