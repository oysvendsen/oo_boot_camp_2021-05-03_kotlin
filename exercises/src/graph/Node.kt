/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understands its neighbors
class Node {
    private val neighbors = mutableListOf<Node>()

    infix fun canReach(destination: Node) = this.canReach(destination, noVisitedNodes)

    private fun canReach(destination: Node, visitedNodes: MutableList<Node>): Boolean {
        if (this == destination) return true
        if (this in visitedNodes) return false
        visitedNodes.add(this)
        return neighbors.any { neighbor -> neighbor.canReach(destination, visitedNodes) }
    }

    private val noVisitedNodes get() = mutableListOf<Node>()

    infix fun to(neighbor: Node) = neighbor.also { neighbors.add(neighbor) }
}