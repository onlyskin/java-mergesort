import junit.framework.TestCase;
import java.util.Arrays;

public class MergeSorterTest extends TestCase {
    private MergeSorter sorter;

    protected void setUp() throws Exception {
        sorter = new MergeSorter();
    }

    public void testItSorts3_1() throws Exception {
        int[] input = new int[]{3, 1};
        int[] output = sorter.sortTwoElementArray(input);
        int[] expected = new int[]{1, 3};
        assertTrue(Arrays.equals(expected, output));
    }

    public void testItSorts1_4() throws Exception {
        int[] input = new int[]{1, 4};
        int[] output = sorter.sortTwoElementArray(input);
        int[] expected = new int[]{1, 4};
        assertTrue(Arrays.equals(expected, output));
    }

    public void testItSorts1_1() throws Exception {
        int[] input = new int[]{1, 1};
        int[] output = sorter.sortTwoElementArray(input);
        int[] expected = new int[]{1, 1};
        assertTrue(Arrays.equals(expected, output));
    }

    public void testItSplits4ElementArray() throws Exception {
        int[] input = new int[]{1, 2, 3, 4};
        int[][] output = sorter.splitArray(input);
        int[][] expected = new int[][]{new int[]{1, 2}, new int[]{3, 4}};
        assertTrue(Arrays.equals(expected[0], output[0]));
        assertTrue(Arrays.equals(expected[1], output[1]));
    }

    public void testItSplits6ElementArray() throws Exception {
        int[] input = new int[]{1, 2, 3, 4, 5, 6};
        int[][] output = sorter.splitArray(input);
        int[][] expected = new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}};
        assertTrue(Arrays.equals(expected[0], output[0]));
        assertTrue(Arrays.equals(expected[1], output[1]));
    }

    public void testItSplits5ElementArray() throws Exception {
        int[] input = new int[]{1, 2, 3, 4, 5};
        int[][] output = sorter.splitArray(input);
        int[][] expected = new int[][]{new int[]{1, 2}, new int[]{3, 4, 5}};
        assertTrue(Arrays.equals(expected[0], output[0]));
        assertTrue(Arrays.equals(expected[1], output[1]));
    }

    public void testItSplits3ElementArray() throws Exception {
        int[] input = new int[]{1, 2, 3};
        int[][] output = sorter.splitArray(input);
        int[][] expected = new int[][]{new int[]{1}, new int[]{2, 3}};
        assertTrue(Arrays.equals(expected[0], output[0]));
        assertTrue(Arrays.equals(expected[1], output[1]));
    }

    public void testItMergesSingleItemArrays() throws Exception {
        int[] i1 = new int[]{1};
        int[] i2 = new int[]{1};
        int[] output = sorter.mergeSortedArrays(i1, i2);
        int[] expected = new int[]{1, 1};
        assertTrue(Arrays.equals(expected, output));
    }

    public void testItMergesTwoItemArrays() throws Exception {
        int[] i1 = new int[]{1, 2};
        int[] i2 = new int[]{2, 3};
        int[] output = sorter.mergeSortedArrays(i1, i2);
        int[] expected = new int[]{1, 2, 2, 3};
        assertTrue(Arrays.equals(expected, output));
    }

    public void testItMergesThreeItemArrays() throws Exception {
        int[] i1 = new int[]{3, 4, 6};
        int[] i2 = new int[]{5, 7, 8};
        int[] output = sorter.mergeSortedArrays(i1, i2);
        int[] expected = new int[]{3, 4, 5, 6, 7, 8};
        assertTrue(Arrays.equals(expected, output));
    }

    public void testItMergesDiffLengthItemArrays() throws Exception {
        int[] i1 = new int[]{3, 9};
        int[] i2 = new int[]{1, 8, 10};
        int[] output = sorter.mergeSortedArrays(i1, i2);
        int[] expected = new int[]{1, 3, 8, 9, 10};
        assertTrue(Arrays.equals(expected, output));
    }

    public void test1ElementMergeSort() throws Exception {
        int[] input = new int[]{1};
        int[] output = sorter.mergeSort(input);
        int[] expected = new int[]{1};
        assertTrue(Arrays.equals(expected, output));
    }

    public void test2ElementMergeSort() throws Exception {
        int[] input = new int[]{3, 1};
        int[] output = sorter.mergeSort(input);
        int[] expected = new int[]{1, 3};
        assertTrue(Arrays.equals(expected, output));
    }

    public void test3ElementMergeSort() throws Exception {
        int[] input = new int[]{3, 0, -5};
        int[] output = sorter.mergeSort(input);
        int[] expected = new int[]{-5, 0, 3};
        assertTrue(Arrays.equals(expected, output));
    }

    public void test5ElementMergeSort() throws Exception {
        int[] input = new int[]{3, 1, 5, 2, 9};
        int[] output = sorter.mergeSort(input);
        int[] expected = new int[]{1, 2, 3, 5, 9};
        assertTrue(Arrays.equals(expected, output));
    }

    public void test0ElementMergeSort() throws Exception {
        int[] input = new int[]{};
        int[] output = sorter.mergeSort(input);
        int[] expected = new int[]{};
        assertTrue(Arrays.equals(expected, output));
    }
}
