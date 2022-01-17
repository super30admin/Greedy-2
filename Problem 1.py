# Time: O(n)
# Space: O(1) # Because they are only upper case english letters
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        dic = {}
        mx = -1
        for t in tasks:
            if t not in dic:
                dic[t] = 1
            else:
                dic[t] += 1
            mx = max(mx, dic[t])
        mx_cnt = 0      
        for key,value in dic.items():
            if value == mx:
                mx_cnt += 1
        partiotins = mx - 1
        # We are already including the first A here
        avaialble_slots = partiotins * (n-(mx_cnt-1))
        pending_tasks = len(tasks) - mx_cnt*mx
        idle = max(0, avaialble_slots - pending_tasks)
        return len(tasks)+idle
        
        
