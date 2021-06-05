class Solution:
    def reconstructQueue(self, people: List[List[int]]) -> List[List[int]]:
        
        if not people :
            return []

        people = sorted(people,key=lambda x:(-x[0],x[1]))   
        #people = sorted(people, reverse=True)
        print(people)
        output = []
        for person in people:
            #print(output)
            output.insert(person[1],person)
        return output
