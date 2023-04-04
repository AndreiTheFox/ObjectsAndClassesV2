data class GiftAttachment (override val type: String = "gift", val gift: Gift): Attachment
data class Gift (
    val imageId: Long, //Id подарка
    val thumb256: String = "",   //URL изображения 256x256px
    val thumb96: String = ""  //URL изображения 96x96px
)