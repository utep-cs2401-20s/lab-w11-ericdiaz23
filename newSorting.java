import java.util.Arrays;

class Main {
  public static void main(String[] args) {
  }

  public static void newSorting(int[] a, int size){
    if(a.length <= size){
        quickSort(a, 0, a.length);
    }
    else{
      int[] leftH = Arrays.copyOfRange(a, 0, (a.length+1)/2);
      int[] rightH = Arrays.copyOfRange(a, (a.length+1)/2, a.length);
      newSorting(leftH, leftH.length);
      newSorting(rightH, rightH.length);
      mergeSortedHalves(leftH, rightH);
    }
  }


  public static int partition(int[] a, int leftPointer, int rightPointer){
    int pivot = a[rightPointer];
    int i = leftPointer - 1;
    for(int j = leftPointer; j < rightPointer; j++){
      if(a[j] < pivot){
        i++;
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
      }
    }
    int temp = a[i+1];
    a[i+1] = a[rightPointer];
    a[rightPointer] = temp;
    return i+1;
  }

  public static void quickSort(int[] a, int leftPointer, int rightPointer){
    if(leftPointer < rightPointer){
      int pi = partition(a, leftPointer, rightPointer);
      quickSort(a, leftPointer, pi-1);
      quickSort(a, pi+1, rightPointer);
    }
  }

  public static int[] mergeSortedHalves(int[] leftH, int[] rightH){
    int[] merged = new int[leftH.length+rightH.length];
    int j = 0;
    for(int i = 0; i < merged.length; i++){
      if(i < leftH.length){
        merged[i] = leftH[i];
      }
      else{
        merged[i] = rightH[j];
        j++;
      }
    }
    return merged;
  }
