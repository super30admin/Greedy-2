# // Time Complexity :  O(n)
# // Space Complexity : O(n), hashmap unless we specify space of hashmap to be of 26 length as only lowercase letters are required.
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach

#Approach and intuition:

#Brute Force: Form all the partitions you can and check if the partitions are valid or not. Exponential runtime.

# Optimal: What if we keep track of last occurence of the character? Problems: What if the first char is not the last char of the partition?
# For every element, we'll keep the furthest away point(since we don't know the furthest away element).
#Eg: "bababcbacadefegdehijhklij"
#Create hashmap: {a:9, b:6, c:8, d:15, e:16, f:12, g:14, h:17, i:23,j:24,k:21}
# Two pointers: start, end-> defines partition and i iterates through the loop.
# @i: check if S[i] is the furthest away point for that letter? No? Move end till furthest away index(from hmap). move i ahead, is S[i]'s furthest away index still greater than the end index? No? Move end to new furthest away index, else do nothing.
# If i==end: add to o/p= end-start+1, start= i+1

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if S == None or len(S)==0:
            return []
        
        hmap = {}
        
        for i in range(len(S)):
            ch = S[i]   
            hmap[ch] = i
        
        start, end = 0,0
        output = []
        #iterate through string and calc o/p
        for i in range(len(S)):
            if end<hmap[S[i]]:
                end = hmap[S[i]]
                
            if i == end:
                output.append(end-start+1)
                start = i+1
                
        return output