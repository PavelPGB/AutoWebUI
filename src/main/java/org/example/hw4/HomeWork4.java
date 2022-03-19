package org.example.hw4;

/** AutoWebUI. HomeWork-4
 * Calculating the area of a triangle using Heron's formula.
 * @author Pavel Pulyk
 * @version 0.1 19.03.2022
 */

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class HomeWork4 {
     private int a;
     private int b;
     private int c;

    private void checkSidesArePositive(){
        if (a <= 0 || b <= 0 || c <= 0){
            throw new IllegalArgumentException("Sides must be positive.");
        }
    }

    private void checkOneSidesIsSmallerThanSumOfOthers(){
        if (a + b <= c || b + c <= a || c + a <= b){
            throw new IllegalArgumentException("One side can't be greater than sum of others.");
        }
    }

    public double countArea() {
        checkSidesArePositive();
        checkOneSidesIsSmallerThanSumOfOthers();
        double p = (a + b + c) / 2.0;
        return Math.sqrt(p * (p - a) * (p -b) * (p - c));
    }
}
