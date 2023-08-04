class Solution(object):
    def reconstructQueue(self, people):
        """
        Reconstruct the queue based on people's height and number of people in front.

        Time complexity: O(n log n) due to sorting.
        Space complexity: O(n) for the result list, therefore O(1)

        :type people: List[List[int]]
        :rtype: List[List[int]]
        """
        def custom_sort(a, b):
            """
            Custom sorting function to sort people based on height in descending order,
            and if heights are equal, based on k (number of people in front) in ascending order.
            """
            if a[0] == b[0]:  # If heights are equal, sort based on k value
                return a[1] - b[1]
            # Otherwise, sort based on height in descending order
            return b[0] - a[0]

        # Sort people based on custom_sort function
        people.sort(cmp=custom_sort)

        # Create an empty list to store the reconstructed queue
        result = []

        # Insert people at their desired position based on k value
        for person in people:
            result.insert(person[1], person)

        return result
