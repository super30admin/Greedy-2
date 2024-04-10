//TimeComplexity : O(n2)


class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a,b)-> {
            if(a[0] == b[0]) {
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });

        List<int []> queue = new ArrayList<>();
        for(int []person: people) {
            queue.add(person[1], person);
        }
        int [][]result = new int[people.length][2];
        for(int i =0; i<people.length;i++) {
            result[i] = queue.get(i);
        }
        return result;
    }
}