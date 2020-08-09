package com.service

import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.Before
import org.mockito.Mock


class OrdersServiceTest {

    @Mock
    lateinit var os: OrdersService

    @Before
    fun setUp() {
        os = OrdersService()
    }

    @Test
    fun testGetPrices() {
        val EXPECTED_APPLE_PRICE = 0.60
        val EXPECTED_ORANGE_PRICE = 0.25
        assertEquals(os.getPrices().get("apple"), EXPECTED_APPLE_PRICE)
        assertEquals(os.getPrices().get("orange"), EXPECTED_ORANGE_PRICE)
    }

    @Test
    fun testCreateCart() {
        val expectedApples = 1
        val expectedOranges = 1
        val cart = os.createCart(listOf("apple", "orange"))
        assertEquals(cart["apple"], expectedApples)
        assertEquals(cart["orange"], expectedOranges)
    }

    @Test
    fun testNForPriceOfMAdjustment() {
        val expectedResult = 5
        val result = os.nForPriceOfMAdjustment(7, 3, 2)
        assertEquals(expectedResult, result)
    }

    @Test
    fun testnFindTotal() {
        val expectedTotal = 1.70
        val total = os.findTotal(hashMapOf("apple" to 3, "orange" to 3), os.getPrices())
        assertEquals(expectedTotal, total, 0.0)
    }
}