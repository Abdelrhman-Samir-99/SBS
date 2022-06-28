package ProblemSolving;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumsTest {
    final Integer target = 10;
    final List<Integer> input = new ArrayList<>(Arrays.asList(3, 5, -4, 8, 11, 1, -1, 6));
    final Map<Integer, Integer> result = new HashMap<>(Stream.of(new Integer[][]{{11, -1}}).collect(
            Collectors.toMap(row -> row[0], row -> row[1])));

    private TwoSums twoSums = new TwoSums();

    @Test
    public void testTwoSums() {
        Map<Integer, Integer> testResult = twoSums.findAllTwoSums(input, target);
        Iterator<Map.Entry<Integer, Integer>> testResultIterator = testResult.entrySet().iterator();
        Iterator<Map.Entry<Integer, Integer>> resultIterator = result.entrySet().iterator();
        while (testResultIterator.hasNext() && resultIterator.hasNext()) {
            mapAssertion.accept(testResultIterator.next(), resultIterator.next());
        }
    }

    BiConsumer<Map.Entry<Integer, Integer>, Map.Entry<Integer, Integer>> mapAssertion = (firstEntry, secondEntry) -> {
        assertTrue(firstEntry.getValue().equals(secondEntry.getValue()) ||
                firstEntry.getValue().equals(secondEntry.getKey()));
        assertTrue(firstEntry.getKey().equals(secondEntry.getValue()) ||
                firstEntry.getKey().equals(secondEntry.getKey()));
    };
}