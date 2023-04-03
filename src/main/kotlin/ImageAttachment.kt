data class ImageAttachment(
    override val id: Long,
    override val type: String = "image",
    override val created: Long = 0L)
    : Attachment {
    val imageId = this.id //Id фото/изображения
    val albumId: Int = 0    //Id альбома
    val ownerId: Int = 0  //Id владельца фото/изображения
    val title: String =""    //Название Фото/изображения
    val dateCreated = this.created //Дата загрузки фото/изображения
}