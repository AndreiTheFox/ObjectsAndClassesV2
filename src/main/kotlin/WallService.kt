object WallService {
    private var posts = emptyArray<Post>()
    private var arrayPostId: Int = 0
    private var attachId: Long = 0
    private var attachments = emptyArray<Attachment>()
      fun add(post: Post): Post {
        arrayPostId += 1
        val modifiedPost: Post = post.copy(id = arrayPostId)
        posts += modifiedPost
        println("В массив добавлен пост: ")
        println(modifiedPost)
        return posts.last()
    }
    fun addAttachment(type: String): Attachment {   //Тип файла: archive, image, audio, video, gift, other
        attachId += 1
        val attach: Attachment = when (type) {
            "image" -> ImageAttachment(attachId)
            "archive" -> ArchiveAttachment(attachId)
            "audio" -> AudioAttachment(attachId)
            "video" -> VideoAttachment(attachId)
            "gift" -> GiftAttachment(attachId)
        else -> OtherFilesAttachment(attachId)    // other files
        }
        attachments +=attach
        println("В массив добавлено вложение с типом $type: ")
        return attachments.last()
    }
      fun update(postToUpdate: Post): Boolean {
        var found = false
        for ((index, post) in this.posts.withIndex()) {
            if (postToUpdate.id == post.id) {
                println("Найден пост совпадающий с запросом c ID:")
                println(post.id)
                found = true
                posts[index] = postToUpdate
                println("Информация будет полностью обновлена в посте:")
                println(posts[index])
            } else found = false
        }
        return found
    }
    fun clear() {
        posts = emptyArray()
        arrayPostId = 0
    }
}