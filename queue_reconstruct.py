def reconstructQueue(people):
    people.sort(key=lambda x: (-x[0], x[1]))
    queue = []
    for person in people:
        queue.insert(person[1], person)
    return queue

# Time complexity: O(n^2)
# Space complexity: O(n)
