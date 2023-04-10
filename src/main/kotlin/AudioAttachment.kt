data class AudioAttachment(override val type: String, val audio: Audio) : Attachment
data class Audio(
    val audioId: Long, //Id аудиозаписи
    val ownerId: Int = 0,  //Id того кто загрузил аудиозапись
    val artist: String = "", //Наименование исполнителя
    val title: String = "",    //Название аудиозаписи/трека
    val duration: Int = 0, //Длительность аудио в секундах
    val url: String = "", //Ссылка на mp3
    val albumId: Int = 0,    //Id альбома аудиозаписи
    val genre: Int = 0,   //Id жанра аудиозаписи (TODO каталог жанров)
    val dateCreated: Long = 0L //Дата загрузки аудиозаписи
)

