#Time complexity: O(n^n)
#Space complexity: O(n)
class Solution:
    def removeInvalidParentheses(self, s: str) -> List[str]:
        q=deque()
        st=set()
        flag=False
        res=[]
        if self.isValid(s)==True:
            res.append(s)
            return res
        q.append(s)
        st.add(s)
        while q and not flag:
            size=len(q)
            for i in range(size):
                curr=q.popleft()
                for i in range(len(curr)):
                    sub_str=curr[:i]+curr[i+1:]
                    #print(sub_str)
                    if self.isValid(sub_str) and sub_str not in st:
                        flag=True
                        res.append(sub_str)
                    if sub_str not in st:
                        q.append(sub_str)
                        st.add(sub_str)
        return res
                                    
    
    def isValid(self,s):
        count=0
        for i in s:
            if i=='(':
                count+=1
            elif i==')':
                count-=1
            if count<0:
                return False
        return count==0
        
        