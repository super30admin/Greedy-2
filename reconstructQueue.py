class Solution:
    '''
    Algorithm :
    1. Sort the input array by 
        decending order of heights and
        ascending order of k
    2. iterate over the sorted list and 
        insert the element as per it's k
        
    Let's start from the simplest case, when all guys (h, k) in the queue are of the same height h, and differ by their k values only (the number of people in front who have a greater or the same height). Then the solution is simple: each guy's index is equal to his k value. The guy with zero people in front takes the place number 0, the guy with 1 person in front takes the place number 1, and so on and so forth.
 
 This strategy could be used even in the case when not all people are of the same height. The smaller persons are "invisible" for the taller ones, and hence one could first arrange the tallest guys as if there was no one else.
 
        '''
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        people.sort( key = lambda x: (   -x[0] , x[1]  ) )
        op = [] 
        for p in people:
            op.insert( p[1] , p  )
        return op
