/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import graph.Node
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// Ensures Graph algorithms work correctly
internal class GraphTest {
    companion object {
        private val a = Node()
        private val b = Node()
        private val c = Node()
        private val d = Node()
        private val e = Node()
        private val f = Node()
        private val g = Node()

        init {
            b cost 5 to a
            b cost 6 to c cost 7 to d cost 2 to e cost 3 to b cost 4 to f
            c cost 1 to d
            c cost 8 to e
        }
    }

    @Test internal fun `can reach`() {
        assertTrue(b canReach b)
        assertTrue(b canReach a)
        assertTrue(b canReach f)
        assertTrue(b canReach d)
        assertTrue(c canReach f)
        assertFalse(g canReach b)
        assertFalse(a canReach b)
        assertFalse(b canReach g)
    }

    @Test internal fun `hop count`() {
        assertEquals(0, b hopCount b)
        assertEquals(1, b hopCount a)
        assertEquals(1, b hopCount f)
        assertEquals(2, b hopCount d)
        assertEquals(3, c hopCount f)
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { g hopCount b }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { a hopCount b }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { b hopCount g }
    }

    @Test fun cost() {
        assertEquals(0.0, b cost b)
        assertEquals(5.0, b cost a)
        assertEquals(4.0, b cost f)
        assertEquals(7.0, b cost d)
        assertEquals(10.0, c cost f)
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { g cost b }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { a cost b }
        org.junit.jupiter.api.assertThrows<IllegalArgumentException> { b cost g }
    }
}