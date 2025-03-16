class Solution {
        //Time Complexity:O(n^2)
        //Space Complexity:O(n)
        public int[][] reconstructQueue(int[][] people) {
        if (people == null ||people.length ==0) {
            return null;
        }

        Arrays.sort(people, (a,b) -> {
            if (a[0] == b[0]){
                return a[1]-b[1];
            }
            return b[0] - a[0];
        });
        List<int[]> res = new ArrayList<>();

        for (int i =0;i < people.length;i++){
                res.add (people[i][1], people[i]);
        }
        return res.toArray(new int[][] {}); 
        }
    }
