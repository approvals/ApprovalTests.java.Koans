package org.approvaltests.koans.lesson05;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.koans.helpers.Koans;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * How to do Koans:
 * Step 1: Press the Run Button (Place cursor on the Method name to run a single method)
 * PC: Ctrl+F11
 * Mac: Command+fn+F11
 * Step 2: Read the name of the Method that Failed
 * Step 3: Fill in the blank (___) to make it pass
 * Step 4: Repeat Until Enlightenment
 * Do not change anything except the blank (___)
 */

public class DataDrivenCombinations extends Koans {

    @Test
    public void oneDimensionalInputIsTheSameAsArray() {
        String[] beatles = {"John", ___, "Paul", "George", "Ringo"};
        CombinationApprovals.verifyAllCombinations(a -> a, beatles);
    }

    @Test
    public void twoDimensionalInputGoesByTheSquare() {
        Integer[] small = {1, 2, 3};
        Integer[] big = {11, ____, 55};

        CombinationApprovals.verifyAllCombinations((a, b) -> a * b, small, big);
    }

    @Test
    public void exceptionsAreOk() {
        Integer[] numerator = {60, 126, 42};
        Integer[] denominator1 = {3, 2};
        Integer[] denominator2 = {-1, ____, 1};

        CombinationApprovals.verifyAllCombinations((a, b, c) -> a / (b + c), numerator, denominator1, denominator2);
    }

    @Test
    public void workingWithALambda() {
        LocalDateTime newMillennium = LocalDateTime.of(2000, Month.JANUARY, 1, 0, 0, 0);
        String[] years = {"yy", "yyyy"};
        String[] months = {"M", ___, "MMMM"};
        String[] days = {"dd", "EEEE"};

        CombinationApprovals.verifyAllCombinations((y, m, d) ->
                newMillennium.format(DateTimeFormatter.ofPattern(y + "/" + m + "/" + d)), years, months, days);
    }
}

