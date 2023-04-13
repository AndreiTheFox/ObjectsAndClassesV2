object NotesService {
    var mutableListNotes = mutableListOf<Note>()
    fun add(note: Note): Note {            //Создает новую заметку
        val noteToAdd: Note = note.copy()
        mutableListNotes.add(noteToAdd)
        println("В список добавлена заметка: ")
        println(noteToAdd)
        return mutableListNotes.last()  //После успешного выполнения возвращает созданную заметку.
    }

    fun createCommentToNote(
        noteId: Int,
        comment: Comment,
    ): Comment {    //Добавляет новый комментарий к заметке с указанным ID заметки.
        val commentToAdd: Comment = comment.copy()
        val noteForComment: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note
        if (noteForComment.commentPrivacy == 0) {
            noteForComment.mutableListComments?.add(comment)
            println(noteForComment.mutableListComments?.get(0)?.content)
            println("Добавлен комментарий к записи с ID: $noteId")
        } else println("В доступе к комментированию заметки отказано")
        return comment
    }

    fun deleteNote(noteId: Int) { //update markToRemove = true
        val noteForDelete: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note
        val noteForReplace: Note = noteForDelete.copy(markToRemove = true)
        mutableListNotes[noteId] =
            noteForReplace //Замена заметки на копию заметки с markToRemove, т.к. Note - DataClass
    }

    fun deleteComment(
        noteId: Int,
        commentId: Int,
    ) {    //Удаление комментария с указанным ID к заметке с её ID markForDelete: Boolean = true
        val noteFind: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note   //Нашли заметку
        val findComment: Comment =
            (noteFind.mutableListComments?.getOrNull(commentId) ?: "Комментарий не найден") as Comment   //Нашли коммент
        val noteCommentForReplace: Comment =
            (findComment.copy(markForDelete = true)) //Скопировали коммент с пометкой на удаление
        noteFind.mutableListComments?.set(
            commentId,
            noteCommentForReplace
        )     //Заменили найденный комментарий у найденной заметки с проставленной отметкой на удаление
    }

    fun editNote(noteId: Int, newText: String) {
        val noteFind: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note   //Нашли заметку
        val noteForReplace: Note = noteFind.copy(text = newText)
        mutableListNotes[noteId] = noteForReplace //Замена заметки на копию заметки с новым текстом
    }

    fun editComment(noteId: Int, commentId: Int, newComment: String) {
        val noteFind: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note   //Нашли заметку
        val findComment: Comment =
            (noteFind.mutableListComments?.getOrNull(commentId) ?: "Комментарий не найден") as Comment   //Нашли коммент
        val noteCommentForReplace: Comment =
            (findComment.copy(content = newComment)) //Скопировали коммент с обновленным текстом
        noteFind.mutableListComments?.set(
            commentId,
            noteCommentForReplace
        )     //Заменили найденный комментарий у найденной заметки с проставленной отметкой на удаление
    }

    fun getNotes(): MutableList<Note> {    //Возвращает список всех заметок
        return mutableListNotes
    }

    fun getNoteById(noteId: Int): Note {    //Возвращает заметку по ID
        return (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note
    }

    fun getComments(noteId: Int): MutableList<Comment>? {   //Возвращает список комментариев к заметке.
        val noteFind: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note   //Нашли заметку
        return noteFind.mutableListComments //Вернули лист комментариев к заметке
    }

    fun restoreComment(noteId: Int, commentId: Int) {
        val noteFind: Note = (mutableListNotes.getOrNull(noteId) ?: "Заметки не найдено") as Note   //Нашли заметку
        val findComment: Comment =
            (noteFind.mutableListComments?.getOrNull(commentId) ?: "Комментарий не найден") as Comment   //Нашли коммент
        val noteCommentForReplace: Comment =
            (findComment.copy(markForDelete = false)) //Скопировали коммент с пометкой восстановления
        noteFind.mutableListComments?.set(
            commentId,
            noteCommentForReplace
        )     //Заменили найденный комментарий у найденной заметки с проставленной отметкой на удаление
    }
}