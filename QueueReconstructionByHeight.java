class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }

        int n = people.length;

        Arrays.sort(people, (x, y) -> {
            if (x[0] == y[0]) {
                return x[1] - y[1];
            } else {
                return y[0] - x[0];
            }
        });

        List<int[]> list = new ArrayList<>(); // looks better to use than LinkedList as ArrayList is heavily optimized in JVM

        for (int[] p : people) {
            list.add(p[1], p);
        }

        int result[][] = new int[list.size()][];

        for (int i = 0; i < list.size(); ++i) {
            result[i] = list.get(i);
        }

        return result;
        
    }
}