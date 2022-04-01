package ru.netology

import ru.netology.attachments.Attachment

data class Post(
    var id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int?,
    val date: Int,
    val text: String,
    val replyOwnerId: Int?,
    val replyPostId: Int?,
    val friendsOnly: Boolean,
    val comments: String ,
    val likes:Int?,
    val views:Int?,
    val postType:String,
    val signerId:Int,
    val canPin:Boolean,
    val canDelete:Boolean,
    val canEdit:Boolean,
    val isPinned:Boolean,
    val markedAsAds:Boolean,
    val isFavorite:Boolean,
    val postponedId:Int,
    var attachments: ArrayList<Attachment>?
) {

}
