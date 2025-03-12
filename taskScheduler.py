class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # T: O(n log n), S: O(n)
        # Step 1: Count frequency of each task
        task_count = collections.Counter(tasks)

        # Step 2: Create a max-heap based on task frequency
        max_heap = [-count for count in task_count.values()]
        heapq.heapify(max_heap)

        time = 0
        queue = []  # To keep track of tasks in cooldown

        while max_heap or queue:
            time += 1

            # Process task from the heap
            if max_heap:
                count = heapq.heappop(max_heap) + 1  # Take task with highest frequency
                if count < 0:
                    queue.append((count, time + n))  # Task enters cooldown

            # Check if any task is ready to come out of cooldown
            if queue and queue[0][1] == time:
                heapq.heappush(max_heap, queue.pop(0)[0])

        return time
