/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package unit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import rectangle.Rectangle

private class RectangleTest {
    @Test fun area() {
        assertEquals(24.0, Rectangle(4, 6).area);
    }
}