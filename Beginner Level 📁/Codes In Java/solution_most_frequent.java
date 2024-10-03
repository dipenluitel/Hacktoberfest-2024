/* uses a hash map to count the frequencies of elements, and a min-heap to keep track of the k most frequent elements.
First, count the frequency of each element using a hash map.
Then, use a min-heap to track the top k most frequent elements.
If the heap size exceeds k, remove the element with the smallest frequency.
Finally, the elements left in the heap are the top k frequent ones.

*/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    // Method to find the top K most frequent elements
    public static int[] topKFrequent(int[] nums, int k) {
        // Hash map to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each element in the array
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        // Min-heap to store the top K frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = 
                new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        
        // Traverse through the frequency map
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            // Add the current entry (element and its frequency) to the min-heap
            minHeap.add(entry);
            
            // If the size of the heap exceeds k, remove the least frequent element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        // Extract the elements from the heap (these are the top K frequent elements)
        int[] topK = new int[k];
        int index = 0;
        while (!minHeap.isEmpty()) {
            topK[index++] = minHeap.poll().getKey();
        }
        
        return topK;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        
        int[] result = topKFrequent(nums, k);
        System.out.print("Top " + k + " most frequent elements are: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
