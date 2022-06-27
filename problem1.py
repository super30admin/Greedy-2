class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        hm = dict()
        mf = 0
        mc=0
        for i in tasks:
            if i not in hm:
                hm[i]= 0
            hm[i]+=1
            mf=max(mf,hm[i])
        
        for i in hm:
            if(hm[i]==mf):
                mc+=1
        p = mf-1
        e = p*(n-(mc-1))
        c = len(tasks)-(mf*mc)
        i = max(0,e-c)
        return len(tasks)+i