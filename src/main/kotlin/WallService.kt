package ru.netology

import ru.netology.attachments.Attachment

object WallService {
    private var posts = arrayListOf<Post>()
    private var comments = arrayListOf<Comment>()
    private var postsID = 1

    fun createComment(comment: Comment): Boolean {
        for (post in posts) {
            if (post.id == comment.postId) {
                return comments.add(comment)
            }
        }
        throw PostNotFoundException("Comment with id ${comment.postId} was not added")
    }

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
        for ((index, post) in posts.withIndex()) {
            if (post.id == updatePost.id) {
                val newUpdatePost: Post = post.copy(
                    ownerId = updatePost.ownerId,
                    text = updatePost.text,
                    comments = updatePost.comments,
                    likes = updatePost.likes,
                    views = updatePost.views,
                    postType = updatePost.postType,
                    signerId = updatePost.signerId,
                    isPinned = updatePost.isPinned,
                    markedAsAds = updatePost.markedAsAds,
                    isFavorite = updatePost.isFavorite
                )
                posts[index] = newUpdatePost
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