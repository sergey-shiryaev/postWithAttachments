package ru.netology.attachments

data class Note(
    val id:Int = 0,
    val ownerId:Int = 0,
    val title:String = "unknown",
    val text:String = "",
    val date:Int = 0
)
