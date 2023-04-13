data class Note(
    val id: Int =0,
    var title: String = "", //Заголовок заметки.
    val text: String = "", //Текст заметки.
    val privacy: Int = 3,
    /*Уровень доступа к заметке. Возможные значения:
    0 — все пользователи,
    1 — только друзья,
    2 — друзья и друзья друзей,
    3 — только пользователь. */
    val markToRemove: Boolean = false,  //Помечена ли заметка на удаление? По умолчанию, при создании - нет.
    val commentPrivacy:Int = 3,
    /*  Уровень доступа к комментированию заметки.
    Возможные значения:
    0 — все пользователи,
    1 — только друзья,
    2 — друзья и друзья друзей,
    3 — только пользователь. */
    val mutableListComments: MutableList<Comment>? = mutableListOf<Comment>()
)
