/* This solution uses a min-heap (PriorityQueue in Java) to keep track of the k largest elements.
We use a min-heap (smallest element at the top).
Add elements to the heap and, if the size exceeds k, remove the smallest element.
The smallest element left in the heap after processing all elements will be the Kth largest.
 */
import java.util.PriorityQueue;

public class KthLargestElement {
    // Method to find the Kth largest element
    public static int findKthLargest(int[] nums, int k) {
        // Min-heap to store k largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Traverse through all elements in the array
        for (int num : nums) {
            // Add the current element to the min-heap
            minHeap.add(num);
            
            // If the size of the heap exceeds k, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // The root of the min-heap is the Kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        System.out.println("4th largest element is: " + findKthLargest(nums, k));
    }
}
