package exercise;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> numbers1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> result1 = App.take(numbers1, 2);
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2));
        assertEquals(expected1, result1);

        List<Integer> numbers2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> result2 = App.take(numbers2, 3);
        List<Integer> expected2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        assertEquals(expected2, result2);
        // END
    }
}
