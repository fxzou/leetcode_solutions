package fxzou.medium

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchInRotatedSortedArrayTest {

    @Test
    fun `test search result`() {
        val search = SearchInRotatedSortedArray()

        assertEquals(4, search.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))

        assertEquals(-1, search.search(intArrayOf(4, 5, 6, 7, 0, 1, 2), 8))

        assertEquals(6, search.search(intArrayOf(4, 5, 6, 7, 8, 9, 10, 0, 1, 2), 10))

        assertEquals(2, search.search(intArrayOf(8, 9, 10, 0, 1, 2, 4, 5, 6, 7), 10))

        assertEquals(0, search.search(intArrayOf(3, 5, 1), 3))

    }

}