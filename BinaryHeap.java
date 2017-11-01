import java.util.Arrays;

public class BinaryHeap {
	private int[] arr;
	private int size;
	
	public BinaryHeap() {
		arr = new int[10];
	}
	
	public void add(int priority) {
		if (arr.length == size) {
			grow_heap();
		}
		arr[size++] = priority;
		int index = size - 1;
		while (index > 0 && arr[index] < arr[parent(index)]) {
			swap(index, parent(index));
			index = parent(index);
		}
	}
	
	public int remove() {
		int temp = arr[0];
		arr[0] = arr[--size];
		bubble_down(0);
		return temp;
	}
	
	public void bubble_down(int index) {
		if (left_child(index) < size) {
			int child = left_child(index);
			if (right_child(index) < size && 
				arr[right_child(index)] < arr[child]) {
					child = right_child(index);
			}
			if (arr[index] > arr[child]) {
				swap(index, child);
			}
			bubble_down(child);
		}
	}
	
	public int parent(int index) {
		return (index - 1) / 2;
	}
	
	public int left_child(int index) {
		return index * 2 + 1;
	}
	
	public int right_child(int index) {
		return index * 2 + 2;
	}
	
	public void swap(int index, int parent) {
		int temp = arr[index];
		arr[index] = arr[parent];
		arr[parent] = temp;
	}
	
	public void grow_heap() {
		arr = Arrays.copyOf(arr, arr.length * 2);
	}
	
}
