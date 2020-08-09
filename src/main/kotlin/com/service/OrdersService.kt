package com.service

import kotlin.collections.HashMap

fun main(args: Array<String>) {
    print("Enter your order: ")
    val input = readLine()
    println(input)
    val orderItems: List<String> = input!!.split(",").map { it -> it.trim() }
    println(orderItems)
    val os: OrdersService = OrdersService()
    val cart = os.createCart(orderItems)
    val priceHashMap = os.getPrices()
    var total = os.findTotal(cart, priceHashMap)

    println("total: $$total")
}

class OrdersService {

    fun createCart(orderItems: List<String>): HashMap<String, Int> {
        val cart: HashMap<String, Int> = HashMap<String, Int>()
        for (item in orderItems) {
            val trimmedItem = item.trim().toLowerCase()
            var count = cart[trimmedItem]
            if (count == null) {
                count = 0
            }
            cart[trimmedItem] = count + 1
        }
        return cart
    }

    fun findTotal(cart: HashMap<String, Int>, priceHashMap: HashMap<String, Double>): Double {
        var total = 0.0
        for ((item, count) in cart) {
            var adjustedCount = 0
            if (item.equals("orange")) {
                // 3 for price of 2 logic, N for price of M
                val N = 3
                val M = 2
                adjustedCount = nForPriceOfMAdjustment(count, N, M)
            }

            if (item.equals("apple")) {
                // 3 for price of 2 logic, N for price of M
                val N = 2
                val M = 1
                adjustedCount = nForPriceOfMAdjustment(count, N, M)
            }

            if (priceHashMap.get(item) != null) {
                total += priceHashMap.get(item)!! * adjustedCount
            } else {
                println("ERROR: unknown item $item")
            }
        }
        return total
    }

    fun nForPriceOfMAdjustment(count: Int, N: Int, M: Int): Int {
        var adjustedCount: Int
        val quotient = count / N
        val remainder = count % N
        adjustedCount = quotient * M + remainder
        return adjustedCount
    }

    fun getPrices(): HashMap<String, Double> {
        val priceHashMap: HashMap<String, Double> = HashMap<String, Double>()
        priceHashMap.put("orange", 0.25)
        priceHashMap.put("apple", 0.60)
        return priceHashMap
    }
}
