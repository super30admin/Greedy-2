#time complexity: O(V+E)
#Space complexity: O(V)
"""
# Definition for a Node.
class Node:
    def __init__(self, val = 0, neighbors = None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []
"""

class Solution:
    def cloneGraph(self, node: 'Node') -> 'Node':
        dict1={}
        if not node:
            return None
        root=Node(node.val)
        dict1[node]=root
        q=deque()
        q.append(node)
        while q:
            curr=q.popleft()
            for n in curr.neighbors:
                if n not in dict1:
                    dict1[n]= Node(n.val)
                    q.append(n)
                dict1[curr].neighbors.append(dict1[n])
        return root
            
        