package fxzou.hard

class ReverseNodesInKGroup {

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
        override fun toString(): String {
            return "${`val`}${if (next != null) "->${next}" else ""}"
        }
    }

    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var resultHead: ListNode? = null
        var footOfPreGroup: ListNode? = null
        var headOfGroup = head
        while (headOfGroup != null) {
            var footOfGroup = headOfGroup
            for (i in 1..k - 1) {
                if (footOfGroup!!.next == null) {
                    return resultHead
                }
                footOfGroup = footOfGroup.next
            }
            val headOfNewGroup = footOfGroup!!.next
            var newHeadOfGroup = headOfGroup
            while (newHeadOfGroup != footOfGroup) {
                val oldHeadOfGroup = newHeadOfGroup
                newHeadOfGroup = oldHeadOfGroup!!.next
                if (footOfPreGroup != null) {
                    footOfPreGroup.next = newHeadOfGroup
                }
                oldHeadOfGroup.next = footOfGroup.next
                footOfGroup.next = oldHeadOfGroup
            }
            footOfPreGroup = headOfGroup
            headOfGroup = headOfNewGroup
            if (resultHead == null) {
                resultHead = footOfGroup
            }
        }
        return resultHead
    }
}