class ArchiveAttachment(
    override val id: Long,
    override val type: String = "archive",
    override val created: Long = 0L)
    : Attachment {
    val imageId = this.id //Id архива
    val ownerId: Int = 0  //Id владельца
    val title: String =""    //Название архива
    val dateCreated = this.created //Дата загрузки архива
}