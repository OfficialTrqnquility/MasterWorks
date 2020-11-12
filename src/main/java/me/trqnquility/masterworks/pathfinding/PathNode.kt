package me.trqnquility.masterworks.pathfinding

class PathNode constructor(val x: Int, val y: Int, var closed: Boolean) {

    //G score plus H score how far we are frm the n node
    var fCost: Double = 0.0
    //How far we are to the end
    var hCost: Double = 0.0
    //shortest distance from node A to the end
    var gCost: Double = 0.0

    var previousNode: PathNode? = null

    fun calculateFCost() {
        fCost = gCost + hCost;
    }

    override fun toString(): String {
        return "x=${x} y=${y}";
    }

}