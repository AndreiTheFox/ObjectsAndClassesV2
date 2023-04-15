import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class NotesServiceTest {

    @Before
    fun clearNotesBeforeTest() {
        NotesService.clearNotesAndComments()
    }

    @Test
    fun addNote() {
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        val result = NotesService.add(testNote)
        assertEquals(
            testNote,
            result
        )      //Проверка добавления заметки. Функция add возвращает последнюю добавленную заметку в списке.
    }

    @Test
    fun createCommentToExistingNote() { //Добавление комментария к Существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        val testComment = Comment(content = "Тестовый комментарий к Тестовой заметке")
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val result = NotesService.createCommentToNote(0, testComment)
        assertEquals(testComment, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun createCommentToNotExistingNote() { //Добавление комментария к НЕ Существующей заметке - должно выдать исключение NoteNotFoundException
        val testComment = Comment(content = "Тестовый комментарий к Тестовой заметке")
        NotesService.createCommentToNote(0, testComment)
    }

    @Test
    fun deleteExistingNote() {  //Пометка на удаление Существующей в списке заметки
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val result = NotesService.deleteNote(0)  //ФУНКЦИЯ ПРОСТАВЛЕНИЯ ОТМЕТКИ УДАЛЕНИЯ
        assertEquals(true, result.markToRemove)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteNotExistingNote() {  //Пометка на удаление НЕ Существующей в списке заметки - должно выдать исключение NoteNotFoundException
        NotesService.deleteNote(0)  //ФУНКЦИЯ ПРОСТАВЛЕНИЯ ОТМЕТКИ УДАЛЕНИЯ
    }

    @Test
    fun deleteCommentNoteExistCommentExist() {  //Удаление существующего комментария к существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        val testComment = Comment(content = "Тестовый комментарий к Тестовой заметке")
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        NotesService.createCommentToNote(0, testComment) //Добавление комментария к существующей заметке
        val result = NotesService.deleteComment(0, 0)
        assertEquals(true, result.markForDelete)
    }

    @Test(expected = NoteNotFoundException::class)
    fun deleteCommentNoteNotExist() {  //Попытка удаления комментария к НЕ существующей заметке - должно выдать исключение NoteNotFoundException
        NotesService.deleteComment(0, 0)
    }

    @Test(expected = CommentNotFoundException::class)
    fun deleteCommentNoteExistCommentNotExist() {  //Попытка удаления НЕ существующего комментария к Существующей заметке - должно выдать исключение CommentNotFoundException
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        NotesService.deleteComment(0, 0)
    }

    @Test
    fun editNoteExist() {   //Редактирование существующей заметки
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок.
        val newText = "Это новый текст заметки"
        val result = NotesService.editNote(0, newText)
        assertEquals(newText, result.text) //Проверка, что в Заметке теперь новый текст
    }

    @Test(expected = NoteNotFoundException::class)
    fun editNoteNotExist() {   //Редактирование НЕ существующей заметки
        val newText = "Это новый текст заметки"
        NotesService.editNote(0, newText)
    }

    @Test
    fun editCommentExistNoteExist() { //Редактирование существующего комментария к существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        val testComment = Comment(content = "Тестовый комментарий к Тестовой заметке")
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        NotesService.createCommentToNote(0, testComment) //Добавление комментария к существующей заметке
        val newText = "Это новый текст комментария"
        val result = NotesService.editComment(0, 0, newText)
        assertEquals(newText, result.content) //Проверка, что в Комментарии теперь новый текст
    }

    @Test(expected = CommentNotFoundException::class)
    fun editCommentNotExistNoteExist() { //Редактирование НЕ существующего комментария к Существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val newText = "Это новый текст комментария"
        NotesService.editComment(0, 0, newText)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editCommentNoteNotExist() {  //Попытка редактирования комментария к НЕ существующей заметке - должно выдать исключение NoteNotFoundException
        val newText = "Это новый текст комментария"
        NotesService.editComment(0, 0, newText)
    }

    @Test
    fun getNotesExists() {
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val result = NotesService.getNotes()
        assertEquals(
            1,
            result.size
        )    //Проверка того, что список заметок увеличился на 1 добавленную заметку и возвращает размер списка заметок
    }

    @Test
    fun getNotesNotExist() {
        val result = NotesService.getNotes()
        assertEquals(0, result.size)    //Проверка того, что список заметок = 0. возвращает размер списка заметок
    }

    @Test
    fun getNoteByIdNoteExist() { //Заметка Существует в списке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val result = NotesService.getNoteById(0)
        assertEquals(testNote, result)
    }

    @Test(expected = NoteNotFoundException::class)
    fun getNoteByIdNoteNotExist() { //Заметка НЕ Существует в списке - должно выдать исключение NoteNotFoundException
        NotesService.getNoteById(0)
    }

    @Test
    fun getCommentsExist() { //Запрос списка комментариев к существующей заметке, который у неё Есть
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        val testComment = Comment(content = "Тестовый комментарий к Тестовой заметке")
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        NotesService.createCommentToNote(0, testComment) //Добавление комментария к существующей заметке
        val result = NotesService.getComments(0)
        assertEquals(1, result.size)    //Сравнение размера списка тестовых комментариев к тестовой заметке.
    }

    @Test(expected = NoteNotFoundException::class)
    fun getCommentsNoteNotExist() { //Запрос списка комментариев к НЕ существующей заметке
        NotesService.getComments(0)
    }

    @Test
    fun getCommentsNotExistNoteExist() { //Запрос пустого списка комментариев к существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val result = NotesService.getComments(0)
        assertEquals(0, result.size) //Размер списка комментариев к заметке равен 0, т.к. нет никаких комментариев
    }

    @Test
    fun restoreCommentNoteExist() {  //Восстановление комментария к существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        val testComment = Comment(content = "Тестовый комментарий к Тестовой заметке")
        NotesService.createCommentToNote(0, testComment) //Добавление комментария к существующей заметке
        NotesService.deleteComment(0, 0) //Проставление отметки об удалении на комментарии
        val result = NotesService.restoreComment(0, 0)   //Изменение отметки об удалении на false
        assertEquals(false, result.markForDelete) //Проверка, что комментарий больше не помечен на удаление
    }

    @Test(expected = NoteNotFoundException::class)
    fun restoreCommentNoteNotExist() {  //Попытка Восстановление комментария к НЕ существующей заметке
        NotesService.restoreComment(0, 0)   //Попытка Изменения отметки об удалении на false
    }

    @Test(expected = CommentNotFoundException::class)
    fun restoreCommentNotExistNoteExist() {  //Восстановление НЕ Существующего комментария к существующей заметке
        val testNote = Note(
            id = 0,
            title = "Это тестовая заметка",
            text = "Текст тестовой заметки виден всем",
            privacy = 0,
            markToRemove = false,
            commentPrivacy = 0
        )
        NotesService.add(testNote)  //Добавление заметки в список заметок, чтобы был объект для комментов.
        NotesService.restoreComment(0, 0)   //Изменение отметки об удалении на false
    }
}