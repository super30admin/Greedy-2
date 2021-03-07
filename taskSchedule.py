class Solution:
    
    """
    Description: for a list of CPU tasks, with a given cooldown period between same tasks, find the time to complete all the tasks
    
    Time Complexity: O(n)
    Space Complexity: O(n)
    
    Approach:
    - space task with maximum frequency with n distance apart by imagining an empty array, see below
      for ["A","A","A","B","B","C"]: space like: A--A--A for n = 2
    - there is an opportunity to fill other tasks in empty spaces (-), find available places to fill (4 in above example)
    - find idle spaces by differencing between empty and available
    - return size of task + idle as the resulting time to complete all the task
    
    + Modifications:
      - for multiple tasks with same frequency:
        use groups (derive another paramter, maximum count with same maximum frequency)
        + one can modify the empty spaces by reducing it by multiplying with maximum count (e.g. AB-AB-AB for ["A","A","A","B","B","B","C"])
        + winsorize the idle space with 0 (cannot be negative)
    """
    
    def leastInterval(self, tasks: List[str], n: int) -> int:
        
        from collections import defaultdict
        freq_map = defaultdict(int)
        max_freq = 0; max_count = 0
        
        for task in tasks:
            freq_map[task] += 1
            max_freq = max(freq_map[task], max_freq)
            
        for val in freq_map.values():
            if val == max_freq: 
                max_count += 1
            
        partitions = max_freq - 1
        empty = (n - (max_count - 1))*partitions
        available = len(tasks) - max_freq*max_count
        idle = max(0, empty - available)
        
        return len(tasks) + idle
        
