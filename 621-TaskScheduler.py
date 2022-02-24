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

#     T.C= > O(N)
#     S.C => O(1)
#     approach => Create a hashmap put all the values in it. Then remove the maxfrequence from that hashmap and the toal count of max frequence. how you will find maxcount its like take the keys from the maps and gets its value. if the value matches increase the maxcount. 
# Then calculate partions as maxfreq -1, empty as partions subtracting by (n - (maxcount - 1)), pending as len(task) substract max fre * mac count. idle is max(0, empty - pending) while return task.lenght + idle