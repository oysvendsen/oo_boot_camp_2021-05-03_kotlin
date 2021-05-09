/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package quantity

import order.Orderable
import quantity.Unit.Companion.EPSILON
import kotlin.math.absoluteValue

// Understands a specific measurement
open class IntervalQuantity internal constructor(amount: Number, internal val unit: Unit) : Orderable<IntervalQuantity> {
    internal val amount = amount.toDouble()

    override fun equals(other: Any?) = this === other || other is IntervalQuantity && this.equals(other)

    private fun equals(other: IntervalQuantity) = this.isCompatible(other) &&
            (this.amount - convertedAmount(other)).absoluteValue < EPSILON

    private fun isCompatible(other: IntervalQuantity) = this.unit.isCompatible(other.unit)

    internal fun convertedAmount(other: IntervalQuantity) = this.unit.convertedAmount(other.amount, other.unit)

    override fun hashCode() = unit.hashCode(amount)

    override fun isBetterThan(other: IntervalQuantity) = this.amount > convertedAmount(other)
}