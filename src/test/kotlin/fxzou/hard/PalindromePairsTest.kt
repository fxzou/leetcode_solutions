package fxzou.hard

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PalindromePairsTest {

    @Test
    fun `test result`() {
        val ans = PalindromePairs()

        assertThat(
            ans.palindromePairs(
                arrayOf("abcd", "dcba", "lls", "s", "sssll")
            )
        )
            .containsOnly(
                listOf(0, 1),
                listOf(1, 0),
                listOf(3, 2),
                listOf(2, 4)
            )

        assertThat(
            ans.palindromePairs(
                arrayOf("bat","tab","cat")
            )
        )
            .containsOnly(
                listOf(0, 1),
                listOf(1, 0)
            )

        assertThat(
            ans.palindromePairs(
                arrayOf("tat","ta","")
            )
        )
            .containsOnly(
                listOf(1, 0),
                listOf(0, 2),
                listOf(2, 0)
            )


    }

}