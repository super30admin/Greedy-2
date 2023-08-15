import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class PartitionLabels {

        // Greedy - greedily extend last index of a partition - Time O(n) and Space O(1)

        public List<Integer> partitionLabels(String s) {

            // result list
            List<Integer> partSizes = new ArrayList<>();

            if(s == null) return partSizes;

            HashMap<Character, Integer> charLastIdx = new HashMap<>();

            // build map of characters to their last indices by iterating over string s
            for(int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                charLastIdx.put(c, i);
            }

            // place pointers initially at zeroth indices
            int lastIdx = 0;
            int firstIdx = 0;

            // iterate over string s and make partitions
            for(int i = 0; i < s.length(); i++) {

                char c = s.charAt(i);

                // greedily extend last index of a partition
                lastIdx = Math.max(lastIdx, charLastIdx.get(c));

                // if last index of a partition becomes the last index of string s, iteration can be stopped
                if(lastIdx == s.length() - 1) {

                    partSizes.add(lastIdx - firstIdx + 1);

                    break;
                }

                // if iterator-i reaches last index of a partition, add length of that partition to result list
                if(i == lastIdx) {

                    partSizes.add(lastIdx - firstIdx + 1);

                    firstIdx = i + 1;
                }
            }
            // output
            return partSizes;
        }

        public static void main(String[] args) {

            PartitionLabels obj = new PartitionLabels();

            Scanner scanner = new Scanner(System.in);
            System.out.println("String: ");
            String s = scanner.nextLine();

            List<Integer> answer = obj.partitionLabels(s);
            for(int size: answer) {

                System.out.print( size + " ");
            }

        }

}

/*
TIME COMPLEXITY = O(n)

two iterations over string s - O(2n) = O(n)

SPACE COMPLEXITY = O(1)

hashmap of characters which are constant in space - O(1)
*/