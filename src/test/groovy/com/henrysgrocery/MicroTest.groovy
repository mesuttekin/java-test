package com.henrysgrocery

import com.henrysgrocery.cart.ShoppingCart
import spock.lang.Specification

import java.time.LocalDate

import static com.henrysgrocery.item.Item.*

class MicroTest extends Specification {

    ShoppingCart shoppingCart

    def setup() {
        shoppingCart = new ShoppingCart(LocalDate.now())
    }

    def "3 tins of soup and 2 loaves of bread, bought today"() {

        given:
        shoppingCart.addCart(SOUP, 3)
        shoppingCart.addCart(BREAD, 2)

        when:
        BigDecimal totalValue = shoppingCart.getTotal()

        then:
        totalValue == BigDecimal.valueOf(3.15)

    }

    def "6 apples and a bottle of milk, bought today"() {

        given:
        shoppingCart.addCart(APPLE, 6)
        shoppingCart.addCart(MILK, 1)

        when:
        BigDecimal totalValue = shoppingCart.getTotal()

        then:
        totalValue == BigDecimal.valueOf(1.90)
    }

    def "6 apples and a bottle of milk, bought in 5 days time"() {



        given:
        shoppingCart = new ShoppingCart(LocalDate.now().plusDays(5))
        shoppingCart.addCart(APPLE, 6)
        shoppingCart.addCart(MILK, 1)

        when:
        BigDecimal totalValue = shoppingCart.getTotal()

        then:
        totalValue == BigDecimal.valueOf(1.84)
    }

    def "3 apples, 2 tins of soup and a loaf of bread, bought in 5 days time"() {

        given:
        shoppingCart = new ShoppingCart(LocalDate.now().plusDays(5))
        shoppingCart.addCart(APPLE, 3)
        shoppingCart.addCart(SOUP, 2)
        shoppingCart.addCart(BREAD, 1)

        when:
        BigDecimal totalValue = shoppingCart.getTotal()

        then:
        totalValue == BigDecimal.valueOf(1.97)
    }


}
