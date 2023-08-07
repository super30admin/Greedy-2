#Time complexity is: O(n)
#Space complexity is: O(1)
#No issues faced while coding
#Code ran successfully on leetcode
class Solution(object):
    def partitionLabels(self, s):
        """
        :type s: str
        :rtype: List[int]
        """
        #Initializing local variables
        result=[]
        map={}
        #Iterating through the array and finding the ending
        #indices of each value in the array
        for i in range(len(s)):
            c=s[i]
            if(c not in map):
                map[c]=0
            map[c]=i
        #Initializing start and end variables
        start=0
        end=0
        #Iterating through the given array
        for i in range(len(s)):
            c=s[i]
            #Finiding the maximum value based on values in the range
            end=max(end,map[c])
            #If we reach end, we will append the length to the result
            #and we will updawte the start value
            if(i==end):
                result.append(end-start+1)
                start=i+1
        #Finally we are returning the result array
        return result
