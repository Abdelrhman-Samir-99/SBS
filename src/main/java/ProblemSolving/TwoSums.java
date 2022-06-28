package ProblemSolving;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSums {
    /**
     *
     * Given a List of integers input and an integer target,
     * return Map of the two numbers such that they add up to target.
     * You may assume that each element would have exactly one solution,
     * and you may not use the same element twice.
     * You can return the answer in any order.
     *
     * Example 1:
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: <[2,7]>
     * Explanation: Because nums[0] + nums[1] == 9, we return <[2,7]>.
     *
     * Example 2:
     *
     * Input: nums = [3,2,4], target = 6
     * Output: <[2,4]>
     *
     * Example 3:
     *
     * Input: nums = [3,3], target = 6
     * Output: <[3,3]>
     *
     *
     * Constraints:
     *
     * 2 <= input.size() <= 104
     * -109 <= input.get(i) <= 109
     * -109 <= target <= 109
     * more than one valid answer can exists.
     *
     * */


    public Map<Integer, Integer> findAllTwoSums(List<Integer> input, Integer target) {
        Map<Integer, Integer> result = new HashMap<>();


        return new TwoSumsSolutions().constantSpaceWithSorting(input, target);
    }
}
