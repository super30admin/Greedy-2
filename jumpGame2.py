# Works : TC = O(n^2), SC = O(n)
class Solution:
    def jump(self, nums):
        n = len(nums)
        if n == 1: return 0
        memo = {}
        def dfs(currIdx):
            if currIdx >= n-1: return 0
            if currIdx in memo: return memo[currIdx]
            jump = nums[currIdx]
            steps = 999999
            for i in range(1, jump+1):
                jumpIdx = currIdx + i
                steps = min(steps, dfs(jumpIdx)+1)
            memo[currIdx] = steps
            return steps

        return dfs(0)

# Time limit exceeded
class Solution:
    def jump(self, nums):
        n = len(nums)
        if n == 1: return 0

        def dfs(currIdx):
            if currIdx >= n-1: return 0

            jump = nums[currIdx]
            steps = 999999
            for i in range(1, jump+1):
                jumpIdx = currIdx + i
                steps = min(steps, dfs(jumpIdx)+1)
            return steps

        return dfs(0)

from collections import deque
class Solution:
    def jump(self, nums):
        n = len(nums)

        if n == 1: return 0

        q = deque()
        q.append(0)
        visit = set()
        visit.add(0)
        level = 0

        while q:
            size = len(q)
            level += 1
            for i in range(size):
                currIdx = q.popleft()  
                jump = nums[currIdx]
                for k in range(1, jump+1):
                    jumpIdx = currIdx + k
                    if jumpIdx == n-1: return level
                    if jumpIdx not in visit:
                        q.append(jumpIdx)
                        visit.add(jumpIdx)