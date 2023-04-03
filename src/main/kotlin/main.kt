fun main(args: Array<String>) {
    val newPost = Post(
        content = "Это первая публикация"
    )
    val newPost2 = Post(
        content = "Это вторая публикация"
    )
  //  WallService.add(newPost)
   // WallService.add(newPost2)
   // WallService.update(newPost.copy(id=1))

    WallService.addAttachment("video")
   // println (newImageAttachment)
}