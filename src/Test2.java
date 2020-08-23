import java.util.Arrays;

public class Test2 {

    //插入排序
    public void insertSort(int[] array){
        for (int bound = 1; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - 1;
            if (array[cur] > tmp){
                array[cur + 1] = array[cur];
            }else {
                break;
            }
            array[cur + 1] = tmp;
        }
    }



    //希尔排序
    public void shellSort(int[] array){
        int gap = array.length/2;
        while (gap > 1){
            shellSortHelp(array,gap);
            gap = gap / 2;
        }
        shellSortHelp(array,1);
    }

    private void shellSortHelp(int[] array, int gap) {
        for (int bound = gap; bound < array.length; bound++) {
            int tmp = array[bound];
            int cur = bound - gap;
            if (array[cur] > tmp){
                array[cur + 1 ] = array[cur];
            }else {
                break;
            }
            array[cur + gap] = array[cur];
        }
    }



    //选择排序
    public void selectSort(int[] array){
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = bound + 1; cur < array.length; cur++) {
                if (array[cur] < array[bound]){
                    swap(array,bound,cur);
                }
            }
        }
    }

    private static void swap(int[] array,int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }




    //冒泡排序
    public void bubbleSort(int[] array){
        for (int bound = 0; bound < array.length; bound++) {
            for (int cur = array.length - 1; cur > bound; cur--) {
                if (array[cur - 1] < array[cur]){
                    swap(array,cur - 1 ,cur);
                }
            }
        }
    }




    //快速排序
    public static void quickSort(int[] array){
        quickSortHelp(array,0,array.length - 1);
    }

    private static void quickSortHelp(int[] array, int left, int right) {
        if (left >= right){
            return;
        }
        int index = partition(array,left,right);
        quickSortHelp(array,left,index - 1);
        quickSortHelp(array,index + 1,right);
    }

    private static int partition(int[] array, int left, int right) {
        int baseValue = array[right];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && array[i] <= baseValue){
                i++;
            }
            while (i < j && array[j] >= baseValue){
                j--;
            }
            swap(array,i,j);
        }
        swap(array,i,right);
        return i;
    }




    //归并排序
    public static void mergeSort(int[] array){
        mergeSortHelp(array,0,array.length);
    }

    private static void mergeSortHelp(int[] array, int left, int right) {
        if (right - left <= 1){
            return;
        }
        int mid = (left + right) / 2;
        mergeSortHelp(array,left,mid);
        mergeSortHelp(array,mid,right);
        merge(array,left,mid,right);
    }

    private static void merge(int[] array, int left, int mid, int right) {
        int i = left;
        int j = mid;
        int[] output = new int[right - left];
        int index = 0;
        while (i < mid && j < right) {
            if (array[i] <= array[j]) {
                output[index] = array[i];
                index++;
                i++;
            } else {
                output[index] = array[j];
                index++;
                j++;
            }
        }

        while (i < mid){
            output[index] = array[i];
            i++;
            index++;
        }
        while (j < right){
            output[index] = array[j];
            j++;
            index++;
        }
        for (int tmp = 0; tmp < right - left; tmp++) {
            array[left + 1] = output[tmp];
        }
    }


    public static void main(String[] args) {
        int[] array = {5,9,7,6,1,45,3,2};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
