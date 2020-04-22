package fxzou.common

import org.junit.jupiter.api.Test

internal class TreeNodeTest {

    @Test
    fun `test tree node parse`() {
        val root = TreeNode.parse(listOf(1, 2, 3, null, 5, null, 4, 6, 7, 8, 9))
        // test by debug -_-!
        println(root)
    }


}