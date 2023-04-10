data class VideoAttachment(override val type: String, val video: Video) : Attachment
data class Video(
    val videoId: Long = 0, //Id видеозаписи
    val ownerId: Int = 0,  //Id того кто загрузил видео
    val title: String = "",    //Название видеозаписи
    val description: String = "", // Описание видеозаписи
    val duration: Int = 0, //Длительность в секундах
    val albumId: Int = 0,       //Id альбома видео
    val dateCreated: Long = 0L,  //Дата загрузки аудиозаписи
    val views: Int = 0,      //Количество просмотров видео
    val player: String = "", //Видеоплеер для воспроизведения, в формате URL
    val isPrivate: Boolean = true, //Является ли загружаемое видео приватным. По умолчанию - является.
    val repeat: Boolean = false, //Поставлено ли загружаемое видео на авто повтор. По умолчанию - нет.
    val likes: Likes = Likes()    //Параметр лайков к видео
)