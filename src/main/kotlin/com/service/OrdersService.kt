package com.service

import java.util.*

class OrdersService {
    fun main(args: Array<String>) {
        print("Enter your order: ")
        val input = readLine()
        println(input)
        val orderItems: List<String> = input!!.split(",").map { it -> it.trim() }
        println(orderItems)

        val priceHashMap = getPrices()
        var total = findTotal(orderItems, priceHashMap)

        println("total: $$total")
    }

    fun findTotal(orderItems: List<String>, priceHashMap: HashMap<String, Double>): Double {
        var total = 0.0
        for (item in orderItems) {
            total += priceHashMap.get(item.trim().toLowerCase())!!
        }
        return total
    }

    fun getPrices(): HashMap<String, Double> {
        val priceHashMap: HashMap<String, Double> = HashMap<String, Double>()
        priceHashMap.put("orange", 0.25)
        priceHashMap.put("apple", 0.60)
        return priceHashMap
    }
}
