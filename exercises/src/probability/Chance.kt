/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package probability

// Understands the likelihood of something occurring
class Chance(likelihoodAsFraction: Number) {
    companion object {
        private const val CERTAIN_FRACTION = 1.0
    }
    private val fraction = likelihoodAsFraction.toDouble()

    override fun equals(other: Any?) =
        this === other || other is Chance && this.equals(other)

    private fun equals(other: Chance) = this.fraction == other.fraction

    operator fun not() = Chance(CERTAIN_FRACTION - fraction)
}