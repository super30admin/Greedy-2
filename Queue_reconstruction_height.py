// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach:
In this problem we sort the given input based on their first element in the sub array.Then we insert the elements at the index given as second element in the sub-array.


# Time complexity --> o(n*n) n is the length of the array
# space complexity --> o(n) n is the length of the array

class Solution(object):
    def compare(self,a,b):
        if a[0]==b[0]:
            return a[1]-b[1]
        else:
            return b[0]-a[0]
    def reconstructQueue(self, people):
        """
        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        if people==None or len(people)==0:
            return []
        people=sorted(people,cmp=self.compare)
        out=[]
        for i in range(len(people)):
            val=people[i]
            out.insert(val[1],val)
        return out
        