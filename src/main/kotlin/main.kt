fun main() {
    val note1 = Note(
        id = 0,
        title = "Это первая заметка",
        text = "Текст первой заметки виден всем",
        privacy = 1,
        markToRemove = false,
        commentPrivacy = 0
    )
    val note2 = Note(
        id = 9999,
        title = "Это вторая заметка",
        text = "Текст второй заметки виден мне",
        privacy = 3,
        markToRemove = false,
        commentPrivacy = 3
    )
    val commentForNote = Comment(content = "Тестовый комментарий к заметке")

    NotesService.add(note1)
    NotesService.add(note2)

    NotesService.createCommentToNote(0, commentForNote)
    NotesService.editComment(0, 2, "блаблабла")
    println(NotesService.mutableListNotes[0].mutableListComments[0].content)
}