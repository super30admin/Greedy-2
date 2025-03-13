class Solution:
    # greedy logic
    # TC: O(n) -- n is number of tasks
    # SC: O(1)  -- as number of alphabets is constant

    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks is None or len(tasks) == 0:
            return 0
        hmap = defaultdict(int)
        maxfreq, maxct = 0,0
        # storing frequency of each task
        for i in range(len(tasks)):
            c = tasks[i]
            hmap[c] += 1
            maxfreq = max(maxfreq,hmap[c])
        # get maxct
        for key,val in hmap.items():
            if val == maxfreq:
                maxct += 1
        partitions = maxfreq - 1
        emptyslots = partitions * (n-(maxct-1))
        pendingtasks = len(tasks)-(maxfreq*maxct)
        idletasks = max(0,emptyslots-pendingtasks)
        return len(tasks)+idletasks
