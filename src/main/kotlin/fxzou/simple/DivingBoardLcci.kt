package fxzou.simple

class DivingBoardLcci {
    fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
        if (k == 0) return intArrayOf()
        if (shorter == longer) return intArrayOf(longer * k)
        return (0..k).map { it * longer + shorter * (k - it) }.toIntArray()
    }
}