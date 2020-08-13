# Time Complexity : O(2n) = O(n) 
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
class Solution:
    def partitionLabels(self, S):
        result = []
        if len(S) == 0:
            return result 
        
        start, end = 0, 0 
        map_ = {}                   # Space = O(26)
        
        # Time = O(n) 
        for i in range(len(S)):
            map_[S[i]] = i 
        
        # Time = O(n) 
        for i in range(len(S)):
            key = map_[S[i]]
            end = max(end, key)
            if i == end:
                result.append(end - start + 1)
                start = end+1
        
        return result
    
if __name__ == "__main__":
    s = Solution()
    S = "ababcbacadefegdehijhklij"
    
    # Test case 1
    print(s.partitionLabels(S))