import java.util.*;

public class LEXISORT_Quick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amtTests = scanner.nextInt();

        while(amtTests-- > 0){
            int amtLines = scanner.nextInt();
            scanner.nextLine();
            String[] lines = new String[amtLines];
            
            for(int i = 0; i < amtLines; i++){
                lines[i] = scanner.nextLine();
            }

            quickSort(lines, 0, amtLines - 1);

            for(int i = 0; i < lines.length; i++){
                System.out.println(lines[i]);
            }
        }
        scanner.close();
    }

    public static void quickSort(String[] arr, int low, int high) {
        if(low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(String[] arr, int low, int high) {
        String pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j].compareTo(pivot) < 0) {
                i++;
                String temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        String temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
