// Time Complexity : 0(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func reconstructQueue(_ people: [[Int]]) -> [[Int]] {
        let people = people.sorted { (person1,person2) in 
                if person1[0] == person2[0] {
                    return person1[1] < person2[1]
                }
          return person1[0] > person2[0]
        }
        var output = [[Int]]()
        for person in people {
            output.insert(person,at: person[1])
        }
        return output
    }
