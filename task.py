# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No

# we count the number of each tasks and get the maxfreq task and also count the number of tasks with max freq. now we fill rest of the tasks present in the avialble slots and return the value
class Solution(object):
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        # O(n), O(n)
        hmap={}
        count=0
        ret=Counter(tasks)
        max_freq=max(ret.values())
        for valu in ret.values():
            if valu==max_freq:
                count+=1
        length=max_freq+n*(max_freq-1) + count-1
        return max(len(tasks), length)