package ru.netology.attachments

data class Video(
    val id:Int = 0,
    val ownerId: Int = 0,
    val title:String = "unknown",
    val description:String = "",
    val duration:Int = 0
)