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
    fun testFindTotal() {
        val expectedTotal = 0.85
        val total = os.findTotal(listOf("apple", "orange"), os.getPrices())
        assertEquals(expectedTotal, total, 0.0)
    }
}