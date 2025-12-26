package LabTest;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LabTestInfo lab = new LabTestInfo();

        System.out.println("Enter the number of lab test details to be added");
        int n = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Enter lab test details (testName:cost)");
        for (int i = 0; i < n; i++) {
            String detail = sc.nextLine();
            try {
                lab.addTestDetails(detail);
            } catch (IllegalArgumentException e) {
                
                System.out.println(e.getMessage());
               
            }
        }

        System.out.println("Enter the minimum cost");
        int min = Integer.parseInt(sc.nextLine().trim());

        System.out.println("Enter the maximum cost");
        int max = Integer.parseInt(sc.nextLine().trim());

        List<String> filtered = null;
        try {
            filtered = lab.getTestsWithinGivenCostRange(min, max);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            sc.close();
            return;
        }

        if (filtered.isEmpty()) {
            System.out.println("No Tests found within the specified cost range");
        } else {
            System.out.println("Tests with cost between " + min + " and " + max + " INR:");
            for (String name : filtered) {
                System.out.println(name);
            }
        }

        sc.close();
    }
}
