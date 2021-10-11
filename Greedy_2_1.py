class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if n==0:
            return len(tasks)
        l1=len(tasks)
        D=[0]*26
        for i in range(l1):
            D[ord(tasks[i])-65]+=1
        D.sort()
        group=D[25]-1
        idle=group*n
        print(group,idle)
        for i in range(len(D)-1):
            idle-=min(D[24-i],group)
        print(idle)
        if idle<=0:
            return len(tasks)
        return len(tasks)+idle
        

%TC:O(n)
%SC:O(n)