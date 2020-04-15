package fxzou.common

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "${`val`}${if (next != null) "->${next}" else ""}"
    }

    companion object {
        fun parse(linkStr: String): ListNode {
            var resultHead: ListNode? = null
            var foot: ListNode? = null
            linkStr.split("->")
                .map { it.toInt() }
                .forEach {
                    if (resultHead == null) {
                        resultHead = ListNode(it)
                        foot = resultHead
                    } else {
                        foot!!.next = ListNode(it)
                        foot = foot!!.next
                    }
                }
            return resultHead!!
        }
    }
}