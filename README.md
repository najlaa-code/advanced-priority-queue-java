# Advanced Priority Queue (APQ) Implementation

An implementation of an Advanced Priority Queue in Java with dynamic min-heap/max-heap toggling capabilities. 

## Overview

This project implements a feature-rich priority queue data structure that extends traditional heap functionality with advanced operations including:
- **Dynamic heap mode switching** between min-heap and max-heap
- **Flexible key/value updates** with automatic heap restructuring
- **Efficient merging** of multiple priority queues
- **Position-based access** via `peekAt()` for k-th smallest/largest elements
- **Generic type support** for comparable keys and arbitrary values

## Project Structure
```
APQImplementation/
├── APQ.java                    # Main APQ implementation
├── PriorityQueue.java          # Priority queue interface
├── Entry.java                  # Key-value entry interface
├── AbstractPriorityQueue.java  # Abstract base class
├── HeapPriorityQueue.java      # Standard heap implementation
├── DynamicArray.java           # Resizable array structure
├── DefaultComparator.java      # Default comparison logic
└── APQTest.java                # Comprehensive test suite
```

## Features

### Core Operations
- `insert(K key, V value)` - O(log n) insertion with automatic heap maintenance
- `removeTop()` - O(log n) removal of min/max element depending on mode
- `top()` - O(1) access to highest priority element
- `toggle()` - O(n) switch between min-heap and max-heap modes
- `merge(APQ other)` - O(n) merge two priority queues

### Advanced Operations
- `replaceKey(Entry e, K newKey)` - Update key with automatic repositioning
- `replaceValue(Entry e, V newValue)` - Update value without affecting heap structure
- `remove(Entry e)` - Remove arbitrary entry from heap
- `peekAt(int i)` - Access i-th smallest (min-heap) or largest (max-heap) element

### Utility Methods
- `size()` - Current number of elements
- `isEmpty()` - Check if queue is empty
- `state()` - Returns current mode ("min" or "max")

## Implementation Details

### Data Structure
- **Underlying storage**: Custom `DynamicArray<K,V>` with automatic resizing
- **Initial capacity**: 10 elements (doubles when full)
- **Heap property**: Maintained through `upheap()` and `downheap()` operations

### Heap Operations
- **Upheap**: Restores heap property after insertion or key decrease
- **Downheap**: Restores heap property after removal or key increase
- **Toggle**: Rebuilds entire heap structure in O(n) time

## Usage Examples

### Basic Min-Heap Operations
```java
APQ<Integer, String> minHeap = new APQ<>();

// Insert elements
minHeap.insert(10, "Ten");
minHeap.insert(5, "Five");
minHeap.insert(15, "Fifteen");

// Access minimum
System.out.println(minHeap.top().getKey());  // Output: 5

// Remove minimum
Entry<Integer, String> min = minHeap.removeTop();
System.out.println(min.getValue());  // Output: "Five"
```

### Switching to Max-Heap
```java
APQ<Integer, String> heap = new APQ<>();
heap.insert(25, "TwentyFive");
heap.insert(15, "Fifteen");
heap.insert(35, "ThirtyFive");

System.out.println(heap.state());  // Output: "min"
System.out.println(heap.top().getKey());  // Output: 15

heap.toggle();

System.out.println(heap.state());  // Output: "max"
System.out.println(heap.top().getKey());  // Output: 35
```

### Dynamic Key Updates
```java
APQ<Integer, String> heap = new APQ<>();
Entry<Integer, String> entry = heap.insert(50, "Fifty");
heap.insert(30, "Thirty");

// Replace key (triggers automatic repositioning)
heap.replaceKey(entry, 10);
System.out.println(heap.top().getKey());  // Output: 10
```

### Merging Priority Queues
```java
APQ<Integer, String> heapA = new APQ<>();
heapA.insert(10, "Ten");
heapA.insert(20, "Twenty");

APQ<Integer, String> heapB = new APQ<>();
heapB.insert(5, "Five");
heapB.insert(15, "Fifteen");

heapA.merge(heapB);
System.out.println(heapA.size());  // Output: 4
System.out.println(heapA.top().getKey());  // Output: 5
```

### Accessing K-th Element
```java
APQ<Integer, String> heap = new APQ<>();
heap.insert(50, "Fifty");
heap.insert(20, "Twenty");
heap.insert(70, "Seventy");
heap.insert(10, "Ten");

System.out.println(heap.peekAt(1).getKey());  // Output: 10 (1st smallest)
System.out.println(heap.peekAt(2).getKey());  // Output: 20 (2nd smallest)
System.out.println(heap.peekAt(3).getKey());  // Output: 50 (3rd smallest)
```

## Testing

The project includes comprehensive test cases (`APQTest.java`) covering:

- Basic insertion and removal operations
- Min-heap and max-heap modes
- Key and value replacement
- Entry removal from various positions
- Heap merging scenarios
- Array resizing with 25+ elements
- Edge cases (empty heap, single element)
- Stress testing with 50+ operations
- String keys for lexicographic ordering

Run tests:
```bash
javac APQImplementation/*.java
java APQImplementation.APQTest
```

## Time Complexity

| Operation | Average Case | Worst Case |
|-----------|-------------|------------|
| insert() | O(log n) | O(log n) |
| removeTop() | O(log n) | O(log n) |
| top() | O(1) | O(1) |
| replaceKey() | O(log n) | O(log n) |
| replaceValue() | O(1) | O(1) |
| remove() | O(log n) | O(log n) |
| toggle() | O(n) | O(n) |
| merge() | O(n) | O(n) |
| peekAt() | O(n) | O(n) |

## Requirements
Java 8 or higher

## Author
Najlaa Achouhal
