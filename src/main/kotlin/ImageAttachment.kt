data class ImageAttachment(override val type: String, val image: Image): Attachment
data class  Image(
    val imageId: Long, //Id фото/изображения
    val albumId: Int = 0,    //Id альбома
    val ownerId: Int = 0,  //Id владельца фото/изображения
    val title: String = "",    //Название Фото/изображения
    val dateCreated: Long = 0L //Дата загрузки фото/изображения
)