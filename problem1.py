# TC:O(n)
# SC:O(1)

class Solution:
    def leastInterval(self, tasks: List[str], n: int) -> int:
        if tasks is None:
            return None

        hmap = {}
        _max = 0

        for task in tasks:
            hmap[task] = hmap.get(task, 0) + 1
            _max = max(_max, hmap[task])

        count = 0

        for key in hmap:
            if hmap[key] == _max:
                count += 1

        partition = _max - 1
        empty = partition * (n - (count - 1))
        pending = len(tasks) - _max * count

        ideal = max(0, empty - pending)

        return len(tasks) + ideal