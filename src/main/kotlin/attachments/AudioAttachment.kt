package ru.netology.attachments

data class AudioAttachment(val audio: Audio?, override val type: String = "audio") : Attachment