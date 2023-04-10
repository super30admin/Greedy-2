"""
Rasika Sasturkar
Time Complexity: O(n^2), sorting and rearranging
Space Complexity: O(1)
"""


def reconstructQueue(people):
    result = []
    sorted_people = sorted(people, key=lambda x: (-x[0], x[1]))

    for person in sorted_people:
        result.insert(person[1], person)

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all the test cases.
    """
    print(reconstructQueue(people=[[7, 0], [4, 4], [7, 1], [5, 0], [6, 1],
                                   [5, 2]]))  # returns [[5, 0], [7, 0], [5, 2], [6, 1], [4, 4], [7, 1]]
    print(reconstructQueue(people=[[6, 0], [5, 0], [4, 0], [3, 2], [2, 2],
                                   [1, 4]]))  # returns [[4, 0], [5, 0], [2, 2], [3, 2], [1, 4], [6, 0]]


if __name__ == "__main__":
    main()
