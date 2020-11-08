import SortingMethods.BubbleSort;
import SortingMethods.LibrarySort;
import SortingMethods.MergeSort;
import SortingMethods.QuickSort;

import java.util.ArrayList;
import java.util.Random;


public class main {
    public static void main(String[] args) {
        packOfTests();

    }


    // -------------------------------------------------------------------------------
    // ----------------------F-U-N-C-T-I-O-N-S----------------------------------------
    // -------------------------------------------------------------------------------


    static void packOfTests(){
        System.out.println("\n\n--- PROGRAM TESTS TIMES OF SORTING METHODS. EVERY METHOD IS TESTED BY 5 ARRAY WITH DIFFERENT SIZE " +
                "(ASCENDING). \n--- EVERY METHOD FOR EVERY ARRAY IS TESTED 10 TIMES AND THE TIME IS AVERAGE. -------------------------------" +
                "\n--- METHODS ARE PROVIDED BY ASCENDING TIME CALCULATION. --------------------------------------------------\n");

        System.out.println("\n--- MERGE SORT -------------------------------------------------------------------------------------------");
        mergeSortingAlgorithmTESTS(allExperimentTabs());

        System.out.println("\n--- LIBRARY SORT ---------------------------------------------------------------------------");
        librarySortingAlgorithmTESTS(allExperimentTabs());

        System.out.println("\n--- QUICK SORT ---------------------------------------------------------------------------");
        quickSortingAlgorithmTESTS(allExperimentTabs());

        System.out.println("\n--- BUBBLE SORT ----------------------------------------------------------------------------");
        bubbleSortingAlgorithmTESTS(allExperimentTabs());
    }


    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------


    static ArrayList<int[]> allExperimentTabs(){
        ArrayList<int[]> tabsTests = new ArrayList<int[]>();
        tabsTests.add(fillArrayRandomNumbers(50,1,1000));
        tabsTests.add(fillArrayRandomNumbers(500,1,1000));
        tabsTests.add(fillArrayRandomNumbers(5000,1,1000));
        tabsTests.add(fillArrayRandomNumbers(50000,1,1000));
        tabsTests.add(fillArrayRandomNumbers(500000,1,1000));
        return tabsTests;
    }


    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------


    static void quickSortingAlgorithmTESTS(ArrayList<int[]> tabs){
        int counter = 1, elements = 50;
        for(int[] x : tabs){
            quickSortingAlgorithm(x,counter,elements);
            counter += 1;
            elements *= 10;
        }
    }

    static void quickSortingAlgorithm(int[] arr,int num,int arrSize){
        Algorithm quickAlgorithm = new Algorithm();

        quickAlgorithm.setSorting(new QuickSort());

        double estimatedTime = quickAlgorithm.averageEstimateTime(quickAlgorithm,arr,0,arr.length-1);

        System.out.print(num + ". For array size = " + arrSize  + "  average estimate time is: ");
        System.out.print("approx. " + (double)Math.round(estimatedTime/1000000 * 100d) / 100d + " milisec");
        System.out.println(" =  approx. " +  (double)Math.round(estimatedTime/1000000000 * 100d) / 100d + " sec");
    }


    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------


    static void mergeSortingAlgorithmTESTS(ArrayList<int[]> tabs){
        int counter = 1, elements = 50;
        for(int[] x : tabs){
            mergeSortingAlgorithm(x,counter,elements);
            counter += 1;
            elements *= 10;
        }
    }

    static void mergeSortingAlgorithm(int[] arr,int num,int arrSize){
        Algorithm mergeAlgorithm = new Algorithm();

        mergeAlgorithm.setSorting(new MergeSort());

        double estimatedTime = mergeAlgorithm.averageEstimateTime(mergeAlgorithm,arr,0,arr.length-1);

        System.out.print(num + ". For array size = " + arrSize  + "  average estimate time is: ");
        System.out.print((long)estimatedTime + " nanosec");
        System.out.print(" =  approx. " + (double)Math.round(estimatedTime/1000000 * 100d) / 100d + " milisec");
        System.out.println(" =  approx. " +  (double)Math.round(estimatedTime/1000000000 * 100d) / 100d + " sec");
    }


    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------


    static void librarySortingAlgorithmTESTS(ArrayList<int[]> tabs){
        int counter = 1, elements = 50;
        for(int[] x : tabs){
            librarySortingAlgorithm(x,counter,elements);
            counter += 1;
            elements *= 10;
        }
    }

    static void librarySortingAlgorithm(int[] arr,int num,int arrSize){
        Algorithm libraryAlgorithm = new Algorithm();

        libraryAlgorithm.setSorting(new LibrarySort());

        double estimatedTime = libraryAlgorithm.averageEstimateTime(libraryAlgorithm,arr,0,arr.length-1);

        System.out.print(num + ". For array size = " + arrSize  + "  average estimate time is: ");
        System.out.print("approx. " + (double)Math.round(estimatedTime/1000000 * 100d) / 100d + " milisec");
        System.out.println(" =  approx. " +  (double)Math.round(estimatedTime/1000000000 * 100d) / 100d + " sec");
    }


    // -------------------------------------------------------------------------------
    // -------------------------------------------------------------------------------


    static void bubbleSortingAlgorithmTESTS(ArrayList<int[]> tabs){
        int counter = 1, elements = 50;
        for(int[] x : tabs){
            bubbleSortingAlgorithm(x,counter,elements);
            counter += 1;
            elements *= 10;
        }
    }

    static void bubbleSortingAlgorithm(int[] arr,int num,int arrSize){
        Algorithm bubbleAlgorithm = new Algorithm();

        bubbleAlgorithm.setSorting(new BubbleSort());

        double estimatedTime = bubbleAlgorithm.averageEstimateTime(bubbleAlgorithm,arr,0,arr.length-1);

        System.out.print(num + ". For array size = " + arrSize  + "  average estimate time is: ");
        System.out.print("approx. " + (double)Math.round(estimatedTime/1000000 * 100d) / 100d + " milisec");
        System.out.println(" =  approx. " +  (double)Math.round(estimatedTime/1000000000 * 100d) / 100d + " sec");
    }


    // -------------------------------------------------------------------------------


    static int[] fillArrayRandomNumbers(int amountOfElements,int min,int max){
        Random rand = new Random();
        int[] returnArray = new int[amountOfElements];

        for(int i=0; i<amountOfElements; ++i)
            returnArray[i] = rand.nextInt(max-min+1)+min;

        return returnArray;
    }

    static void printArray(int[] arr){
        for(int p=0; p<arr.length; ++p){
            System.out.print(arr[p] + " ");
        }
    }
}
