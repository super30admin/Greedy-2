class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        k=len(tasks)
        if tasks is None or k==0:
            return 0
        char_map={}
        max_freq=0
        max_freq_count=0
        for i in range(k):
            c =tasks[i]
            if c in char_map:
                char_map[c]+=1
            else:
                char_map[c]=1
            cnt=char_map[c]
            if cnt >max_freq:
                max_freq=cnt
        for val in char_map:
            if char_map[val]==max_freq:
                max_freq_count+=1
        partitions=max_freq-1
        empty=(n-(max_freq_count-1))*partitions
        avail =k - (max_freq_count* max_freq)
        idle = max(0,empty-avail)
        return k + idle