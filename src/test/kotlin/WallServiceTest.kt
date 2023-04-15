import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class WallServiceTest {
    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun addPostIdChanged() {
        val testContent = "Это тестовая публикация"
        val testPost = Post(content = testContent)
        val result = WallService.add(testPost)

        assertEquals(1, result.id)
    }

    @Test
    fun updateIdExist() {
        val testContent = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post(content = testContent)
        WallService.add(testPost)
        val result = WallService.update(testPost.copy(id = 1))
        assertEquals(true, result)
    }

    @Test
    fun updateIdNotExist() {
        val testContent = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post(content = testContent)
        val result = WallService.update(testPost)
        assertEquals(false, result)
    }
    @Test
    fun createCommentPostExists(){
        val testComment = Comment (1,0, 0L,"Это тестовый комментарий")
        val testContent = "Это тестовая публикация для проверки обновления поста, когда ID существует в массиве"
        val testPost = Post(content = testContent)
        WallService.add(testPost)
        val result = WallService.createComment(1,testComment)
        assertEquals(testComment,result)
    }
    @Test(expected = PostNotFoundException::class)
    fun createCommentPostNotExists(){
        val testComment = Comment (1,0, 0L,"Это тестовый комментарий")
        WallService.createComment(1,testComment)
    }
}