package task_1;

public class PowerOfTwoMaxHeap {
	
	private int[] heap;
	private int size;
	private int x; // x is the number of children
	
	public PowerOfTwoMaxHeap(int x) {
		this.x = x;
		this.heap = new int[10];
		this.size = 0;
	}
	
	// implementation of insert method
	public void insert(int value) {
		if(size == heap.length) {
			growArray();
		}
		heap[size] = value;
		size++;
		heapifyUp();
	}
	
	// implementaion of popMax method
	public int popMax() {
		int max = heap[0];
		heap[0] = heap[size -1];
		size--;
		heapifyDown();
		return max;
		
	}
	
	private void heapifyUp() {
		int index = size - 1;
		 while (index > 0 && heap[index] > heap[(index - 1) / 2]) {
	            int temp = heap[(index - 1) / 2];
	            heap[(index - 1) / 2] = heap[index];
	            heap[index] = temp;
	            index = (index - 1) / 2;
	        }
	}

	private void heapifyDown() {
		int index = 0;
        while (index < size) {
            int largestChildIndex = getLargestChildIndex(index);
            if (largestChildIndex == -1 || heap[index] > heap[largestChildIndex]) {
                break;
            }
            int temp = heap[index];
            heap[index] = heap[largestChildIndex];
            heap[largestChildIndex] = temp;
            index = largestChildIndex;
        }
		
	}

	private int getLargestChildIndex(int index) {
		int largestChildIndex = -1;
	    int firstChildIndex = (int) Math.pow(2, x) * index + 1;
	    if (firstChildIndex < size) {
	        largestChildIndex = firstChildIndex;
	        for (int i = 1; i < (int) Math.pow(2, x); i++) {
	            int childIndex = (int) Math.pow(2, x) * index + i + 1;
	            if (childIndex < size && heap[childIndex] > heap[largestChildIndex]) {
	                largestChildIndex = childIndex;
	            }
	        }
	    }
	    return largestChildIndex;
	}



	private void growArray() {
		int[] newHeap = new int[heap.length * 2];
        for (int i = 0; i < heap.length; i++) {
            newHeap[i] = heap[i];
        }
        heap = newHeap;
		
	}

	public static void main(String[] args) {
		PowerOfTwoMaxHeap heap = new PowerOfTwoMaxHeap(2);
		heap.insert(10);
		heap.insert(20);
		heap.insert(30);
		heap.insert(40);
		heap.insert(50);
		heap.insert(60);
		heap.insert(70);
		
		System.out.println(heap.popMax());
		System.out.println(heap.popMax());
		System.out.println(heap.popMax());
	}

}
