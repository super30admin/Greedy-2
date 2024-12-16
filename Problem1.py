# Time complexity: O(N); Space: O(1)
class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        length = len(tasks)
        count = {}
        # Step 1: Create a frequency map to count occurrences of each task
        for task in tasks:
            if task in count:
                count[task] += 1
            else:
                count[task] = 1
        # Step 2: Find the maximum frequency of any task
        max_freq = max(count.values())
        max_count = 0
        for key, val in count.items():
            if val == max_freq:
                max_count += 1

        # Step 3: Calculate the number of partitions between the most frequent tasks
        partitions = max_freq - 1
        # Step 4: Calculate the total available slots in those partitions
        # Slots per partition are reduced by the count of tasks with maximum frequency
        available_slots = partitions * (n - (max_count - 1))
        # Step 5: Calculate the number of tasks that need to be placed into these available slots
        alloted_slots = max_freq * max_count
        pending_tasks = length - alloted_slots
        # Step 6: Calculate idle slots needed, ensuring it's not negative
        idle = max(0, available_slots - pending_tasks)
        total = length + idle

        return total
