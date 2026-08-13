# Problem1: Task Scheduler (https://leetcode.com/problems/task-scheduler/)
# Time Complexity: O(T + U) where T is the total number of tasks and U is the number of unique task letters.
# We loop through all tasks once which is O(T), then loop through the map of unique letters which is at most 26 entries so that part is O(U), basically constant.
# Space Complexity: O(U) since the map only stores counts for unique task letters, at most 26 entries since tasks are letters A to Z.
# Approach:
# First we count how many times each task letter appears and find the highest frequency among them.
# Then we count how many different letters share that highest frequency, since all of them will need a slot in the busiest round.
# We build the schedule around the most frequent task, treating it as blocks with gaps between them.
# We check how many empty slots exist in those gaps, and see if other leftover tasks can fill them.
# Whatever empty slots are left after filling become forced idle time, and we add that to the total task count.

from typing import List


class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        map = {}                # dictionary to store how many times each task letter appears
        max_frequency = 0       # tracks the highest frequency seen among all letters
        max_count = 0            # tracks how many different letters share that highest frequency

        for char in tasks:            # go through every task letter in the input, one at a time
            map[char] = map.get(char, 0) + 1        # get current count for this letter, or 0 if not seen yet, then add one and save it back
            max_frequency = max(max_frequency, map[char])       # update max_frequency if this letter's count is now the highest seen

        for char in map:                          # go through each unique letter that exists as a key in map
            if map[char] == max_frequency:        # check if this letter's count matches the highest frequency
                max_count += 1                    # if it does, this letter is tied for most frequent, so count it

        partitions = max_frequency - 1           # the most frequent task creates this many gaps between its repeated copies
        available_slots = partitions * (n - (max_count - 1))  # total empty slots across all gaps, after reserving space for other tied top letters
        pending = len(tasks) - (max_frequency * max_count)    # how many leftover tasks are not part of the top frequency group and still need placing
        idle = max(0, available_slots - pending)            # fill empty slots with leftover tasks, whatever slots remain unfilled become true idle time, clamp at 0 so it is never negative

        return len(tasks) + idle                # final answer is all actual tasks plus however much idle time is truly needed