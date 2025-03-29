import org.exampl.BinTree
import org.testng.Assert
import org.testng.annotations.Test
import org.testng.annotations.BeforeMethod
import org.testng.Assert.*

class BinTree_test {

    private lateinit var tree: BinTree<Int>

    @BeforeMethod
    fun setUp() {
        tree = BinTree()
        // Построим тестовое дерево:
        //       5
        //      / \
        //     3   7
        //    / \   \
        //   1   4   9
        tree.insert(5)
        tree.insert(3)
        tree.insert(7)
        tree.insert(1)
        tree.insert(4)
        tree.insert(9)
    }

    @Test
    fun `find existing root value`() {
        val result = tree.find(5)
        assertNotNull(result)
        assertEquals(result?.value, 5)
    }

    @Test
    fun `find existing left child`() {
        val result = tree.find(3)
        assertNotNull(result)
        assertEquals(result?.value, 3)
    }

    @Test
    fun `find existing right child`() {
        val result = tree.find(7)
        assertNotNull(result)
        assertEquals(result?.value, 7)
    }

    @Test
    fun `find existing leaf node`() {
        val result = tree.find(4)
        assertNotNull(result)
        assertEquals(result?.value, 4)
    }

    @Test
    fun `find non-existing value returns null`() {
        val result = tree.find(2)
        assertNull(result)
    }

    @Test
    fun `find in empty tree returns null`() {
        val emptyTree = BinTree<Int>()
        val result = emptyTree.find(5)
        assertNull(result)
    }

    @Test
    fun `find with custom comparable type`() {
        val stringTree = BinTree<String>()
        stringTree.insert("banana")
        stringTree.insert("apple")
        stringTree.insert("cherry")

        val result = stringTree.find("apple")
        assertNotNull(result)
        assertEquals(result?.value, "apple")
    }

    @Test
    fun `find with copy constructor`() {
        val originalTree = BinTree<Int>()
        originalTree.insert(8)
        originalTree.insert(6)
        originalTree.insert(10)

        val copiedTree = BinTree(originalTree)
        val result = copiedTree.find(6)
        assertNotNull(result)
        assertEquals(result?.value, 6)
    }

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

    @Test
    fun `erase leaf node`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.erase(5)
        Assert.assertEquals(tree.root?.value, 10)
        Assert.assertNull(tree.root?.left)
        Assert.assertNull(tree.root?.right)
    }

    @Test
    fun `erase node with one child`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)
        tree.insert(12)
        tree.erase(15)
        Assert.assertEquals(tree.root?.right?.value, 12)
    }

    @Test
    fun `erase node with two children`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)
        tree.insert(12)
        tree.insert(20)
        tree.insert(11)
        tree.insert(14)
        tree.erase(15)
        // Преемник - минимальное в правом поддереве (11)
        Assert.assertEquals(tree.root?.right?.value, 20)
        // Проверяем что дерево сохранило структуру
        Assert.assertEquals(tree.root?.right?.right?.value, null)
        Assert.assertEquals(tree.root?.right?.left?.value, 12)
    }

    @Test
    fun `erase root node`() {
        val tree = BinTree<Int>()
        tree.insert(10)
        tree.insert(5)
        tree.insert(15)
        tree.erase(10)
        // Преемник - минимальное в правом поддереве (15)
        Assert.assertEquals(tree.root?.value, 15)
        Assert.assertEquals(tree.root?.left?.value, 5)
        Assert.assertNull(tree.root?.right)
    }
}