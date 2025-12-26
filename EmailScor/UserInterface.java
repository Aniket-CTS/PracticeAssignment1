package EmailSpanScoreAnalyzer;
import java.util.*;


public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
       /* if (!sc.hasNextInt()) {
        
            return;
        }*/
       System.err.println("Enter the number of emails ");
        int n = sc.nextInt();

     
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) {
            if (!sc.hasNextInt()) {
              
                return;
            }
            scores[i] = sc.nextInt();
            if (scores[i] < 0) {
                System.out.println("Negative scores are not allowed");
                return; 
            }
        }

     
        int[] modified = new int[n];
        for (int i = 0; i < n; i++) {
            int s = scores[i];
            if (s >= 50) {
                modified[i] = s + 10;
            } else {
                modified[i] = Math.max(s - 5, 0);
            }
        }

        Map<Integer, Integer> freq = new HashMap<>();
        for (int val : modified) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }


        long sum = 0;
        int uniqueCount = 0;
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            if (e.getValue() == 1) {
                sum += e.getKey();
                uniqueCount++;
            }
        }

        if (uniqueCount == 0) {
            System.out.println("No unique scores found after modification");
        } else {
            System.out.println(sum);
        }
      
        sc.close();
    }
     
}
