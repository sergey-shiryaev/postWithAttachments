package ru.netology.attachments

data class Audio(
    val id:Int = 0,
    val ownerId:Int = 0,
    val artist:String = "unknown",
    val title:String = "unknown",
    val duration:Int = 0
)