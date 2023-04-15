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
        val noteForComment: Note = getNoteById(noteId)
        if (noteForComment.commentPrivacy == 0) {
            noteForComment.mutableListComments.add(commentToAdd)
            println("Добавлен комментарий к записи с ID: $noteId")
        } else println("В доступе к комментированию заметки отказано")
        return commentToAdd
    }

    fun deleteNote(noteId: Int): Note { //update markToRemove = true
        val noteForDelete: Note = getNoteById(noteId)
        val noteForReplace: Note = noteForDelete.copy(markToRemove = true)
        mutableListNotes[noteId] =
            noteForReplace //Замена заметки на копию заметки с markToRemove, т.к. Note - DataClass
        return noteForReplace
    }

    fun deleteComment(
        noteId: Int,
        commentId: Int,
    ): Comment {    //Удаление комментария с указанным ID к заметке с её ID markForDelete: Boolean = true
        val noteFind: Note = getNoteById(noteId)   //Нашли заметку
        val findComment: Comment = getComments(noteId).getOrNull(commentId)
            ?: throw CommentNotFoundException("Комментарий с таким ID: $commentId не найден") //Поиск комментария
        val noteCommentForReplace: Comment =
            (findComment.copy(markForDelete = true)) //Скопировали коммент с пометкой на удаление
        noteFind.mutableListComments[commentId] =
            noteCommentForReplace     //Заменили найденный комментарий у найденной заметки с проставленной отметкой на удаление
        return noteCommentForReplace    //Возвращает комментарий с проставленной отметкой об удалении
    }

    fun editNote(noteId: Int, newText: String): Note {
        val noteFind: Note = getNoteById(noteId)   //Нашли заметку
        val noteForReplace: Note = noteFind.copy(text = newText)
        mutableListNotes[noteId] = noteForReplace //Замена заметки на копию заметки с новым текстом
        return noteForReplace //Возвращает отредактированную заметку
    }

    fun editComment(noteId: Int, commentId: Int, newComment: String): Comment {

        val findComment: Comment = getComments(noteId).getOrNull(commentId)
            ?: throw CommentNotFoundException("Комментарий с таким ID: $commentId не найден") //Поиск комментария
        val noteCommentForReplace: Comment =
            (findComment.copy(content = newComment)) //Скопировали коммент с обновленным текстом
        mutableListNotes[noteId].mutableListComments[commentId] =
            noteCommentForReplace   //Заменили найденный комментарий у найденной заметки с проставленной отметкой на удаление
        return noteCommentForReplace
    }

    fun getNotes(): MutableList<Note> {    //Возвращает список всех заметок
        return mutableListNotes
    }

    fun getNoteById(noteId: Int): Note {    //Возвращает заметку по ID
        return mutableListNotes.getOrNull(noteId)
            ?: throw NoteNotFoundException("Заметка с таким ID: $noteId не найдена")
    }

    fun getComments(noteId: Int): MutableList<Comment> {   //Возвращает список комментариев к заметке.
        val noteFind: Note = getNoteById(noteId)   //Нашли заметку
        return noteFind.mutableListComments //Вернули лист комментариев к заметке
    }

    fun restoreComment(noteId: Int, commentId: Int): Comment {
        val noteFind: Note = getNoteById(noteId)   //Нашли заметку
        val findComment: Comment = getComments(noteId).getOrNull(commentId)
            ?: throw CommentNotFoundException("Комментарий с таким ID: $commentId не найден") //Поиск комментария
        val noteCommentForReplace: Comment =
            (findComment.copy(markForDelete = false)) //Скопировали коммент с пометкой восстановления
        noteFind.mutableListComments[commentId] =
            noteCommentForReplace   //Заменили найденный комментарий у найденной заметки с проставленной отметкой на удаление
        return noteCommentForReplace //Возвращает восстановленный комментарий
    }

    fun clearNotesAndComments() {
        mutableListNotes.clear()
    }
}