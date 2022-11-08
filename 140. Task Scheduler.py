class Solution:
    def leastInterval(self, tasks, n):
        if tasks is None or len(tasks) == 0:
            return 0

        maxFreq = 0
        maxCount = 0
        hashMap = dict()

        for i in tasks:
            hashMap[i] = hashMap.get(i, 0) + 1
            maxFreq = max(maxFreq, hashMap.get(i))

        for i in hashMap.keys():
            if maxFreq == hashMap.get(i):
                maxCount += 1

        # print(maxCount, maxFreq, hashMap)

        partitions = maxFreq - 1
        empty = partitions * (n - (maxCount - 1))
        pending = len(tasks) - (maxCount * maxFreq)
        idle = max(0, (empty - pending))

        return print(len(tasks) + idle)


if __name__ == "__main__":
    obj = Solution()
    obj.leastInterval(["A", "A", "A", "A", "A", "A", "B", "C", "D", "E", "F", "G"], 2)

# Greedy
# Time Complexity: O(n)
# Space Complexity: O(n)
# Did this code successfully run on Leetcode : No, Time Limit Exceeded
# Any problem you faced while coding this : No
