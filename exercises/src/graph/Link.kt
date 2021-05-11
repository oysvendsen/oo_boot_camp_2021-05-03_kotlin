/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understands a connection from one Node to another
class Link internal constructor(private val target: Node, private val cost: Double) {

    internal fun hopCount(destination: Node, visitedNodes: List<Node>) =
        target.hopCount(destination, visitedNodes) + 1

    internal fun cost(destination: Node, visitedNodes: List<Node>) =
        target.cost(destination, visitedNodes) + cost
}