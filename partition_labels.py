"""
// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below(Greedy , Two pointers)
"""
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        """
        Idea 
        - Since we need to ensure the characters are disjoint between substring, we can focus on the last occurence of the character and expand our window of search if there is any character in the window having last occurence more than current last_occurence
        - Update the window by moving next to latest window iterator(j) + 1 ( so that we don't re acess the characters in the window again)
        - Append the window llength (j(window iterator) - i(string iterator) + 1) to the result
        - return result
        """
        
        
        last_indexes = [0]*26
        #creating char array of last occurence of chars in the string
        for i,v in enumerate(S):
            last_indexes[ord(v) - ord('a')] = i
        
        i = 0
        result = []
        while i < len(S):
            #fetching the end and considering as boundary for iteration
            end = last_indexes[ord(S[i]) - ord('a')]
            j = i
            while j != end:
                #updating the end if there are characters having larger last occurence index than previous chars
                end = max(end, last_indexes[ord(S[j]) - ord('a')])
                j+=1
            
            #updating the result with partition lengths
            result.append(j-i+1)
            i = j+1
        
        return result