"""
// Time Complexity : O(N2)
// Space Complexity : O(1) // neglecting result queue
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Given below
"""
from collections import defaultdict
class Node:
    def __init__(self,data):
        #self.prev = None
        self.next = None
        self.data = data

class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        #MorE cleaner version, non complex

        #sorting the heights in descending order
        people.sort(key=(lambda x: (-x[0], x[1])))


        queue = []
        for p in people:
            #inserting the heights using the height count as index in queue, gets shuffled auto
            queue.insert(p[1], p)
        return queue
        
        
        #Long method - Linked List + map based
        """
        Idea is
        1) Create a map of height counts and corresponding list of heigths
        2) Iterate over the counts (ordered), and add the tuple to the linked list 
        as follows
            - Initialize count = 0 
            - Iterate over the linked list 
                - if the data.height <= current node.heigth:
                    increment the count
                - if count > data.height_count
                    break
            - Assign the node with data to the latest node, where breach 
            occured
        3) Convert the linked list into list for return result
        Map - height_count, < list of heights>
        O : [5,7],
        1 : [6,7],
        2 : [5],
        4 : [4]
        
        (5,0) -> (7,0) -> (5,2) -> (6,1) -> (4,4) -> (7,1)
        
        (5,0) -> (7,0) -> (5,2) -> (6,1) -> (4,4) -> (7,1) 

        """
        def insert(data):
            current = self.head
            prev = None
            count = 0
            while current :
                #increment the count for which minium height is matched
                if data[0] <= current.data[0]:
                    count+=1
                #breach condition
                if count>data[1]:
                    break
                prev = current
                current = current.next
            if prev:
                prev.next = Node(data)
                prev = prev.next
            else:
                #in case of adding a new node to head
                prev = Node(data)
                self.head = prev
            #linking the newnode to current
            prev.next = current

        height_map = defaultdict(list)
        #min_value = float("")
        for i in people:
            height_map[i[1]].append(i[0])
        print(height_map)
        
        self.head = None
        for k in sorted(height_map):
            for h in sorted(height_map[k]):
                insert([h,k])
        result = []
        while self.head:
            result.append(self.head.data)
            self.head = self.head.next
        return result