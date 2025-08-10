public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;
        if(A.length > B.length)
        {
            int[] temp = A;
            A = B;
            B = temp;
        }
        int totalLength = A.length + B.length;
        int partitionTotalLength = (int) totalLength / 2;
        int left = 0, right = A.length;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            int ALeftPartitionEndingIndex = mid-1;
            int BLeftPartitionEndingIndex = partitionTotalLength - mid - 1;
            int ARightPartitionStartingIndex = mid;
            int BRightPartitionStartingIndex = BLeftPartitionEndingIndex+1;

            int ALeft = ALeftPartitionEndingIndex >= 0 ? A[ALeftPartitionEndingIndex] : Integer.MIN_VALUE;
            int BLeft = BLeftPartitionEndingIndex >= 0 ? B[BLeftPartitionEndingIndex] : Integer.MIN_VALUE;
            int ARight = ARightPartitionStartingIndex < A.length ? A[ARightPartitionStartingIndex] : Integer.MAX_VALUE;
            int BRight = BRightPartitionStartingIndex < B.length ? B[BRightPartitionStartingIndex] : Integer.MAX_VALUE;

            if(ALeft <= BRight && BLeft <= ARight)
            {
                // odd length
                if(totalLength%2 == 1)
                {
                    return Math.max(ALeft, BLeft);
                }
                else {
                    return (double)(Math.max(ALeft,BLeft) + Math.min(ARight,BRight))/2;
                }
            }
            else if(ALeft > BRight)
            {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return (double) -1;
    }
}
