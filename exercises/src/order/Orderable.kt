/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package order

interface Orderable<T> {
    fun isBetterThan(other: T): Boolean
}

fun <S: Orderable<S>> List<S>.bestOrNull(): S? {
    if (this.isEmpty()) return null
    return this.reduce { champion, challenger ->
        if (challenger.isBetterThan(champion)) challenger else champion
    }
}