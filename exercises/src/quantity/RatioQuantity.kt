/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package quantity

// Understands a specific measurement
open class RatioQuantity internal constructor(amount: Number, unit: Unit) :
        IntervalQuantity(amount, unit) {

    operator fun unaryPlus() = this

    operator fun unaryMinus() = RatioQuantity(-amount, unit)

    infix operator fun plus(other: RatioQuantity) = RatioQuantity(this.amount + convertedAmount(other), unit)

    infix operator fun minus(other: RatioQuantity) = this + -other
}