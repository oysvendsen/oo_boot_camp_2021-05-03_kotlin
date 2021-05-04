/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import probability.Chance

internal class ChanceTest {

    companion object {
        private val certain = Chance(1)
        private val likely = Chance(0.75)
        private val equallyLikely = Chance(0.5)
        private val unlikely = Chance(0.25)
        private val impossible = Chance(0)
    }

    @Test fun equality() {
        assertEquals(likely, Chance(0.75))
        assertNotEquals(likely, Chance(0.25))
        assertNotEquals(likely, Any())
        assertNotEquals(likely, null)
    }

    @Test fun `Chance in hash set`() {
        assert(hashSetOf(likely).contains(Chance(0.75)))
        assertEquals(1, hashSetOf(likely, Chance(0.75)).size)
    }

    @Test fun hash() {
        assertEquals(likely.hashCode(), Chance(0.75).hashCode())
        assertEquals(Chance(0.3).hashCode(), (!!Chance(0.3)).hashCode())
    }

    @Test fun not() {
        assertEquals(unlikely, likely.not())
        assertEquals(likely, likely.not().not())
        assertEquals(likely, !!likely)
        assertEquals(impossible, certain.not())
        assertEquals(equallyLikely, equallyLikely.not())
        assertEquals(Chance(0.3), !!Chance(0.3))
    }

    @Test fun and() {
        assertEquals(unlikely, equallyLikely and equallyLikely)
        assertEquals(Chance(0.1875), likely and unlikely)
        assertEquals(likely and unlikely, unlikely and likely)
        assertEquals(impossible, likely and impossible)
        assertEquals(likely, certain and likely)
    }

    @Test internal fun `invalid fractions`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { Chance(-0.01) }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { Chance(1.01) }
    }
}