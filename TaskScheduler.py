"""
Rasika Sasturkar
Time Complexity: O(n), n is total no. of tasks.
Space Complexity: O(1)
"""

from collections import defaultdict


def leastInterval(tasks, n: int) -> int:
    # null case
    if tasks is None:
        return 0

    if n == 0:
        return len(tasks)

    freq_map = defaultdict(int)
    max_freq = 0

    for task in tasks:
        if task in tasks:
            freq_map[task] += 1
            max_freq = max(max_freq, freq_map[task])

    max_count = 0
    for key in freq_map:
        if freq_map[key] == max_freq:
            max_count += 1

    # Maths
    partitions = max_freq - 1
    available_slots = partitions * (n - (max_count - 1))
    pending_tasks = len(tasks) - (max_freq * max_count)
    empty_slots = max(0, (available_slots - pending_tasks))
    return len(tasks) + empty_slots


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all the test cases.
    """
    print(leastInterval(tasks=["A", "A", "A", "B", "B", "B"], n=2))  # returns 8
    print(leastInterval(tasks=["A", "A", "A", "B", "B", "B"], n=0))  # returns 6
    print(leastInterval(tasks=["A", "A", "A", "A", "A", "A", "B", "C", "D",
                               "E", "F", "G"], n=2))  # returns 16


if __name__ == "__main__":
    main()
