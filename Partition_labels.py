// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we try to adjust start and end pointers to get the partition of a string.we traverse through the string and extend the end pointer to the index of the current last occuring element.when the index reaches end pointer then it means that we have got our partition.


# Time complexity --> o(n) n --> length of the string
# space complexity --> o(no of parttitions)
class Solution(object):
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        if S==None or len(S)==0:
            return []
        out=[]
        start=0
        end=0
        out1=[None for i in range(26)]
        # store the last occuring element index in a array
        for i in range(len(S)):
            out1[ord(S[i])-ord('a')]=i
        
        for i in range(len(S)):
            # we extending the end pointer to the maximum index the elements in the paritition can reach
            end=max(end,out1[ord(S[i])-ord('a')])
            # when i reached end pointer we have reached our partition
            if i==end:
                out.append(end-start+1)
                start=i+1
        return out
            
        