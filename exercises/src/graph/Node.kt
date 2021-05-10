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

    infix fun canReach(destination: Node) = this.canReach(destination, noVisitedNodes)

    private fun canReach(destination: Node, visitedNodes: MutableList<Node>): Boolean {
        if (this == destination) return true
        if (this in visitedNodes) return false
        visitedNodes.add(this)
        return neighbors.any { neighbor -> neighbor.canReach(destination, visitedNodes) }
    }

    infix fun hopCount(destination: Node) = this.hopCount(destination, noVisitedNodes).also {
        require (it != UNREACHABLE) { "Destination is not reachable" }
    }

    private fun hopCount(destination: Node, visitedNodes: MutableList<Node>): Int {
        if (this == destination) return 0
        if (this in visitedNodes) return UNREACHABLE
        visitedNodes.add(this)
        for (neighbor in neighbors) neighbor.hopCount(destination, visitedNodes).also {
            if (it != UNREACHABLE) return it + 1
        }
        return UNREACHABLE
    }

    private val noVisitedNodes get() = mutableListOf<Node>()

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(neighbor) }
}