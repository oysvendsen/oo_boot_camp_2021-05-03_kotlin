/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understands its neighbors
class Node {
    companion object {
        private const val UNREACHABLE = Double.POSITIVE_INFINITY
    }
    private val links = mutableListOf<Link>()

    infix fun canReach(destination: Node) = this.hopCount(destination, noVisitedNodes) != UNREACHABLE

    infix fun hopCount(destination: Node) = this.hopCount(destination, noVisitedNodes).also {
        require (it != UNREACHABLE) { "Destination is not reachable" }
    }.toInt()

    internal fun hopCount(destination: Node, visitedNodes: List<Node>): Double {
        if (this == destination) return 0.0
        if (this in visitedNodes) return UNREACHABLE
        var champion = UNREACHABLE
        for (link in links) {
            val challenger = link.hopCount(destination, visitedNodes + this)
            if (challenger < champion) champion = challenger
        }
        return champion
    }

    private val noVisitedNodes = emptyList<Node>()

    infix fun cost(amount: Number) = LinkBuilder(amount.toDouble(), links)

    class LinkBuilder internal constructor(private val cost: Double, private val links: MutableList<Link>) {
        infix fun to(neighbor: Node) = neighbor.also {
            links.add(Link(neighbor, cost))
        }
    }
}