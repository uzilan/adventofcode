package adventofcode

import kotlin.time.ExperimentalTime

object Day7 {
    fun part1(dirs: List<Dir>): Long = dirs
        .map { it.totalSize() }
        .filter { it <= 100000 }
        .sumOf { it }

    fun part2(dirs: List<Dir>): Long {
        val available = 70000000 - dirs.first { it.name == "/" }.totalSize()
        val needed = 30000000 - available
        return dirs
            .map { it.totalSize() }
            .filter { it >= needed }
            .minOf { it }
    }

    fun dirs(input: List<String>): MutableList<Dir> {
        val dirs = mutableListOf<Dir>()
        val root = Dir(name = "/", parent = null)
        dirs.add(root)
        var curr = root
        input.forEach { line ->
            when {
                line.startsWith("$ cd /") -> curr = root
                line.startsWith("$ cd ..") -> curr = curr.parent!!
                line.startsWith("$ cd") -> {
                    val name = line.split(" ")[2]
                    val dir = Dir(name, parent = curr)
                    dirs += dir
                    curr.subs += dir
                    curr = dir
                }

                line.first().isDigit() -> {
                    val size = line.split(" ").first().toLong()
                    curr.size += size
                }
            }
        }
        return dirs
    }

    data class Dir(
        val name: String,
        val parent: Dir?,
        var size: Long = 0,
        val subs: MutableList<Dir> = mutableListOf(),
    ) {
        override fun toString(): String {
            return "name: $name, parent: $parent, totalSize: ${totalSize()}"
        }

        fun totalSize(): Long = size + subs.sumOf { it.totalSize() }
    }

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = Utils.prep("reading") { Utils.readLines("day7.txt") }
        val dirs = Utils.prep("parsing") { dirs(input) }

        Utils.printResult("part 1") { part1(dirs) } // 1513699
        Utils.printResult("part 2") { part2(dirs) }
    }
}