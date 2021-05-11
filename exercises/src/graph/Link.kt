/*
 * Copyright (c) 2021 by Fred George
 * May be used freely except for training; license required for training.
 * @author Fred George  fredgeorge@acm.org
 */

package graph

// Understands a connection from one Node to another
class Link(private val target: Node) {

    internal fun hopCount(destination: Node, visitedNodes: List<Node>) =
        target.hopCount(destination, visitedNodes) + 1
}