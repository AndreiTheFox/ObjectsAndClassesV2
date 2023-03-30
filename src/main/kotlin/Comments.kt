data class Comments(
    val count: Int = 0,                //Количество комментариев.
    val canPost: Boolean = true,       //Может ли текущий пользователь комментировать запись (True — может, 0 — не может).
    val groupsCanPost: Boolean = true, //Могут ли сообщества комментировать запись (True — может, 0 — не может).
    val canClose: Boolean = true,      //Может ли текущий пользователь закрыть комментарии к записи (True — может, 0 — не может).
    val canOpen: Boolean = true,       //Может ли текущий пользователь открыть комментарии к записи (True — может, 0 — не может).
)