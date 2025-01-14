import java.util.PriorityQueue;

/**
 * @author pku-lyh
 * @Description 描述
 * @date 2025/1/14 9:08
 */
public class LeetCode295 {
    class MedianFinder {
        // 最大堆存储较小的一半，最小堆存储较大的一半
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        int size;

        public MedianFinder() {
            maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
            } else {
                minHeap.offer(num);
            }
            if (maxHeap.size() > minHeap.size()) {
                minHeap.offer(maxHeap.poll());
            } else if (maxHeap.size() + 1 < minHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            if (!minHeap.isEmpty() && !maxHeap.isEmpty() && minHeap.peek()<maxHeap.peek()){
                int temp = maxHeap.poll();
                maxHeap.offer(minHeap.poll());
                minHeap.offer(temp);
            }
        }

        public double findMedian() {
            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        }
    }
}
