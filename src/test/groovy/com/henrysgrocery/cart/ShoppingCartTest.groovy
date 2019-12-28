package com.henrysgrocery.cart

import com.henrysgrocery.item.ItemType
import spock.lang.Specification

import static com.henrysgrocery.item.ItemType.APPLE
import static com.henrysgrocery.item.ItemType.BREAD
import static com.henrysgrocery.item.ItemType.MILK
import static com.henrysgrocery.item.ItemType.SOAP


class ShoppingCartTest extends Specification {

    ShoppingCart shoppingCart

    def setup() {
        shoppingCart = new ShoppingCart()
    }

    def "getItems - should not throw any exception and return empty map"() {

        given:
        shoppingCart = new ShoppingCart()

        when:
        Map<String, Integer> items = shoppingCart.getItems()

        then: "should not throw an exception and return empty map"
        true
        items.size() == 0

    }

    def "addItem - should add a new item in cart and get added item"() {

        given:
        ItemType item = MILK

        when:
        shoppingCart.addCart(item)

        then: "should not throw an exception and get the item"
        true
        def items = shoppingCart.getItems()
        items.containsKey(item)
    }

    def "addItem - should add an existing item in cart and increase quantity of it "() {

        given:
        ItemType item = MILK
        shoppingCart.addCart(item)

        when:
        shoppingCart.addCart(item)

        then: "should get added items"
        def items = shoppingCart.getItems()
        items.containsKey(item)
        items.get(item) == 2
    }

    def "addItem - should add different items"() {

        given:
        shoppingCart.addCart(MILK)

        when:
        shoppingCart.addCart(BREAD)
        shoppingCart.addCart(SOAP)
        shoppingCart.addCart(APPLE)

        then: "should get added items"
        def items = shoppingCart.getItems()
        items.containsKey(MILK)
        items.containsKey(BREAD)
        items.containsKey(SOAP)
        items.containsKey(APPLE)
    }


}
