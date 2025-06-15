# Time Complexity : O(n)
# Space Complexity : O(1)

class Solution:
    def canJump(self, nums):
        n = len(nums)
        target = n-1
        
        for i in range(n-2, -1, -1):
            if nums[i] + i >= target:
                target = i

        return target == 0

class Solution:
    def canJump(self, nums):
        n = len(nums)
        memo = set()
        def dfs(currIdx):
            if currIdx == n-1:
                return True
            if currIdx in memo: return False
            jump = nums[currIdx]
            for i in range(1, jump+1):
                jumpIdx = currIdx + i
                if dfs(jumpIdx):
                    return True
            memo.add(currIdx)
            return False

        return dfs(0)

class Solution:
    def canJump(self, nums):
        n = len(nums)

        def dfs(currIdx):
            if currIdx == n-1:
                return True

            jump = nums[currIdx]
            for i in range(1, jump+1):
                jumpIdx = currIdx + i
                if dfs(jumpIdx):
                    return True
            return False

        return dfs(0)

from collections import deque
class Solution:
    def canJump(self, nums):
        n = len(nums)

        if n == 1: return True

        q = deque()
        q.append(0)
        visit = set()
        visit.add(0)

        while q:
            currIdx = q.popleft()
            jump = nums[currIdx]
            for i in range(1, jump+1):
                jumpIdx = currIdx + i
                if jumpIdx == n-1: return True
                if jumpIdx not in visit:
                    q.append(jumpIdx)
                    visit.add(jumpIdx)
        return False

class Solution:
    def canJump(self, nums):
        n = len(nums)

        if n == 1: return True
        
        q = deque()
        q.append(0)

        while q:
            currIdx = q.popleft()
            jump = nums[currIdx]
            for i in range(1, jump+1):
                jumpIdx = currIdx + i
                if jumpIdx == n-1: return True
                q.append(jumpIdx)
        return False