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

    @Test fun equality() {
        assertEquals(Chance(0.75), Chance(0.75))
        assertNotEquals(Chance(0.75), Chance(0.25))
        assertNotEquals(Chance(0.75), Any())
        assertNotEquals(Chance(0.75), null)
    }
}