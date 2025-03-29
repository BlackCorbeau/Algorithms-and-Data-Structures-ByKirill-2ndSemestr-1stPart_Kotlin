import org.exampl.BinTree
import org.testng.Assert
import org.testng.annotations.Test

class BinTree_test {
    @Test
    fun `insert into empty tree`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        Assert.assertEquals(tree.root?.value, 10)
        Assert.assertNull(tree.root?.left)
        Assert.assertNull(tree.root?.right)
    }

    @Test
    fun `insert smaller value`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(5)
        Assert.assertEquals(tree.root?.value, 10)
        Assert.assertEquals(tree.root?.left?.value, 5)
        Assert.assertNull(tree.root?.right)
    }

    @Test
    fun `insert larger value`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(15)
        Assert.assertEquals(tree.root?.value, 10)
        Assert.assertNull(tree.root?.left)
        Assert.assertEquals(tree.root?.right?.value, 15)
    }

    @Test
    fun `insert duplicate value should be ignored`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(10) // Дубликат
        Assert.assertEquals(tree.root?.value, 10)
        Assert.assertNull(tree.root?.left)
        Assert.assertNull(tree.root?.right)
    }

    @Test
    fun `multiple inserts build correct BST`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)
        tree.insert(3)
        tree.insert(7)
        tree.insert(12)
        tree.insert(20)

        // Проверяем корень
        Assert.assertEquals(tree.root?.value, 10)

        // Левое поддерево
        Assert.assertEquals(tree.root?.left?.value, 5)
        Assert.assertEquals(tree.root?.left?.left?.value, 3)
        Assert.assertEquals(tree.root?.left?.right?.value, 7)

        // Правое поддерево
        Assert.assertEquals(tree.root?.right?.value, 15)
        Assert.assertEquals(tree.root?.right?.left?.value, 12)
        Assert.assertEquals(tree.root?.right?.right?.value, 20)
    }
}