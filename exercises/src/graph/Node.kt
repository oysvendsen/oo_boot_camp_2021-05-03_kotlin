/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

import graph.Link.Companion.FEWEST_HOPS
import graph.Link.Companion.LEAST_COST

// Understands its neighbors
class Node {
    companion object {
        private const val UNREACHABLE = Double.POSITIVE_INFINITY
    }
    private val links = mutableListOf<Link>()

    infix fun canReach(destination: Node) = this.cost(destination, noVisitedNodes, FEWEST_HOPS) != UNREACHABLE

    infix fun hopCount(destination: Node) = this.cost(destination, FEWEST_HOPS).toInt()

    infix fun cost(destination: Node) = this.cost(destination, LEAST_COST)

    private fun cost(destination: Node, strategy: CostStrategy) = this.cost(destination, noVisitedNodes, strategy).also {
        require (it != UNREACHABLE) { "Destination is not reachable" }
    }

    internal fun cost(destination: Node, visitedNodes: List<Node>, strategy: CostStrategy): Double {
        if (this == destination) return 0.0
        if (this in visitedNodes) return UNREACHABLE
        return links.minOfOrNull { it.cost(destination, visitedNodes + this, strategy) } ?: UNREACHABLE
    }

    private val noVisitedNodes = emptyList<Node>()

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble(), links)

    class LinkBuilder internal constructor(private val cost: Double, private val links: MutableList<Link>) {
        infix fun to(neighbor: Node) = neighbor.also { links.add(Link(neighbor, cost)) }
    }
}