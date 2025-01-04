"""
schedule most frequent task first, update the frequency and based on interval schedule next task
TC: O(n*m )n length of all tasks , m idle time
SP:O(1)
"""
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        heap = []
        freqMap = Counter(tasks)
        q = deque()
        for _, v in freqMap.items():
            heapq.heappush(heap, -v)
        time = 0
        while heap or q:
            time += 1
            if heap:
                cnt = 1 + heapq.heappop(heap)
                if cnt:
                    q.append((cnt, time + n))
            if q and q[0][1] == time:
                heapq.heappush(heap, q.popleft()[0])

        return time
