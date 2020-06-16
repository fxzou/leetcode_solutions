package fxzou.hard

import fxzou.common.TreeNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SerializeAndDeserializeBinaryTreeTest {

    @Test
    fun `test serialize and deserialize`() {
        val answer = SerializeAndDeserializeBinaryTree()
        val serialize = answer.serialize(TreeNode.parse(listOf(1, 2, 3, null, 4, 0)))
        assertEquals(serialize, answer.serialize(answer.deserialize(serialize)))
    }

    @Test
    fun `test serialize and deserialize null`() {
        val answer = SerializeAndDeserializeBinaryTree()
        val serialize = answer.serialize(null)
        assertEquals(serialize, answer.serialize(answer.deserialize(serialize)))
    }

}