import org.exampl.TrNode
import org.testng.Assert
import org.testng.annotations.Test

class TrNode_test {
    @Test
    fun `test default constructor`() {
        val node = TrNode<Int>()

        Assert.assertNull(node.value, "Default value should be null")
        Assert.assertNull(node.left, "Default left child should be null")
        Assert.assertNull(node.right, "Default right child should be null")
    }

    @Test
    fun `test single value constructor`() {
        val node = TrNode(42)

        Assert.assertEquals(node.value, 42, "Value should be set")
        Assert.assertNull(node.left, "Left should be null for single value constructor")
        Assert.assertNull(node.right, "Right should be null for single value constructor")
    }

    @Test
    fun `test parameterized constructor`() {
        val leftChild = TrNode(2)
        val rightChild = TrNode(3)
        val root = TrNode(1, leftChild, rightChild)

        Assert.assertEquals(root.value, 1, "Root value should be 1")
        Assert.assertEquals(root.left?.value, 2, "Left child value should be 2")
        Assert.assertEquals(root.right?.value, 3, "Right child value should be 3")
    }

    @Test
    fun `test copy constructor`() {
        val original = TrNode(10,
            TrNode(5),
            TrNode(15)
        )
        val copy = TrNode(original)

        Assert.assertEquals(copy.value, original.value, "Value should be copied")
        Assert.assertEquals(copy.left?.value, original.left?.value, "Left value should be copied")
        Assert.assertEquals(copy.right?.value, original.right?.value, "Right value should be copied")
    }

    @Test
    fun `test value property`() {
        val node = TrNode<String>()
        node.value = "test"

        Assert.assertEquals(node.value, "test", "Value should be settable")
    }

    @Test
    fun `test left property`() {
        val node = TrNode<Double>()
        val left = TrNode(3.14)
        node.left = left

        Assert.assertEquals(node.left?.value, 3.14, "Left child value should be 3.14")
        Assert.assertSame(node.left, left, "Should store the same left node instance")
    }

    @Test
    fun `test right property`() {
        val node = TrNode<Boolean>()
        val right = TrNode(true)
        node.right = right

        Assert.assertTrue(node.right?.value == true, "Right child value should be true")
        Assert.assertSame(node.right, right, "Should store the same right node instance")
    }
}