package org.example.hw4;

/** AutoWebUI. HomeWork-4
 * Tests
 * @author Pavel Pulyk
 * @version 0.1 19.03.2022
 */

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Disabled("Перенесены в параметризованные тесты")
class HomeWork4Test {

    @Test
    @DisplayName("Площадь треугольника 2, 2, 3 должена быть равен  1.984313483298443")
    public void countAreaTriangleSuccessfulTest() {
        HomeWork4 homeWork4 = new HomeWork4(2, 2, 3);
        double area1 = homeWork4.countArea();
        assertEquals(1.984313483298443, area1);
    }

    @Test
    @DisplayName("Площадь египетского треугольника 3, 4, 5 должена быть равна 6")
    public void countAreaEgyptTriangleSuccessfulTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, 4, 5);
        double area1 = homeWork4.countArea();
        assertEquals(6, area1);
    }

    @Test
    @DisplayName("Площадь  треугольника 3, 3, 3 должена быть равна 3.897114317029974")
    public void countAreaWithEqualSidesTriangleSuccessfulTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, 3, 3);
        double area1 = homeWork4.countArea();
        assertEquals(3.897114317029974, area1);
    }

    @Test
    public void countArea1SideIsZeroFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(0, 4, 5);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("Sides must be positive.", illegalArgumentException1.getMessage());
    }

    @Test
    public void countArea2SideIsZeroFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, 0, 5);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("Sides must be positive.", illegalArgumentException1.getMessage());
    }

    @Test
    public void countArea3SideIsZeroFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, 4, 0);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("Sides must be positive.", illegalArgumentException1.getMessage());
    }

    @Test
    public void countArea1SideIsNegativeFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(-3, 4, 5);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("Sides must be positive.", illegalArgumentException1.getMessage());
    }

    @Test
    public void countArea2SideIsNegativeFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, -4, 5);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("Sides must be positive.", illegalArgumentException1.getMessage());
    }

    @Test
    public void countArea3SideIsNegativeFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, 4, -5);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("Sides must be positive.", illegalArgumentException1.getMessage());
    }

    @Test
    public void countAreaInvalidTriangleFailedTest() {
        HomeWork4 homeWork4 = new HomeWork4(3, 4, 8);
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals("One side can't be greater than sum of others.", illegalArgumentException1.getMessage());
    }
}