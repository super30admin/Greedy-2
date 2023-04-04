#Time complexity: O(n)
#space complexity: O(1)
#ran on leetcode: Yes
#create a hash map that stores last occurrence indexes of all characters. Maintain 2 pointers to denote the start and end of the substring. The end will be the max among all last occurring indexes in the current window. When the iterating pointer reaches end, this means all charcters between start and end will not occur further in the array so their size can be stored in result array.
class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        D={}
        L=[]
        for i in range(len(s)):
            D[s[i]]=i
        
        start=0
        end=0
        i=0
        while(i<len(s)):
            end=max(end,D[s[i]])
            if(i==end):
                L.append(end-start+1)
                start=i+1
            i+=1
        return L

