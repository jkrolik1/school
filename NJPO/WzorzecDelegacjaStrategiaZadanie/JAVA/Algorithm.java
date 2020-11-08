import SortingMethods.Sorting;

public class Algorithm {
    public void doAlgorithm(int[] arr,int start,int end) {
        sorting.sorting(arr,start,end);
    }
    public void setSorting(Sorting s)   { sorting = s; }
    public double estimatedTime(Algorithm alg,int[] arr,int start,int end){
        double startTime = System.nanoTime();
            alg.doAlgorithm(arr,start,end);
        double estimatedTime = System.nanoTime() - startTime;

        return estimatedTime;
    }
    public double averageEstimateTime(Algorithm alg,int[] arr,int start,int end){
        double sum = 0, average = 0, current = 0;

        for(int i=0; i<10; ++i){
            current = estimatedTime(alg,arr,start,end);
            sum += current;
            //System.out.println(i+1 + ". " + current + " nanosec");
        }

        average = sum/10;

        return average;

    }

    private Sorting sorting;
};
