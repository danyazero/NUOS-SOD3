package priorityQueue;

import java.util.Arrays;

public class MyPriorityQueue implements PriorityQueueProcessor{
    private int[] data = new int[10];
    private int size = 0;
    public void sort() {
        int n = size;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(data, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = data[0];
            data[0] = data[i];
            data[i] = temp;

            // Heapify root element
            heapify(data, i, 0);
        }

    }

    @Override
    public void add(int value) {
        ensureCapacity(size+1);
        data[size++] = value;
        sort();
    }

    void heapify(int arr[], int size, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && arr[left] > arr[largest])
            largest = left;

        if (right < size && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, size, largest);
        }
    }

    public int remove() {
        int result = data[0];
        data[0] = data[--size];
        sort();
        return result;
    }

    private void ensureCapacity(int size){
        if (data.length < size){
            data = Arrays.copyOf(data, data.length+10);
        }
    }


    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

}