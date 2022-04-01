package ru.netology.attachments

data class Document(
    val id:Int = 0,
    val ownerId:Int = 0,
    val title:String = "unknown",
    val size:Int = 0,
    val ext:String = "unknown"
)