package com.henrysgrocery;

import com.henrysgrocery.cart.ShoppingCart;

import java.time.LocalDate;
import java.util.Scanner;

import static com.henrysgrocery.item.Item.*;

public class GroceryApplication {


    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        //please change purchaseDate in order to test date validation
        LocalDate purchaseDate = LocalDate.now().plusDays(3);

        ShoppingCart shoppingCart = new ShoppingCart(purchaseDate);

        boolean isQuit = false;

        do {

            System.out.print("Please enter the first character of the item you want to add: [S]oup, [B]read, [M]ilk, [A]pples or [Q]uit: ");

            String input = scanner.nextLine().toUpperCase();

            switch (input) {
                case "S":
                    System.out.print("You added: Soup\n");
                    shoppingCart.addCart(SOUP);
                    break;

                case "B":
                    System.out.print("You added: Bread\n");
                    shoppingCart.addCart(BREAD);
                    break;

                case "M":
                    System.out.print("You added: Milk\n");
                    shoppingCart.addCart(MILK);
                    break;

                case "A":
                    System.out.print("You added: Apples\n");
                    shoppingCart.addCart(APPLE);
                    break;

                case "Q":
                    System.out.print("\n");
                    isQuit = true;
                    break;

                default:
                    System.out.print("Invalid character\n");
            }

            if (!isQuit)
                System.out.println(shoppingCart);
        } while (!isQuit);

    }
}
