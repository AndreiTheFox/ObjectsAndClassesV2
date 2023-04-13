fun main(args: Array<String>) {
    val note1: Note  = Note(id =0, title = "Это первая заметка", text = "Текст первой заметки виден всем", privacy = 1, markToRemove = false, commentPrivacy = 0)
    val note2: Note  = Note(id =9999, title = "Это вторая заметка", text = "Текст второй заметки виден мне", privacy = 3, markToRemove = false, commentPrivacy = 3)
    val commentForNote = Comment (content = "Тестовый комментарий к заметке")

    NotesService.add(note1)
    NotesService.add(note2)
 //   println(Notes.mutableListNotes.getOrNull(1)?.text ?: "Заметки не найдено")


  //  Notes.createCommentToNote(0,commentForNote)
    println(NotesService.mutableListNotes[1].markToRemove)

    NotesService.deleteNote(1)

    println(NotesService.mutableListNotes[1].markToRemove)

}