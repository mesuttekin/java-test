package com.henrysgrocery.util;

import java.time.LocalDate;

public class DateValidation {

    public static boolean isDiscountValid(LocalDate validateFrom, LocalDate validateTo, LocalDate purchaseDate) {

        return (purchaseDate.isAfter(validateFrom) || purchaseDate.isEqual(validateFrom)) &&
                (purchaseDate.isBefore(validateTo) || purchaseDate.isEqual(validateTo));
    }
}
