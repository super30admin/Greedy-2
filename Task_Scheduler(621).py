class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks is None or len(tasks)==0:
            return 0

        freq = collections.Counter(tasks) # hashmap to count frequencies of tasks
        # Here we are storing negative values since heapify would convert it into
        # a minheap and putting a negative value would achieve out purpose
        maxHeap = [-count for count in freq.values()]
        # we are only storing the frequencies of the task in the maxheap
        heapq.heapify(maxHeap)

        queue = collections.deque()
        time = 0

        # If any one is non-empty => tasks are left
        while maxHeap or queue:
            # Since each task would take 1 unit of time
            time+=1

            # if there is a task that can be taken up by the system
            # it will show up in maxheap
            if maxHeap:
                # we pop the heap and add 1 to the freq of that task
                # since here the freq is in negative
                count = heapq.heappop(maxHeap) + 1
                # once the freq of a task reaches 0 it will be permanently poppped
                # and never added back
                # we only add to queue if the task can be taken up again in the future
                if count!=0:
                    queue.append((count,time+n))

            # if the queue has a task that has satisfied its cooldown
            # we add the tasks's freq to the maxheap
            if queue and queue[0][1]==time:
                heapq.heappush(maxHeap, queue.popleft()[0])

        return time