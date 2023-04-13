data class Comment(
    val id: Int = 0,                     //Id коммента
    val fromId: Int = 0,                 //Id автора коммента
    val dateCreated: Long = 0L,          //Дата публикации коммента
    val content: String = "",                //Содержание коммента
    val markForDelete: Boolean = false
)