package com.tensquare.article;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test
 *
 * @Author : eden 2020-12-02 14:16
 */
public class AnyTest {

    @Test
    public void test() {
        List<String> list1 = new ArrayList<>();
        list1.add("abc1");
        list1.add("abc2");
        list1.add("abc3");
        list1.add("abc4");
        list1.add("abc5");
        System.out.println(list1.contains("abc3"));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int left = 0, right = nums1.length;
        int nums1Mid = 0, nums2Mid = 0;
        int totalMid = (nums1.length + nums2.length + 1) / 2;

        while (left <= right) {
            // nums1: ……………… nums1[nums1Mid-1] | nums1[nums1Mid] ……………………
            // nums2: ……………… nums2[nums2Mid-1] | nums2[nums2Mid] ……………………
            nums1Mid = left + (right - left) / 2;
            nums2Mid = totalMid - nums1Mid;
            // 这里要对nums1Mid进行大于0的判断，因为有可能出现nums1是空数组，或者nums1的数组元素全部比nums2大的情况
            if (nums1Mid > 0 && nums1[nums1Mid - 1] > nums2[nums2Mid]) {
                // 切分线左边比右边大的情况，需要左移，即对左边进行二分搜索
                right = nums1Mid - 1;
            } else if (nums1Mid < nums1.length && nums1[nums1Mid] < nums2[nums2Mid - 1]) {
                // 切分线右边比左边小的情况，需要右移，即对右边进行二分搜索
                left = nums1Mid + 1;
            } else {
                break;
            }
        }

        int midLeftNum, midRightNum;
        // 对两个数组的切分位置进行判断，以获得切分线左边的数字。
        if (nums1Mid == 0) {
            midLeftNum = nums2[nums2Mid - 1];
        } else if (nums2Mid == 0) {
            midLeftNum = nums1[nums1Mid - 1];
        } else {
            midLeftNum = Math.max(nums1[nums1Mid - 1], nums2[nums2Mid - 1]);
        }
        // 如果合并数组的长度是奇数，则中位数为切分线左边的数字。因为二分搜索找到的结果是偏右一位。
        if ((nums1.length + nums2.length) % 2 == 1) {
            return midLeftNum;
        }

        if (nums1Mid == nums1.length) {
            midRightNum = nums2[nums2Mid];
        } else if (nums2Mid == nums2.length) {
            midRightNum = nums1[nums1Mid];
        } else {
            midRightNum = Math.min(nums1[nums1Mid], nums2[nums2Mid]);
        }

        return (midLeftNum + midRightNum) / 2.0;
    }

}
