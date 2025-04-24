class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        # tc O(totaltasks), sc O(1).
        counts = Counter(tasks)
        maxheap = [-count for count in counts.values()]
        import heapq
        heapq.heapify(maxheap)
        time = 0
        queue = deque()

        while maxheap or queue:
            time += 1
            if maxheap:
                cnt = 1 + heapq.heappop(maxheap)
                if cnt:
                    queue.append([cnt, time + n])

            if queue and queue[0][1] == time:
                heapq.heappush(maxheap, queue.popleft()[0])
            if queue and not maxheap and time != queue[0][1]:
                time = queue[0][1] - 1
        
        return time