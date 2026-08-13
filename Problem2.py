# Problem2: Queue Reconstruction by Height (https://leetcode.com/problems/queue-reconstruction-by-height/)
# Time Complexity: O(n^2),We sort the people first, which takes O(n log n) time. Then for each person we insert into result at a specific index.
# Inserting into a list at a given index takes O(n) time in the worst case because every element after that index has to shift right.
# We do this insert once per person, so that is O(n) work times n people, giving O(n^2). The O(n^2) insertion step dominates the O(n log n) sort, so overall it is O(n^2).
# Space Complexity: O(n), We build one new list called result that holds all n people. We are not using any extra data structures that grow with input size beyond this.
# Approach:
# First we sort people by height in descending order, so the tallest person comes first.
# If two people have the same height, we sort them by k in ascending order, where k is how many taller or equal people should be in front of them.
# Then we go through the sorted list one person at a time and insert each person into result at index k, which is their own k value.
# Since we always place taller people first, everyone already in result is taller than or equal to the person we are inserting.
# So inserting at index k automatically gives that person exactly k taller or equal people in front of them, without needing to search for the right spot.

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        # Sort people by height descending using -a[0]
        # If heights are equal, sort by k ascending using a[1]
        # This tuple key makes taller people come first and among equal heights, the person expecting fewer people in front comes first
        people.sort(key=lambda a: (-a[0], a[1]))

        # This will hold the final reconstructed queue
        result = []

        # Go through each person in the sorted order, tallest first
        for i in people:
            # i[1] is the k value, which is the index where this person belongs
            # i is the full [height, k] pair being inserted at that index
            # everything already in result is taller or equal, so this placement
            # gives this person exactly the number of taller people they expect in front
            result.insert(i[1], i)

        # Return the fully reconstructed queue
        return result