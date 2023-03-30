data class Likes(
    val count: Int = 0,                 // Число пользователей, которым понравилась запись
    val userLikes: Boolean = false,     //Наличие отметки «Мне нравится» от текущего пользователя (True — есть, 0 — нет);
    val canLike: Boolean = true,        //Может ли текущий пользователь поставить отметку «Мне нравится» (1 — может, 0 — не может);
    val canPublish: Boolean = true,     // Может ли текущий пользователь сделать репост записи (1 — может, 0 — не может).
)