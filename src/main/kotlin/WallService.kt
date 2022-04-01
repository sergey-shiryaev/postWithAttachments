package ru.netology

import ru.netology.attachments.Attachment

object WallService {
    private var posts = arrayListOf<Post>()
    private var postsID = 1

    fun add(newPost: Post): Post {
        newPost.id = postsID
        postsID++
        posts += newPost
        return newPost
    }

    fun addAttachment(post: Post, attachment: Attachment) {
        post.attachments?.add(attachment)
    }

    fun update(updatePost: Post): Boolean {
        for (post in posts) {
            if (post.id == updatePost.id) {
                val newUpdatePost: Post = post.copy(
                    ownerId = updatePost.ownerId,
                    fromId = updatePost.fromId,
                    createdBy = updatePost.createdBy,
                    text = updatePost.text,
                    replyOwnerId = updatePost.replyOwnerId,
                    replyPostId = updatePost.replyPostId,
                    friendsOnly = updatePost.friendsOnly,
                    comments = updatePost.comments,
                    likes = updatePost.likes,
                    views = updatePost.views,
                    postType = updatePost.postType,
                    signerId = updatePost.signerId,
                    canPin = updatePost.canPin,
                    canDelete = updatePost.canDelete,
                    canEdit = updatePost.canEdit,
                    isPinned = updatePost.isPinned,
                    markedAsAds = updatePost.markedAsAds,
                    isFavorite = updatePost.isFavorite,
                    postponedId = updatePost.postponedId,
                    attachments = updatePost.attachments
                )
                posts.remove(post)
                posts += newUpdatePost
                return true
            }
        }
        return false
    }

    fun clearPosts() {
        posts.clear()
        postsID = 1
    }
}