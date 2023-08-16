class Solution {
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {

            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        int[][] output = new int[people.length][people[0].length];

        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[0].length; j++) {
                output[i][j] = -1;
            }
        }

        for (int[] person : people) {

            int count = person[1];

            for (int[] op : output) {

                if ((op[0] == -1 && op[1] == -1) || op[0] >= person[0]) {
                    count--;
                }

                if (count == -1) {

                    op[0] = person[0];
                    op[1] = person[1];
                    break;
                }

            }
        }

        return output;
    }
}