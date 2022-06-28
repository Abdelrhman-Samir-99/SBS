package ProblemSolving;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSumsSolutions {
    /*
        Returns all pairs with sum equal to target, by trying every possible pair.
        Time Complexity O(N^2) Where N is the number of items in the input list.
        Space Complexity O(1).

        @param input: List of items to search in.
        @param target: the value we will look for.
        @return results: map of pairs with sum equal to target.
    */
    public Map<Integer, Integer> constantSpaceNoSorting(List<Integer> input, Integer target) {
        Map<Integer, Integer> results = new HashMap<>();
        int size = input.size();

        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j) {
                if (i == j) {
                    continue; // Since we can't consider the same item twice.
                }

                Integer first = input.get(i);
                Integer second = input.get(j);
                if (first + second == target) {
                    results.put(first, second);
                }
            }
        }
        return results;
    }

    /*
        Returns all pairs with sum equal to target, by using a hash map as a cache.
        Time Complexity O(N^2) Where N is the number of items in the input list, and that happens when there is a collision.
        But the average case is Θ(N) for time complexity.
        Space Complexity O(N).

        @param input: List of items to search in.
        @param target: the value we will look for.
        @return results: map of pairs with sum equal to target.
    */
    public Map<Integer, Integer> usingHashMap(List<Integer> input, Integer target) {
        Map<Integer, Integer> results = new HashMap<>();
        Map<Integer, Integer> cache = new HashMap<>();
        int size = input.size();

        for (int i = 0; i < size; ++i) {
            Integer currentNumber = input.get(i);
            Integer need = target - currentNumber;
            if (cache.containsKey(need) == true) {
                results.put(currentNumber, need);
            }
            cache.put(currentNumber, 1);
        }

        return results;
    }

    /*
        Returns all pairs with sum equal to target, by sorting the input then applying two pointers technique.
        Time Complexity O(N log(N)) Where N is the number of items in the input list.
        Space Complexity O(1).

        @param input: List of items to search in.
        @param target: the value we will look for.
        @return results: map of pairs with sum equal to target.
    */
    public Map<Integer, Integer> constantSpaceWithSorting(List<Integer> input, Integer target) {
        Map<Integer, Integer> results = new HashMap<>();
        input.sort(Comparator.naturalOrder());

        int start = 0, end = input.size() - 1;

        while(start < end) {
            int sum = input.get(start) + input.get(end);

            if(sum == target) {
                results.put(input.get(start), input.get(end));
            }

            if(sum >= target) {
                --end;
            }
            else {
                ++start;
            }
        }
        return results;
    }

}