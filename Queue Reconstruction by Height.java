/*
class Wrapper:
    def __init__(self, num):
        self.p = num
    def __lt__(self, other):
        if self.p[0] == other.p[0]:
            return self.p[1] < other.p[1]
        return other.p[0] < self.p[0]
    
class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        if people is None or len(people) == 0:
            return []
        
        result = []
        people.sort(key = lambda x:Wrapper(x))
        for p in people:
            result.insert(p[1], p)
            
        return result
*/

// time - O(nlogn + n^2)
// space - O(n)
// logic - first sorted acc to first index in descending and if they are equal then acc to 2nd index in ascending as we want shorter 
// height people to get in front and then added to list index specified by 2nd index in people

class Solution {
    public int[][] reconstructQueue(int[][] people) {
     if (people == null || people.length == 0)
         return new int[][] {};
    
    Arrays.sort(people, (a,b)->{
        if (a[0] == b[0])
            return a[1] - b[1];
        return b[0] - a[0];
    });
        
    List<int[]> q = new ArrayList<>();
    for (int[] p:people){
        q.add(p[1], p);
    }
    return q.toArray(new int[0][2]); 
    // return q.toArray(new int[0][]); this will also work
        
    }
}