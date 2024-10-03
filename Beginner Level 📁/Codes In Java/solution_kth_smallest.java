/*
similar to the Kth largest, but it uses a max-heap (by negating the elements) to find the Kth smallest element.
We use a max-heap (largest element at the top).
Add elements to the heap and, if the size exceeds k, remove the largest element.
The largest element left in the heap after processing all elements will be the Kth smallest.
*/
import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElement {
    // Method to find the Kth smallest element
    public static int findKthSmallest(int[] nums, int k) {
        // Max-heap to store k smallest elements (use Collections.reverseOrder() for max-heap)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        // Traverse through all elements in the array
        for (int num : nums) {
            // Add the current element to the max-heap
            maxHeap.add(num);
            
            // If the size of the heap exceeds k, remove the largest element
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        // The root of the max-heap is the Kth smallest element
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println("3rd smallest element is: " + findKthSmallest(nums, k));
    }
}
