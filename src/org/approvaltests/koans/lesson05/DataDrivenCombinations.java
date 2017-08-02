package org.approvaltests.koans.lesson05;

import org.approvaltests.combinations.CombinationApprovals;
import org.approvaltests.koans.helpers.Koans;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
    public void oneDimensionalInputIsTheSameAsArray() throws Exception {
        String[] beatles = {"John", ___, "Paul", "George", "Ringo"};
        CombinationApprovals.verifyAllCombinations(a -> a, beatles);
    }

    @Test
    public void twoDimensionalInputGoesByTheSquare() throws Exception {
        Integer[] small = {1, 2, 3};
        Integer[] big = {11, ____, 55};

        CombinationApprovals.verifyAllCombinations((a, b) -> a * b, small, big);
    }

    @Test
    public void ExceptionsAreOk() throws Exception {
        Integer[] numerator = {60, 126, 42};
        Integer[] denominator1 = {3, 2};
        Integer[] denominator2 = {-1, ____, 1};

        CombinationApprovals.verifyAllCombinations((a, b, c) -> a / (b + c), numerator, denominator1, denominator2);
    }

    @Test
    public void WorkingWithALambda() throws Exception {
        Calendar cal = Calendar.getInstance();
        cal.set(2000, 0, 1, 0, 0, 0);
        Date newMillenium = cal.getTime();
//        Date newMillenium = new Date(2000, 1, 1, 0, 0, 0);
        String[] years = {"yy", "yyyy"};
        String[] months = {"M", "MMM", "MMMM"};
        String[] days = {"dd", "EEEE"};

        CombinationApprovals.verifyAllCombinations((y, m, d) ->
                new SimpleDateFormat(y + "/" + m + "/" + d).format(newMillenium), years, months, days);
    }
}

