class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        count = Counter(tasks)
        # Counter({'A': 3, 'B': 3})
        maxHeap=[]
        for cnt in count.values():
            maxHeap.append(-cnt)
        # maxHeap = [-2,-3]
        heapq.heapify(maxHeap)
        time = 0 # 1
        q = collections.deque()
        # q=[[-2,3]]
        while maxHeap or q: 
            time += 1 
            if maxHeap: 
                cnt = 1 + heapq.heappop(maxHeap)
                # cnt = -2
                if cnt:
                    q.append([cnt,time+n])
            if q and q[0][1] == time: 
                heapq.heappush(maxHeap, q.popleft()[0])
        
        return time 



--- SIMULATION START ---

⏰ [Time = 1] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? True (Frequencies: [3, 3])
   -> Elements in Queue? False (Queue: [])

   ❓ Checking condition: 'if maxHeap:'
      ✅ TRUE: There is at least one task type available to run.
      👉 Action: Popped task from heap (had 3 remaining). It is now executing.
      ❓ Checking sub-condition: 'if cnt:' (Are there more copies of this task left? New count = 2)
         ✅ TRUE: 2 copies remain. Sending task to cooldown queue.
         👉 Calculation: Current Time (1) + Cooldown (2) = Available again at Time 3

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (3) matches Current Time (1)...
      ❌ FALSE: The front task isn't ready yet. It needs to wait until Time = 3.

   📊 End of Tick 1 Status -> Heap: [3] | Queue: [[2, 3]]
------------------------------------------------------------

⏰ [Time = 2] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? True (Frequencies: [3])
   -> Elements in Queue? True (Queue: [[2, 3]])

   ❓ Checking condition: 'if maxHeap:'
      ✅ TRUE: There is at least one task type available to run.
      👉 Action: Popped task from heap (had 3 remaining). It is now executing.
      ❓ Checking sub-condition: 'if cnt:' (Are there more copies of this task left? New count = 2)
         ✅ TRUE: 2 copies remain. Sending task to cooldown queue.
         👉 Calculation: Current Time (2) + Cooldown (2) = Available again at Time 4

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (3) matches Current Time (2)...
      ❌ FALSE: The front task isn't ready yet. It needs to wait until Time = 3.

   📊 End of Tick 2 Status -> Heap: [] | Queue: [[2, 3], [2, 4]]
------------------------------------------------------------

⏰ [Time = 3] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? False (Frequencies: [])
   -> Elements in Queue? True (Queue: [[2, 3], [2, 4]])

   ❓ Checking condition: 'if maxHeap:'
      ❌ FALSE: The heap is completely empty. The CPU has no choice but to sit IDLE this turn.

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (3) matches Current Time (3)...
      ✅ TRUE: The task at the front of the queue has finished its cooldown!
         👉 Action: Popping from Queue and pushing 2 copies back into the Max Heap.

   📊 End of Tick 3 Status -> Heap: [2] | Queue: [[2, 4]]
------------------------------------------------------------

⏰ [Time = 4] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? True (Frequencies: [2])
   -> Elements in Queue? True (Queue: [[2, 4]])

   ❓ Checking condition: 'if maxHeap:'
      ✅ TRUE: There is at least one task type available to run.
      👉 Action: Popped task from heap (had 2 remaining). It is now executing.
      ❓ Checking sub-condition: 'if cnt:' (Are there more copies of this task left? New count = 1)
         ✅ TRUE: 1 copies remain. Sending task to cooldown queue.
         👉 Calculation: Current Time (4) + Cooldown (2) = Available again at Time 6

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (4) matches Current Time (4)...
      ✅ TRUE: The task at the front of the queue has finished its cooldown!
         👉 Action: Popping from Queue and pushing 2 copies back into the Max Heap.

   📊 End of Tick 4 Status -> Heap: [2] | Queue: [[1, 6]]
------------------------------------------------------------

⏰ [Time = 5] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? True (Frequencies: [2])
   -> Elements in Queue? True (Queue: [[1, 6]])

   ❓ Checking condition: 'if maxHeap:'
      ✅ TRUE: There is at least one task type available to run.
      👉 Action: Popped task from heap (had 2 remaining). It is now executing.
      ❓ Checking sub-condition: 'if cnt:' (Are there more copies of this task left? New count = 1)
         ✅ TRUE: 1 copies remain. Sending task to cooldown queue.
         👉 Calculation: Current Time (5) + Cooldown (2) = Available again at Time 7

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (6) matches Current Time (5)...
      ❌ FALSE: The front task isn't ready yet. It needs to wait until Time = 6.

   📊 End of Tick 5 Status -> Heap: [] | Queue: [[1, 6], [1, 7]]
------------------------------------------------------------

⏰ [Time = 6] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? False (Frequencies: [])
   -> Elements in Queue? True (Queue: [[1, 6], [1, 7]])

   ❓ Checking condition: 'if maxHeap:'
      ❌ FALSE: The heap is completely empty. The CPU has no choice but to sit IDLE this turn.

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (6) matches Current Time (6)...
      ✅ TRUE: The task at the front of the queue has finished its cooldown!
         👉 Action: Popping from Queue and pushing 1 copies back into the Max Heap.

   📊 End of Tick 6 Status -> Heap: [1] | Queue: [[1, 7]]
------------------------------------------------------------

⏰ [Time = 7] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? True (Frequencies: [1])
   -> Elements in Queue? True (Queue: [[1, 7]])

   ❓ Checking condition: 'if maxHeap:'
      ✅ TRUE: There is at least one task type available to run.
      👉 Action: Popped task from heap (had 1 remaining). It is now executing.
      ❓ Checking sub-condition: 'if cnt:' (Are there more copies of this task left? New count = 0)
         ❌ FALSE: That was the absolute last copy of this task type. It is completely finished!

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ... Queue has items. Checking if the front task's ready time (7) matches Current Time (7)...
      ✅ TRUE: The task at the front of the queue has finished its cooldown!
         👉 Action: Popping from Queue and pushing 1 copies back into the Max Heap.

   📊 End of Tick 7 Status -> Heap: [1] | Queue: []
------------------------------------------------------------

⏰ [Time = 8] Loop condition evaluated: 'while maxHeap or q' is TRUE because:
   -> Elements in Heap? True (Frequencies: [1])
   -> Elements in Queue? False (Queue: [])

   ❓ Checking condition: 'if maxHeap:'
      ✅ TRUE: There is at least one task type available to run.
      👉 Action: Popped task from heap (had 1 remaining). It is now executing.
      ❓ Checking sub-condition: 'if cnt:' (Are there more copies of this task left? New count = 0)
         ❌ FALSE: That was the absolute last copy of this task type. It is completely finished!

   ❓ Checking condition: 'if q and q[0][1] == time:'
      ❌ FALSE: The cooldown queue is completely empty. Nothing to bring back.

   📊 End of Tick 8 Status -> Heap: [] | Queue: []
------------------------------------------------------------

--- SIMULATION END ---
Total Time Required: 8