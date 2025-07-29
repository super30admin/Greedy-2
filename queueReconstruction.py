"""
Sort people by height descending and then by k ascending (tallest first, then place shorter ones)
Insert each person at index k in the result — this works because taller people won’t be affected by shorter ones
Inserting at position k ensures k taller-or-equal people are before them
"""
"""
Time Complexity : O(n²)	Due to insert() in list (worst case)
Space Complexity : O(n)	For output queue
"""

class queueReconstruction:
    def reconstructQueue(self, people: list[list[int]]) -> list[list[int]]:
        people.sort(key=lambda x: (-x[0], x[1]))
        queue = []
        for person in people:
            queue.insert(person[1], person)
        return queue

if __name__ == "__main__":
    obj = queueReconstruction()
    print(obj.reconstructQueue([[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]))
    print(obj.reconstructQueue([[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]))
