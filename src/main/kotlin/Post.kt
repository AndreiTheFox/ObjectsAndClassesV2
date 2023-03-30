data class Post(
    var id: Int = 0,                //Идентификатор записи.
    val views: Int = 0,             //Информация о просмотрах записи
    val ownerId: Int = 0,           //Идентификатор владельца стены, на которой размещена запись.
    val fromId: Int = 0,            //Идентификатор автора записи (от чьего имени опубликована запись).
    val createdBy: Int = 0,         //Идентификатор администратора, который опубликовал запись
    val dateCreated: Long = 0L,      //Дата публикации записи
    val content: String,        //Конь тент
    val replyOwnerId: Int = 0,      //Идентификатор владельца записи, в ответ на которую была оставлена текущая.
    val replyPostId: Int = 0,       //Идентификатор записи, в ответ на которую была оставлена текущая.
    val friendsOnly: Boolean = false,   //True, если запись была создана с опцией «Только для друзей».
    val postType: String = "post",       //Тип записи, может принимать следующие значения: post, copy, reply, postpone, suggest.
    val signerId: Int = 0,          //Идентификатор автора, если запись была опубликована от имени сообщества и подписана пользователем.
    val canPin: Boolean = true,        //Может ли текущий пользователь закрепить запись (1 — может, 0 — не может).
    val canDelete: Boolean = true,     //Может ли текущий пользователь удалить запись (1 — может, 0 — не может).
    val canEdit: Boolean = true,       //Может ли текущий пользователь изменить запись (1 — может, 0 — не может).
    val isPinned: Boolean = false,      //Информация о том, что запись закреплена.(True - закреплена, 0 - нет).
    val markedAsAds: Boolean = false,   //Является ли запись рекламой (True - реклама, 0 - нет).
    val isFavorite: Boolean = false,    //true, если объект добавлен в закладки у текущего пользователя.
    val comments: Comments = Comments(),      //Информация о комментариях к записи, класс с полями
    val copyright: Copyright = Copyright(),    //Информация об источнике
    val likes: Likes = Likes(),
)