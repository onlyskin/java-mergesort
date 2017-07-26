public class MergeSorter {
    public int[] sortTwoElementArray(int[] input) {
        if (input[0] < input[1]) {
            return new int[]{input[0], input[1]};
        } else {
            return new int[]{input[1], input[0]};
        }
    }

    public int[][] splitArray(int[] input) {
        int length = input.length;
        int midpoint = input.length / 2;
        int[] firstHalf = new int[midpoint];
        int[] secondHalf = new int[length-midpoint];
        for (int i=0; i<input.length; i++) {
           if (i < midpoint) {
               firstHalf[i] = input[i];
           } else {
               secondHalf[i-midpoint] = input[i];
           }
        }
        return new int[][]{firstHalf, secondHalf};
    }

    public int[] mergeSortedArrays(int[] array1, int[] array2) {
        int i = 0;
        int j = 0;
        int[] output = new int[array1.length + array2.length];
        int m = 0;
        while (i < array1.length || j < array2.length) {
            if (i >= array1.length) {
                output[m] = array2[j];
                j++;
            } else if (j >= array2.length) {
                output[m] = array1[i];
                i++;
            } else if (array1[i] < array2[j]) {
                output[m] = array1[i];
                i++;
            } else {
                output[m] = array2[j];
                j++;
            }
            m++;
        }
        return output;
    }

    public int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        } else if (array.length == 2) {
            return sortTwoElementArray(array);
        } else {
            int[][] divided = splitArray(array);
            int[] a1 = divided[0];
            int[] a2 = divided[1];
            int[] sorted_a1 = mergeSort(a1);
            int[] sorted_a2 = mergeSort(a2);
            int[] merged = mergeSortedArrays(sorted_a1, sorted_a2);
            return merged;
        }
    }
}
