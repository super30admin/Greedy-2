// Time Complexity : 0(n)
// Space Complexity : 0(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

    func partitionLabels(_ s: String) -> [Int] {
       if s == nil || s.count == 0 {
           return []
       } 
        var hashmap = [Character:Int]()
        var output = [Int]()
        var sArray = Array(s)
        for i in 0..<s.count {
            hashmap[sArray[i]] = i
        }
        var start = 0
        var end = hashmap[sArray[0]]! 
        for i in 0..<s.count {
             if hashmap[sArray[i]]! > end  {
                 end = hashmap[sArray[i]]!
             }
             if end == i {
                 output.append(end - start + 1)
                 start = end + 1
             }
        }
        return output
    }
