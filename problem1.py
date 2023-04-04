#time complexity: O(nlogn)
#sapce complexity: O(1)
#ran on leetocde: yes
#create an array to keep track of the frequency of each task. sort the array in ascending order, calculate the maximum frequency, and calculate the idle time required after the execution of the tasks with the maximum frequency. Go through sorted array and calculates the remaining idle time. Finally, return the total time required to execute all tasks and the idle time.
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        freq = [0] * 26

        for c in tasks:
            freq[ord(c) - ord('A')] += 1

        freq.sort()

        freq_max = freq[25]
        idle_time = (freq_max - 1) * n

        for i in range(len(freq) - 2, -1, -1):
            idle_time -= min(freq_max - 1, freq[i])

        idle_time = max(idle_time, 0)
        return idle_time + len(tasks)
        
        
