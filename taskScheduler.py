import collections

#timeComplexity : o(n)
#spaceComplexity : o(n)

def leastInterval(self, tasks: List[str], n: int) -> int:
    if not tasks:
        return 0
    if n == 0:
        return len(tasks)
    maxFreq = 0
    maxCount = 0
    counter = collections.defaultdict(int)
    for idx, val in enumerate(tasks):
        counter[val] += 1
        if counter[val] > maxFreq:
            maxFreq = counter[val]

    for val in counter.values():
        if val == maxFreq:
            maxCount += 1

    partions = (maxFreq - 1)
    numSlots = partions * (n - (maxCount - 1))
    pending = len(tasks) - (maxFreq * maxCount)
    idle = max(0, numSlots - pending)

    return len(tasks) + idle