import java.util.Scanner;
import java.util.Arrays;

public class MAIN8_C {
    public static void main(String[] args) {
        // Your code here
        Scanner scanner = new Scanner(System.in);
        int amtTests = scanner.nextInt();

        for(int i = 0; i < amtTests; i++) {
            int amtBoxes = scanner.nextInt();
            int amtStudents = scanner.nextInt();
            
            int[] candies = new int[amtBoxes];

            for(int j = 0; j < amtBoxes; j++) {
                candies[j] = scanner.nextInt();
            }
            
            distribute(amtBoxes, amtStudents, scanner);
        }

        scanner.close();
    }
}

static void distribute(int amtBoxes, int amtStudents, Scanner scanner) {
    int[] candies = new int[amtBoxes];
    int[] students = new int[amtStudents];

    for(int i = 0; i < amtBoxes; i++) {
        candies[i] = scanner.nextInt();
    }

    for(int i = 0; i < amtStudents; i++) {
        students[i] = scanner.nextInt();
    }

    int[] sortedCandies = candies.clone();
    Arrays.sort(sortedCandies);

    int[] sortedStudents = students.clone();
    Arrays.sort(sortedStudents);

    int[] candiesPerStudent = new int[amtStudents];
    int[] candiesPerBox = new int[amtBoxes];

    int j = 0;
    for(int i = 0; i < amtBoxes; i++) {
        candiesPerBox[i] = sortedCandies[i];
        if(i % amtStudents == 0) {
            candiesPerStudent[j] = sortedStudents[j];
            j++;
        }
    }

    int k = 0;
    for(int i = 0; i < amtBoxes; i++) {
        if(candiesPerBox[i] != candies[i]) {
            k++;
        }
    }

    System.out.println(k);
}