package io.coffeelessprogrammer.leetcode.topics.binarysearch;

/*
 * Problem: 35. Search Insert Position
 * Difficulty: Easy
 * Acceptance Rate: 42.3%
 * URL: https://leetcode.com/problems/search-insert-position/
 *
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search Insert Position.
 * Memory Usage: 42.1 MB, less than 83.84% of Java online submissions for Search Insert Position.
 *
 * Visual Explanation: https://www.instagram.com/p/CfpUjJ6OyMY/?igshid=YmMyMTA2M2Y=
 */
public class SearchInsertPosition {
    public int find(int[] nums, int target) {
        // Sanitize input
        if(target < nums[0]) return 0;
        if(target > nums[nums.length-1]) return nums.length;

        // Define window bounds
        int leftBound=0, rightBound = nums.length-1;

        int position = BinarySearch.middleIndexCeil(leftBound, rightBound), value;

        BinarySearch.displayWindowCenter(position, leftBound, rightBound);

        boolean isTargetGreater = false;

        while(leftBound <= rightBound) {
            position = BinarySearch.middleIndexCeil(leftBound, rightBound);
            value = nums[position];

            if(value == target) return position;
            else if(target < value) {
                if(nums[leftBound] == target) return leftBound;

                isTargetGreater = false;

                leftBound += 1;
                rightBound = position-1;
            } else {
                if(nums[rightBound] == target) return rightBound;

                isTargetGreater = true;

                rightBound -= 1;
                leftBound = position+1;
            }
        }

        return isTargetGreater ? position+1 : position;
    }

    //#region LeetcodeResearch

    public int searchInsertOptimal(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        int mid=(start+end)/2;

        while(start<=end) {
            mid=(start+end)/2;

            if(nums[mid]==target)
                return mid;
            else if(target>nums[mid])
                start=mid+1;
            else
                end=mid-1;
        }

        return target<nums[mid] ? mid : mid+1;
    }

    //#endRegion
}
