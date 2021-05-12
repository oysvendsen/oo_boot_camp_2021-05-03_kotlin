/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understand a connection from one Node to another
internal class Link(private val target: Node, private val cost: Double) {

    internal fun hopCount(destination: Node, visitedNodes: List<Node>): Double {
        return target.hopCount(destination, visitedNodes) + 1
    }

    internal fun cost(destination: Node, visitedNodes: List<Node>): Double {
        return target.cost(destination, visitedNodes) + cost
    }
}