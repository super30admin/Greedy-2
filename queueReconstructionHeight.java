// Time Complexity : O(n^2)
// Space Complexity : O(n)

class Solution {
  public int[][] reconstructQueue(int[][] people) {
    PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);
    List<int[]> result = new ArrayList<>();

    for(int[] person: people) {
      minHeap.add(person);
    }

    while(!minHeap.isEmpty()) {
      int[] current = minHeap.poll();
      result.add(current[1], current);
    }
    return result.toArray(new int[result.size()][]);
  }
}