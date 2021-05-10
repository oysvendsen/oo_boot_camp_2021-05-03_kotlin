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
            b to a
            b to c to d to e to b to f
            c to d
            c to e
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
}