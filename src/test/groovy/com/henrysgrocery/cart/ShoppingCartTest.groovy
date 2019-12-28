package com.henrysgrocery.cart

import spock.lang.Specification


class ShoppingCartTest extends Specification {


    def "getItems - should not throw any exception and return empty map"() {

        given:
        ShoppingCart shoppingCart = new ShoppingCart()

        when:
        Map<String, Integer> items = shoppingCart.getItems()

        then: "should not throw an exception and return empty map"
        true
        items.size() == 0

    }


}
