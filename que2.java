Time Complexity (TC): O(n²), where n is the number of people. Sorting takes O(n log n), and inserting into the list in the worst case (for all elements) takes O(n²) due to shifting elements during insertion.
Space Complexity (SC): O(n), for the additional list used to store the reconstructed queue.

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // Sort the 'people' array.
        // Sort by height in descending order. If two people have the same height, sort by the number of people in front of them in ascending order.
        // This is because we want to place the tallest people first, and if two people have the same height, 
        // we want to respect the order defined by the number of people in front of them.
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0])  // If heights are the same, compare by k value (the number of people in front).
                return a[1] - b[1];  // Sort by k in ascending order.
            else {
                return b[0] - a[0];  // Sort by height in descending order.
            }
        });

        // Initialize a list to store the result of the reconstructed queue.
        List<int[]> res = new ArrayList<>();

        // Use induction to place each person in the correct position.
        // Since the list is sorted, we know that when we insert each person, 
        // all previously placed people are taller or have a higher number of people in front.
        for (int[] person : people) {
            // Insert the person at the index equal to their k value (the number of people in front).
            // This works because we are inserting taller people first, so the list will always have enough space 
            // to accommodate shorter people as we proceed.
            res.add(person[1], person);  // person[1] is the index where this person should be inserted.
        }

        // Convert the list to an array to match the return type.
        int[][] result = new int[people.length][people[0].length];
        for(int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }

        return result;
    }
}
