fun main(args: Array<String>) {
    val newPost = Post(
        content = "Это первая публикация"
    )
    val newPost2 = Post(
        content = "Это вторая публикация"
    )
    WallService.add(newPost)
    WallService.add(newPost2)
    val newComment: Comment = Comment (1,0, 0L,"Это тестовый комментарий")
    WallService.createComment(2,newComment)

   // WallService.update(newPost.copy(id=1))
    //WallService.addAttachment("video")
   // println (newImageAttachment)
}