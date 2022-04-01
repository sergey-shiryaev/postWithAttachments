package ru.netology.attachments

data class DocumentAttachment(val document: Document?, override val type: String = "document", ) : Attachment