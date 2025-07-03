## Quick revision of Concepts applied

**[Problem-1 Valid Palindrome](ValidPalindrome.java)**

- Use two pointers. No equality is needed.
- Equality works with characters and integers.

**[Problem-2 Two Sum](TwoSumPartTwo.java)**

- Check if the array is sorted.
- If sorted array is there then it can be solved using Two Pointers.
- Check for the conditions `arr[i]+arr[j]` greater than or less than the target.

**[Problem-3 Three Sum](ThreeSum.java)**

- Optimal solution is of time complexity O(n^2). 
- Can be done by applying Two pointers on each index.

**[Problem-4 Container with most water](ContainerWithMostWater.java)**

- Move the pointers depending on the height of each bar.
- Think about calculating area in each step.
- Even if two bars are equal in height don't worry to move which index, move any one index and you are good.

**[Problem-5 Trapping of Rain Water](TrappingRainWater.java)**

- Before you start this problem you need to come up with the volume of water stored on each step.
  - Volume of water can be given by this formula.
  > min(Max Height on the left, Max Height on the right) - height of the step

- This problem has two optimal approaches

  - *Solution-1* : **O(n) Space Complexity**
    - Take two arrays as `MaxLeftArr` and `MaxRightArr`.
    - MaxLeftArr will store the max height of the blocks going from Left to Right.
    - MaxRightArr will store the max heigh of the blocks going from Right to Left.
    - For each step calculate area of water trapped using the formula discussed in Step-1. 
    - Add it all.
  - *Solution-2* : **O(1) Space Complexity**
    - Take two pointers `left` and `right` pointing to left and right side of the indexes respectively. 
    - Compare `height[left]` and `height[right]` because we will need to move the pointer whose value is less.
    - After comparing update the maxLeft or maxRight first, then apply the above formula and then move the pointer.
