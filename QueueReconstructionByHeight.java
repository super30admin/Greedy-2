//Time Complexity - O(n^2)
//Space Complexity - O(1)
class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return new int[][] {};
        }

        int[][] queue = new int[people.length][2];

        Arrays.sort(people, (a,b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });

        queue[0][0] = people[0][0];
        queue[0][1] = people[0][1];

        for(int i=1; i<people.length; i++){
            moveElements(queue, people, i);
        }

        return queue;
    }

    private void moveElements(int[][] queue, int[][] people, int i){
        int start = people[i][1];
        int end = i;
        for(int j=end; j>start; j--){
            queue[j][0] = queue[j-1][0];
            queue[j][1] = queue[j-1][1];
        }
        queue[start][0] = people[i][0];
        queue[start][1] = people[i][1];
    }
}
