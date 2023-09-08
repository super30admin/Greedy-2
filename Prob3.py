
#O(n) TC and O(1) SC

class Solution:
    def leastInterval(self, tasks, n):
        task_counts = {}
        #build a dict to get max frequency
        for task in tasks:
            if task in task_counts:
                task_counts[task] += 1
            else:
                task_counts[task] = 1

        max_count = max(task_counts.values())  # Find the task with the maximum count
        max_count_tasks = list(task_counts.values()).count(max_count) #get count of how many tasks have max_count


        #below 4 lines are just math.
        #Place the max_count_tasks and n empty space betweeen then
        partitions = max_count - 1 #number of partitions between the max_count_tasks
        empty_slots = partitions * (n - (max_count_tasks - 1)) #this is the empty slots
        pending_tasks = len(tasks) - (max_count * max_count_tasks) #pending_tasks are the rest of the tasks
        idle = max(0, empty_slots - pending_tasks) #here, if empty slots-pending_tasks is negative, that means pending_tasks>..empty_slots, then you place the remaing pending_tasks around the 1st and last max_count_tasks and not inbetween.
        #eg A,C,_,_A,C,_,_A,C and pending_tasks is 6, that means 4 of them can be places in the empty slots-> A,C,B,D,A,C,B,D,A,C and the other 2 around 1st and last max_count_tasks -> B,A,C,B,D,A,C,B,D,A,C,D.

        return len(tasks) + idle
