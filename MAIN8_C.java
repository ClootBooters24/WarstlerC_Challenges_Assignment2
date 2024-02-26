import java.util.*;

public class MAIN8_C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amtTests = scanner.nextInt();

        for(int i = 0; i < amtTests; i++) {
            int amtBoxes = scanner.nextInt();
            int amtStudents = scanner.nextInt();
            int[] candiesInBox = new int[amtBoxes];

            for(int j = 0; j < amtBoxes; j++) {
                candiesInBox[j] = scanner.nextInt();
            }

            //Sort the boxes in ascending order
            Arrays.sort(candiesInBox);

            int maxCandies = Integer.MIN_VALUE;
            int totalCandies = 0;

            for(int j = amtBoxes - 1; j >= 0 && amtStudents > 0; j--) {
                // maxCandies = Math.max(maxCandies, candiesInBox[j]);
                // amtStudents--;

                //Get total amount of candies
                totalCandies += candiesInBox[j];
                
                //Calculate average candies per student from remaining boxes
                int avgCandies = totalCandies / (amtBoxes - j);
                maxCandies = Math.max(maxCandies, avgCandies);
                amtStudents--;
            }

            System.out.println(maxCandies);
        }
        scanner.close();
    }
}