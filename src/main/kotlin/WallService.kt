object WallService {
    private var posts = emptyArray<Post>()
    private var arrayPostId: Int = 0
    fun add(post: Post): Post {
        arrayPostId += 1
        val modifiedPost: Post = post.copy(id = arrayPostId)
        posts += modifiedPost
        println("В массив добавлен пост: ")
        println(modifiedPost)
        return posts.last()
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
        var arrayPostId: Int = 0
    }
}