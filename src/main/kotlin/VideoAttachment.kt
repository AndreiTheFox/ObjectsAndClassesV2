data class VideoAttachment (
    override val id: Long,
    override val type: String = "video",
    override val created: Long = 0L)
    : Attachment {
    val videoId = this.id //Id аудиозаписи
    val ownerId: Int = 0  //Id того кто загрузил видео
    val title: String =""    //Название видеозаписи
    val description: String = "" // Описание видеозаписи
    val duration: Int =0 //Длительность в секундах
    val albumId: Int = 0    //Id альбома видео
    val dateCreated = this.created //Дата загрузки аудиозаписи
    val views: Int =0 //Количество просмотров видео
    val player: String ="" //Видеоплеер для воспроизведения, в формате URL
    val isPrivate: Boolean = true //Является ли загружаемое видео приватным. По умолчанию - является.
    val repeat: Boolean = false //Поставлено ли загружаемое видео на авто повтор. По умолчанию - нет.
    val likes = Likes() //Параметр лайков к видео
}