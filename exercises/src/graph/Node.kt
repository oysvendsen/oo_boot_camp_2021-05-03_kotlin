/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understands its neighbors
class Node {
    companion object {
        private const val UNREACHABLE = -1
    }
    private val neighbors = mutableListOf<Node>()

    infix fun canReach(destination: Node) = this.hopCount(destination, noVisitedNodes) != UNREACHABLE

    infix fun hopCount(destination: Node) = this.hopCount(destination, noVisitedNodes).also {
        require (it != UNREACHABLE) { "Destination is not reachable" }
    }

    private fun hopCount(destination: Node, visitedNodes: MutableList<Node>): Int {
        if (this == destination) return 0
        if (this in visitedNodes) return UNREACHABLE
        visitedNodes.add(this)
        var champion = UNREACHABLE
        for (neighbor in neighbors) {
            val challenger = neighbor.hopCount(destination, visitedNodes)
            if (challenger == UNREACHABLE) continue
            if (champion == UNREACHABLE || challenger + 1 < champion) champion = challenger + 1
        }
        return champion
    }

    private val noVisitedNodes get() = mutableListOf<Node>()

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(neighbor) }
}