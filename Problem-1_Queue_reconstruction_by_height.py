# APPROACH 1: Greedy solution
# Time Complexity : O(n^2), n: length of people. Sorting -> O(n lgn), Placing in the result, for each element might have to shift till the last index -> O(n) and O(n) elements. 
# Space Complexity : O(n), space of sorting
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Sort the people array by descending order of height and if the height is same, then by increasing order of k. (INTUITION: Dont care about the number of shorter people standing 
#    in front of a person. Dont care at all about people standing back of a person. We need ascending order of k as k means the number of people standing in front of it. So 
#    smaller k person will be placed more front in the result than the person with larger k. 
# 2. So place first the longer height people in result array at index given by k. 
# 3. If that index is already occupied, then shift (from that index) rightwards to create space for this new element which is guranteed to have shorter height than the person 
#    currently at this index. 

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people is None or len(people) < 1:
            return None
        
        people.sort(key = lambda x: (-x[0], x[1]))
        result = [None for _ in range(len(people))]
        
        for h, k in people:
            if result[k] is not None:
                shift_ind = len(people) - 1
                while shift_ind > k:
                    result[shift_ind] = result[shift_ind - 1]
                    shift_ind -= 1
            result[k] = [h, k]
            
        return result
        
