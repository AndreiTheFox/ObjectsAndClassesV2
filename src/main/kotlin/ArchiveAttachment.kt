data class ArchiveAttachment(override val type: String, val archive: Archive) : Attachment

data class Archive(
    val archId: Long, //Id архива
    val ownerId: Int = 0,  //Id владельца
    val title: String = "",    //Название архива
    val dateCreated: Long = 0L  //Дата загрузки архива
)