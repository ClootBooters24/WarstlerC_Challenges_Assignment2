import java.util.*;

public class LEXISORT_Merge {
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

            mergeSort(lines, 0, lines.length - 1);

            for(int i = 0; i < lines.length; i++){
                System.out.println(lines[i]);
            }
        }
        scanner.close();
    }

    public static void mergeSort(String[] arr, int left, int right) {
        if(left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    
    public static void merge(String[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;
    
        String[] leftArray = new String[n1];
        String[] rightArray = new String[n2];
    
        for(int i = 0; i < n1; i++) {
            leftArray[i] = arr[left + i];
        }
    
        for(int i = 0; i < n2; i++) {
            rightArray[i] = arr[middle + 1 + i];
        }
    
        int i = 0, j = 0;
        int k = left;
    
        while(i < n1 && j < n2) {
            if(leftArray[i].compareTo(rightArray[j]) <= 0) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
    
        while(i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
    
        while(j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }
}