data class GiftAttachment (
    override val id: Long,
    override val type: String = "gift",
    override val created: Long = 0L)
    : Attachment {
    val imageId = this.id //Id подарка
    val thumb256: String =""   //URL изображения 256x256px
    val thumb96: String =""  //URL изображения 96x96px
}