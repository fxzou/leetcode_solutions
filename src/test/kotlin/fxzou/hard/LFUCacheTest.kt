package fxzou.hard

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LFUCacheTest {

    @Test
    fun `test lfu`() {
        val cache = LFUCache(2)

        cache.put(1, 1)
        cache.put(2, 2)
        assertEquals(1, cache.get(1))       // 返回 1
        cache.put(3, 3)    // 去除 key 2
        assertEquals(-1, cache.get(2))         // 返回 -1 (未找到key 2)
        assertEquals(3, cache.get(3))         // 返回 3
        cache.put(4, 4)    // 去除 key 1
        assertEquals(-1, cache.get(1))         // 返回 -1 (未找到 key 1)
        assertEquals(3, cache.get(3))        // 返回 3
        assertEquals(4, cache.get(4))         // 返回 4
    }

    @Test
    fun `test lfu repeat put`() {
        val cache = LFUCache(2)

        cache.put(3, 1)
        cache.put(2, 1)
        cache.put(2, 2)
        cache.put(4, 4)
        assertEquals(2, cache.get(2))
    }

    @Test
    fun `test lfu 3`() {
        val cache = LFUCache(2)

        cache.put(2, 1)
        cache.put(3, 2)
        assertEquals(2, cache.get(3))
        assertEquals(1, cache.get(2))
        cache.put(4, 3)
        assertEquals(1, cache.get(2))
        assertEquals(-1, cache.get(3))
        assertEquals(3, cache.get(4))
    }

    @Test
    fun `test lfu 4`() {
        val cache = LFUCache(3)

        cache.put(1, 1)
        cache.put(2, 2)
        cache.put(3, 3)
        cache.put(4, 4)
        assertEquals(4, cache.get(4))
        assertEquals(3, cache.get(3))
        assertEquals(2, cache.get(2))
        assertEquals(-1, cache.get(1))
        cache.put(5, 5)
        assertEquals(-1, cache.get(1))
        assertEquals(2, cache.get(2))
        assertEquals(3, cache.get(3))
        assertEquals(-1, cache.get(4))
        assertEquals(5, cache.get(5))
    }

}