#     T.C= > O(N)
#     S.C => O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if len(tasks) == None: return 0
        maps = {}
        maxfreq = 0
        maxCount = 0
        for i in range(len(tasks)):
            maps[tasks[i]] = 1 + maps.get(tasks[i], 0)
            # print(maps.get(tasks[i]))
            maxfreq = max(maxfreq, maps.get(tasks[i]))
        for task in maps.keys():
            print(task)
            if maxfreq == maps.get(task):
                maxCount += 1
        partitions = maxfreq - 1
        empty = partitions * (n - (maxCount - 1))
        pending = len(tasks) - (maxfreq * maxCount)
        idle = max(0, empty - pending)
        return len(tasks) + idle

