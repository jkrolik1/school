package SortingMethods;

public class QuickSort implements Sorting {
    @Override
    public void sorting(int[] arr,int start,int end) {
        int partition = partition(arr, start, end);

        if(partition-1>start) {
            sorting(arr, start, partition - 1);
        }
        if(partition+1<end) {
            sorting(arr, partition + 1, end);
        }
    }

    public int partition(int[] arr, int start, int end){
        int pivot = arr[end];

        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }

        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;

        return start;
    }


}
