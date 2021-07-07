# Time Complexity : O(n^2) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def reconstructQueue(self, people):
        people = sorted(people, key = lambda x : (-x[0], x[1])) # n logn 
        queue = []
        
        # O(n)
        for nums in people:
            # O(n), as it pushes element further in O(n)
            queue.insert(nums[1], nums)  # (Index, sub-array)
        
        return queue

if __name__ == "__main__":
    s = Solution()
    people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
    
    # Test case 1 
    print(s.reconstructQueue(people))