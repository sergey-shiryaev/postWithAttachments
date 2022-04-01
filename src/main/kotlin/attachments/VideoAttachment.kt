package ru.netology.attachments

data class VideoAttachment(val video: Video?, override val type: String = "video") : Attachment