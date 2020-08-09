package com.service

import com.obj.Order
import java.util.*

class EmailService : Observer {
    override fun update(o: Observable?, arg: Any?) {
        when (o) {
            is OrdersService -> {
                if (arg is Order) {
                    println("expected delivery is ${arg.dateOfDelivery}, your order total is $${arg.total}")
                } else {
                    println(arg)
                }
            }
            else -> println(o?.javaClass.toString())
        }
    }
}