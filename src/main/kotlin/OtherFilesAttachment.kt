data class OtherFilesAttachment(override val type: String, val other: Other): Attachment
data class Other(
    val imageId: Long, //Id файла
    val ownerId: Int = 0,  //Id владельца
    val title: String = "",    //Название файла
    val dateCreated: Long = 0L //Дата загрузки
)