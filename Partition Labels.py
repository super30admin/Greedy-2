# Time:- O(n)
# Space:- O(n)
# Approach:- Maintain an occurences map which keeps track of the last occurence of a charachter. Start from the first charachter and keep moving towards the last occurence of this charachter, In the process 
# if we find a charachter whose last occurence is more than the current window end we increase the window size, when we finally close the window we have found a partition
class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        occurences_dict=collections.defaultdict(int)
        for i in range(len(S)):
            occurences_dict[S[i]]=i
        l,r,i=0,0,0
        res=[]
        while(i<=r and r<len(S)):
            r=max(r,occurences_dict[S[i]])
            if i==r:
                res.append(r-l+1)
                l=r+1
                if l<len(S):
                    r=occurences_dict[S[l]]
            i+=1
        return res
            