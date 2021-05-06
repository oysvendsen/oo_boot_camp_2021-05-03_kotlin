/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import quantity.Unit.Companion.chains
import quantity.Unit.Companion.cups
import quantity.Unit.Companion.fathoms
import quantity.Unit.Companion.feet
import quantity.Unit.Companion.furlongs
import quantity.Unit.Companion.gallons
import quantity.Unit.Companion.inches
import quantity.Unit.Companion.leagues
import quantity.Unit.Companion.miles
import quantity.Unit.Companion.ounces
import quantity.Unit.Companion.pints
import quantity.Unit.Companion.quarts
import quantity.Unit.Companion.tablespoons
import quantity.Unit.Companion.teaspoons
import quantity.Unit.Companion.yards

internal class QuantityTest {

    @Test fun `equality for like units`() {
        assertEquals(8.tablespoons, 8.tablespoons)
        assertNotEquals(8.tablespoons, 6.tablespoons)
        Assertions.assertNotEquals(8.tablespoons, Any())
        assertNotEquals(8.tablespoons, null)
    }

    @Test fun `equality for different units`() {
        assertEquals(8.tablespoons, 0.5.cups)
        assertEquals(768.teaspoons, 1.gallons)
        assertNotEquals(8.tablespoons, 8.cups)
        assertEquals(1.miles, (12 * 5280).inches)
        assertEquals(1.5.leagues, 36.furlongs)
        assertEquals(22.fathoms, 2.chains)
    }

    @Test fun `Quantity in hash set`() {
        assert(hashSetOf(8.tablespoons).contains(8.tablespoons))
        assert(hashSetOf(8.tablespoons).contains(0.5.cups))
        Assertions.assertEquals(1, hashSetOf(8.tablespoons, 8.tablespoons).size)
    }

    @Test fun hash() {
        assertEquals(8.tablespoons.hashCode(), 8.tablespoons.hashCode())
        assertEquals(8.tablespoons.hashCode(), 0.5.cups.hashCode())
    }

    @Test fun arithmetic() {
        assertEquals(0.5.quarts, +6.tablespoons + 13.ounces)
        assertEquals((-6).tablespoons, -6.tablespoons)
        assertEquals((-0.5).pints, 10.tablespoons - 13.ounces)
        assertEquals(-4.feet, 24.inches - 2.yards)
    }

    @Test fun `cross metric types`() {
        assertNotEquals(1.inches, 1.teaspoons)
        assertNotEquals(4.ounces, 2.feet)
    }

    @Test fun `incompatible units`() {
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { 3.yards - 4.tablespoons }
    }
}