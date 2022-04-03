package ru.netology

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import ru.netology.attachments.*

class WallServiceTest {

    @Before
    fun clearService() {
        WallService.clearPosts()
    }

    @Test
    fun afterAddIdNotZero() {
        val expectedID = 1
        val post = Post(
            ownerId = 10,
            fromId = 20,
            createdBy = 30,
            date = 0,
            text = "This is the post",
            replyOwnerId = 100,
            replyPostId = 101,
            friendsOnly = true,
            comments = "comment",
            likes = null,
            views = null,
            postType = "post",
            signerId = 1,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 0,
            attachments = null
        )
        val audio = AudioAttachment(Audio())
        val video = VideoAttachment(Video())
        val document = DocumentAttachment(Document())
        val link = LinkAttachment(Link())
        val note = NoteAttachment(Note())
        WallService.addAttachment(post, audio)
        WallService.addAttachment(post, video)
        WallService.addAttachment(post, document)
        WallService.addAttachment(post, link)
        WallService.addAttachment(post, note)
        WallService.add(post)
        assertEquals(expectedID, post.id)
    }

    @Test
    fun updateExisting() {
        val service = WallService
        service.add(
            Post(
                ownerId = 100,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )
        service.add(
            Post(
                ownerId = 101,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )
        val update = Post(
            id = 2,
            ownerId = 103,
            fromId = 20,
            createdBy = 30,
            date = 0,
            text = "This is the post",
            replyOwnerId = 100,
            replyPostId = 101,
            friendsOnly = true,
            comments = "comment",
            likes = null,
            views = null,
            postType = "post",
            signerId = 1,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 0,
            attachments = null
        )
        val result = service.update(update)
        assertTrue(result)
    }

    @Test
    fun updateNotExisting() {
        val service = WallService
        service.add(
            Post(
                ownerId = 10,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )
        service.add(
            Post(
                ownerId = 100,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )
        val update = Post(
            id = 3,
            ownerId = 10,
            fromId = 20,
            createdBy = 30,
            date = 0,
            text = "This is the post",
            replyOwnerId = 100,
            replyPostId = 101,
            friendsOnly = true,
            comments = "comment",
            likes = null,
            views = null,
            postType = "post",
            signerId = 1,
            canPin = true,
            canDelete = true,
            canEdit = true,
            isPinned = true,
            markedAsAds = true,
            isFavorite = true,
            postponedId = 0,
            attachments = null
        )
        val result = service.update(update)
        assertFalse(result)
    }

    @Test(expected = PostNotFoundException::class)
    fun shouldThrow() {
        WallService.add(
            Post(
                ownerId = 10,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )
        WallService.add(
            Post(
                ownerId = 100,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )

        WallService.createComment(
            Comment(
                ownerId = 0,
                postId = 3,
                fromGroup = 0,
                message = "comment",
                replyToComment = 0
            )
        )
    }

    @Test
    fun shouldNotThrow() {
        val service = WallService
        service.add(
            Post(
                ownerId = 100,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )
        service.add(
            Post(
                ownerId = 101,
                fromId = 20,
                createdBy = 30,
                date = 0,
                text = "This is the post",
                replyOwnerId = 100,
                replyPostId = 101,
                friendsOnly = true,
                comments = "comment",
                likes = null,
                views = null,
                postType = "post",
                signerId = 1,
                canPin = true,
                canDelete = true,
                canEdit = true,
                isPinned = true,
                markedAsAds = true,
                isFavorite = true,
                postponedId = 0,
                attachments = null
            )
        )

        val result = service.createComment(
            Comment(
                ownerId = 0,
                postId = 1,
                fromGroup = 0,
                message = "comment",
                replyToComment = 0
            )
        )
        assertTrue(result)
    }
}

