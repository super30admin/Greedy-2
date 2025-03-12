// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    for(char c: tasks) {
      map.put(c, map.getOrDefault(c, 0)+1);
    }
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    for(int i: map.values()) {
      maxHeap.add(i);
    }
    int time = 0;
    while(!maxHeap.isEmpty()) {
      List<Integer> temp = new ArrayList<>();
      int cycle = n+1;
      for(int i = 0; i<cycle && !maxHeap.isEmpty(); i++) {
        temp.add(maxHeap.poll() - 1);
        time++;
      }
      for(int count: temp) {
        if(count > 0) maxHeap.offer(count);
      }
      if(!maxHeap.isEmpty()) time += cycle - temp.size();
    }
    return time;
  }
}