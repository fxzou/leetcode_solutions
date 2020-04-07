package fxzou.hard

/**
 * https://leetcode-cn.com/problems/lfu-cache/
 */

/**
 * O(1) version
 */

class LFUCache(capacity: Int) {
    val capacity: Int
    val cache: HashMap<Int, Pair<Int, BothWayLinked.Node<FreqKeyValue>>>
    val frequencys: BothWayLinked<FreqNodeValue>

    init {
        this.capacity = capacity
        cache = HashMap(capacity * 2)
        frequencys = BothWayLinked()
    }

    fun get(key: Int): Int {
        if (capacity == 0) {
            return -1
        }
        val pair = cache.get(key)
        if (pair == null) {
            return -1
        }
        incrementAndReindexFrequency(pair.second)
        return pair.first
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        val pair = cache.get(key)
        if (pair == null) {
            if (capacity == cache.size) {
                clearExpiredKey()
            }
            insert(key, value)
        } else {
            cache.replace(key, Pair(value, pair.second))
            incrementAndReindexFrequency(pair.second)
        }
    }

    private fun clearExpiredKey() {
        val expiredNode = frequencys.last!!.value.linked.last!!
        cache.remove(expiredNode.value.key)
        frequencys.last!!.value.linked.remove(expiredNode)
        if (frequencys.last!!.value.linked.isEmpty()) {
            frequencys.remove(frequencys.last!!)
        }
    }

    private fun incrementAndReindexFrequency(node: BothWayLinked.Node<FreqKeyValue>) {
        val oldParent = node.value.parent
        val frequency = oldParent.value.frequency
        oldParent.value.linked.remove(node)
        if (oldParent.pre != null && oldParent.pre!!.value.frequency == frequency + 1) {
            //TODO: refactor code for code smell, should create new node
            node.value.parent = oldParent.pre!!
            oldParent.pre!!.value.linked.insertToFirst(node)
        } else {
            val newNode = BothWayLinked.Node(FreqNodeValue(frequency + 1, BothWayLinked()))
            //TODO: refactor code for code smell, should create new node
            node.value.parent = newNode
            newNode.value.linked.insertToFirst(node)
            frequencys.insertBeforeAt(newNode, oldParent)
        }
        if (oldParent.value.linked.isEmpty()) {
            frequencys.remove(oldParent)
        }
    }

    private fun insert(key: Int, value: Int) {
        val keyNode: BothWayLinked.Node<FreqKeyValue>
        if (frequencys.isEmpty() || frequencys.last!!.value.frequency != 0) {
            val newNode = BothWayLinked.Node(FreqNodeValue(0, BothWayLinked()))
            keyNode = BothWayLinked.Node(FreqKeyValue(key, newNode))
            newNode.value.linked.insertToFirst(keyNode)
            frequencys.insertToLast(newNode)
        } else {
            val keyValue = FreqKeyValue(key, frequencys.last!!)
            keyNode = BothWayLinked.Node(keyValue)
            frequencys.last!!.value.linked.insertToFirst(keyNode)
        }
        cache.put(key, Pair(value, keyNode))
    }

    class FreqKeyValue(
        var key: Int,
        var parent: BothWayLinked.Node<FreqNodeValue>
    )

    class FreqNodeValue(
        var frequency: Int,
        var linked: BothWayLinked<FreqKeyValue>
    )

    class BothWayLinked<T> {
        class Node<N>(
            var value: N,
            var pre: Node<N>? = null,
            var next: Node<N>? = null
        )

        var last: Node<T>? = null
        var first: Node<T>? = null
        var size: Int = 0

        fun isEmpty(): Boolean {
            return size == 0
        }

        fun insertToFirst(node: Node<T>) {
            node.next = first
            node.pre = null
            first?.let { it.pre = node }
            first = node
            if (last == null) last = node
            size++
        }

        fun insertToLast(node: Node<T>) {
            node.pre = last
            node.next = null
            last?.let { it.next = node }
            last = node
            if (first == null) first = node
            size++
        }

        fun remove(node: Node<T>) {
            if (node == first) first = node.next
            if (node == last) last = node.pre
            node.pre?.let { it.next = node.next }
            node.next?.let { it.pre = node.pre }
            size--
        }

        fun insertBeforeAt(insert: Node<T>, beforeAt: Node<T>) {
            beforeAt.pre?.let { it.next = insert }
            insert.pre = beforeAt.pre
            insert.next = beforeAt
            beforeAt.pre = insert
            if (beforeAt == first) first = insert
            size++
        }
    }
}

/**
 * O(n) version
 */

class LFUCacheOn(capacity: Int) {
    val capacity: Int
    val cache: HashMap<Int, Pair<Int, FrequencyNode>>
    val frequencys: Array<FrequencyNode>

    init {
        this.capacity = capacity
        cache = HashMap(capacity * 2)
        frequencys = Array(capacity) { FrequencyNode.EMPTY }
    }

    fun get(key: Int): Int {
        if (capacity == 0) {
            return -1
        }
        val pair = cache.get(key)
        if (pair == null) return -1
        incrementFrequency(pair.second)
        resortFrequency(pair.second)
        return pair.first
    }

    fun put(key: Int, value: Int) {
        if (capacity == 0) {
            return
        }
        val pair = cache.get(key)
        if (pair != null) {
            incrementFrequency(pair.second)
            resortFrequency(pair.second)
            cache.replace(key, Pair(value, pair.second))
            return
        }
        if (cache.size == capacity) clearInvalidKey()
        val frequencyIndex = cache.size
        val frequencyNode = FrequencyNode(key, 0, frequencyIndex)
        frequencys[frequencyIndex] = frequencyNode
        cache.put(key, Pair(value, frequencyNode))
        resortFrequency(frequencyNode)
    }

    private fun clearInvalidKey() {
        cache.remove(frequencys[capacity - 1].key)
        frequencys[capacity - 1] = FrequencyNode.EMPTY
    }

    private fun incrementFrequency(node: FrequencyNode) {
        node.frequency++
    }

    private fun resortFrequency(node: FrequencyNode) {
        for (i in (node.index - 1 downTo 0)) {
            if (frequencys[i].frequency > frequencys[i + 1].frequency) break
            frequencys[i].index = i + 1
            frequencys[i + 1].index = i
            frequencys[i] = frequencys[i + 1].also { frequencys[i + 1] = frequencys[i] }
        }
    }

    data class FrequencyNode(
        var key: Int,
        var frequency: Int,
        var index: Int
    ) {
        companion object {
            val EMPTY = FrequencyNode(0, 0, 0)
        }
    }
}
