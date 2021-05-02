package unit

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import rectangle.Rectangle

private class RectangleTest {
    @Test
    fun area() {
        assertEquals(24.0, Rectangle(4, 6).area);
    }
}