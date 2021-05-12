/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understand a connection from one Node to another
internal class Link internal constructor(private val target: Node, private val cost: Double) {
    companion object {
        internal val LEAST_COST = { cost: Double -> cost }
        internal val FEWEST_HOPS = { _: Double -> 1.0 }
    }

    internal fun cost(destination: Node, visitedNodes: List<Node>, strategy: CostStrategy): Double {
        return target.cost(destination, visitedNodes, strategy) + strategy(cost)
    }
}

internal typealias CostStrategy = (Double) -> Double