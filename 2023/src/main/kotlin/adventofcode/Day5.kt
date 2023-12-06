package adventofcode

import adventofcode.Utils.prep
import adventofcode.Utils.printResult
import adventofcode.Utils.readLines
import kotlin.time.ExperimentalTime

object Day5 {

    fun part1(data: Data): Long = longs(data).min()

    fun part2(data: Data): Long {
        val seedRanges = data.seeds.chunked(2)
            .map {
                val from = it.first()
                val to = from + it.last()
                listOf(from, to)
            }

        val locations = seedRanges.flatMap { seeds ->
            longs(data.copy(seeds = seeds))
        }

        return locations.min()
    }

    private fun longs(data: Data): List<Long> {
        val (seeds, seedToSoil, soilToFertilizer, fertilizerToWater, waterToLight, lightToTemperature, temperatureToHumidity, humidityToLocation) = data
        return seeds.map { seed ->
            val soil = seedToSoil.find(seed)
            val fertilizer = soilToFertilizer.find(soil)
            val water = fertilizerToWater.find(fertilizer)
            val light = waterToLight.find(water)
            val temperature = lightToTemperature.find(light)
            val humidity = temperatureToHumidity.find(temperature)
            humidityToLocation.find(humidity)
        }
    }

    fun parse(input: List<String>): Data {
        val seeds = input[0].split(":")[1].trim().split(" ").map { it.toLong() }

        val seedToSoilIndex = input.indexOf("seed-to-soil map:")
        val soilToFertilizerIndex = input.indexOf("soil-to-fertilizer map:")
        val fertilizerToWaterIndex = input.indexOf("fertilizer-to-water map:")
        val waterToLightIndex = input.indexOf("water-to-light map:")
        val lightToTemperatureIndex = input.indexOf("light-to-temperature map:")
        val temperatureToHumidityIndex = input.indexOf("temperature-to-humidity map:")
        val humidityToLocationIndex = input.indexOf("humidity-to-location map:")

        val seedToSoil = map(input, seedToSoilIndex, soilToFertilizerIndex)
        val soilToFertilizer = map(input, soilToFertilizerIndex, fertilizerToWaterIndex)
        val fertilizerToWater = map(input, fertilizerToWaterIndex, waterToLightIndex)
        val waterToLight = map(input, waterToLightIndex, lightToTemperatureIndex)
        val lightToTemperature = map(input, lightToTemperatureIndex, temperatureToHumidityIndex)
        val temperatureToHumidity = map(input, temperatureToHumidityIndex, humidityToLocationIndex)
        val humidityToLocation = map(input, humidityToLocationIndex, input.size)

        return Data(
            seeds,
            seedToSoil,
            soilToFertilizer,
            fertilizerToWater,
            waterToLight,
            lightToTemperature,
            temperatureToHumidity,
            humidityToLocation
        )
    }

    private fun map(input: List<String>, start: Int, end: Int): List<Interval> {
        return (start + 1 until end - 1)
            .fold(emptyList()) { acc, lineIndex ->
                val numbers = input[lineIndex].split(" ").map { it.toLong() }
                val destinationRangeStart = numbers.first()
                val sourceRangeStart = numbers[1]
                val rangeLength = numbers.last()
                acc + Interval(destinationRangeStart, sourceRangeStart, rangeLength)
            }
    }

    data class Interval(val destinationRangeStart: Long, val sourceRangeStart: Long, val rangeLength: Long)

    private fun List<Interval>.find(num: Long): Long {
        val match = this.firstOrNull() { range ->
            range.sourceRangeStart <= num &&
                range.sourceRangeStart + range.rangeLength >= num
        }
        return if (match != null) {
            val offset = num - match.sourceRangeStart
            match.destinationRangeStart + offset
        } else num
    }

    data class Data(
        val seeds: Iterable<Long>,
        val seedToSoil: List<Interval>,
        val soilToFertilizer: List<Interval>,
        val fertilizerToWater: List<Interval>,
        val waterToLight: List<Interval>,
        val lightToTemperature: List<Interval>,
        val temperatureToHumidity: List<Interval>,
        val humidityToLocation: List<Interval>,
    )

    @JvmStatic
    @OptIn(ExperimentalTime::class)
    fun main(args: Array<String>) {
        val input = prep("reading") { readLines("day5.txt") }
        val parse = prep("parsing") { parse(input) }
        printResult("part 1") { part1(parse) }
        printResult("part 2") { part2(parse) }
    }
}


