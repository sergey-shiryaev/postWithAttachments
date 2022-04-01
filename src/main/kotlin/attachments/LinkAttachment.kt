package ru.netology.attachments

data class LinkAttachment(val link: Link?, override val type: String = "link") : Attachment
