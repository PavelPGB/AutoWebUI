package org.example.hw4;

/** AutoWebUI. HomeWork-4
 * Parameterized
 * @author Pavel Pulyk
 * @version 0.1 19.03.2022
 */

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HomeWork4Parameterized {

    public static Stream<Arguments> homeWord4() {
        return Stream.of(Arguments.of(new HomeWork4(2, 2, 3), 1.984313483298443),
                Arguments.of(new HomeWork4(3, 4, 5), 6),
                Arguments.of(new HomeWork4(3, 3, 3), 3.897114317029974)
        );
    }

    @ParameterizedTest(name = "Площадь треугольника: позитивный сценарий, площадь треугольника {0} == {1})")
    @MethodSource("homeWord4")
    void countAreaPositiveTest(HomeWork4 homeWork4, double expectedResult) {
        double area1 = homeWork4.countArea();
        assertEquals(expectedResult, area1);
    }

    public static Stream<Arguments> negativeHomeWork4(){
        return Stream.of(Arguments.of(new HomeWork4(0,4, 5), "Sides must be positive."),
                Arguments.of(new HomeWork4(3,0,5), "Sides must be positive."),
                Arguments.of(new HomeWork4(3,4,0), "Sides must be positive."),
                Arguments.of(new HomeWork4(-3,4, 5), "Sides must be positive."),
                Arguments.of(new HomeWork4(3,-4,5), "Sides must be positive."),
                Arguments.of(new HomeWork4(3,4,-5), "Sides must be positive."),
                Arguments.of(new HomeWork4(3,4,8), "One side can't be greater than sum of others.")
        );
    }

    @ParameterizedTest(name = "Площадь треугольника: негативный сценарий (треугольник {0}, ошибка:{1})")
    @MethodSource("negativeHomeWork4")
    public void countAreaNegativeTest(HomeWork4 homeWork4, String errorText) {
        IllegalArgumentException illegalArgumentException1 = assertThrows(IllegalArgumentException.class, homeWork4::countArea);
        assertEquals(errorText, illegalArgumentException1.getMessage());
    }
}
