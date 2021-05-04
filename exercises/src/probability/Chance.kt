/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package probability

import kotlin.math.absoluteValue
import kotlin.math.roundToLong

// Understands the likelihood of something occurring
class Chance(likelihoodAsFraction: Number) {
    companion object {
        private const val CERTAIN_FRACTION = 1.0
        private const val DELTA = 1e-10
    }
    private val fraction = likelihoodAsFraction.toDouble()

    override fun equals(other: Any?) =
        this === other || other is Chance && this.equals(other)

    private fun equals(other: Chance) = (this.fraction - other.fraction).absoluteValue < DELTA

    override fun hashCode() = (fraction / DELTA).roundToLong().hashCode()

    operator fun not() = Chance(CERTAIN_FRACTION - fraction)

    infix fun and(other: Chance) = Chance(this.fraction * other.fraction)
}