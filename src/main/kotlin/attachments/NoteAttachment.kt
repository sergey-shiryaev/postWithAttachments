package ru.netology.attachments

data class NoteAttachment(val note: Note?, override val type: String = "note") : Attachment
