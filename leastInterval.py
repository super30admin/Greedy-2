# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
def leastInterval(self, tasks: List[str], n: int) -> int:
        task_map = {}
        for task in tasks:
            task_map[task] = task_map.get(task, 0) + 1

        task_list = sorted(task_map.items(), key=itemgetter(1), reverse=True)
        idle_slots = (task_list[0][1] - 1 ) * n

        for task in task_list[1:]:
            idle_slots -= min(task[1], task_list[0][1]-1)
        if idle_slots > 0:
            return len(tasks) + idle_slots
        else:
            return len(tasks)
