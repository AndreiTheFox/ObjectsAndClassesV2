class OtherFilesAttachment(
    override val id: Long,
    override val type: String = "other",
    override val created: Long = 0L)
    : Attachment {
    val imageId = this.id //Id файла
    val ownerId: Int = 0  //Id владельца
    val title: String =""    //Название файла
    val dateCreated = this.created //Дата загрузки
}