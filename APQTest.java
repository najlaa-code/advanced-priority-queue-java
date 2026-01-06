package APQImplementation;
public class APQTest {
    
    public static void main(String[] args) {
        System.out.println("=== Advanced Priority Queue (APQ) Test Cases ===\n");
        
        int testNumber = 1;
        
        //test 1: basic insert and state check (min-heap mode)
        System.out.println("TEST " + testNumber++ + ": Basic insert and state check");
      
        APQ<Integer, String> apq1 = new APQ<>();
        
        System.out.println("Initial state: " + apq1.state());
      
        apq1.insert(10, "Ten");
        apq1.insert(5, "Five");
        apq1.insert(15, "Fifteen");
      
        System.out.println("After inserts - Top: " + apq1.top().getKey() + " -> " + apq1.top().getValue());
        System.out.println("Size: " + apq1.size());
        System.out.println("Is empty: " + apq1.isEmpty());
        System.out.println();
        
        //test 2: removetop in min-heap mode
        System.out.println("TEST " + testNumber++ + ": RemoveTop in Min-Heap mode");
      
        APQ<Integer, String> apq2 = new APQ<>();
      
        apq2.insert(20, "Twenty");
        apq2.insert(10, "Ten");
        apq2.insert(30, "Thirty");
        apq2.insert(5, "Five");
      
        System.out.println("Before removal - Top: " + apq2.top().getKey());
      
        Entry<Integer, String> removed = apq2.removeTop();
      
        System.out.println("Removed: " + removed.getKey() + " -> " + removed.getValue());
        System.out.println("After removal - Top: " + apq2.top().getKey());
        System.out.println();
        
        //test 3: toggle from min to max
        System.out.println("TEST " + testNumber++ + ": Toggle from Min to Max");
      
        APQ<Integer, String> apq3 = new APQ<>();
      
        apq3.insert(25, "TwentyFive");
        apq3.insert(15, "Fifteen");
        apq3.insert(35, "ThirtyFive");
        apq3.insert(10, "Ten");
      
        System.out.println("Min-Heap state: " + apq3.state());
        System.out.println("Top before toggle: " + apq3.top().getKey());
      
        apq3.toggle();
      
        System.out.println("Max-Heap state: " + apq3.state());
        System.out.println("Top after toggle: " + apq3.top().getKey());
        System.out.println();
        
        //test 4: removetop in max-heap mode
        System.out.println("TEST " + testNumber++ + ": RemoveTop in Max-Heap mode");
      
        APQ<Integer, String> apq4 = new APQ<>();
      
        apq4.insert(40, "Forty");
        apq4.insert(20, "Twenty");
        apq4.insert(60, "Sixty");
        apq4.toggle(); //switch to max-heap
      
        System.out.println("State: " + apq4.state());
        System.out.println("Top before removal: " + apq4.top().getKey());
      
        Entry<Integer, String> maxRemoved = apq4.removeTop();
      
        System.out.println("Removed: " + maxRemoved.getKey());
        System.out.println("Top after removal: " + apq4.top().getKey());
        System.out.println();
        
        //test 5: replacekey with upheap
        System.out.println("TEST " + testNumber++ + ": ReplaceKey (triggering upheap)");
      
        APQ<Integer, String> apq5 = new APQ<>();
        Entry<Integer, String> e1 = apq5.insert(50, "Fifty");
        apq5.insert(30, "Thirty");
        apq5.insert(70, "Seventy");
        System.out.println("Before replaceKey - Top: " + apq5.top().getKey());
        Integer oldKey = apq5.replaceKey(e1, 10);
      
        System.out.println("Replaced key " + oldKey + " with 10");
        System.out.println("After replaceKey - Top: " + apq5.top().getKey());
        System.out.println();
        
        //test 6: replacekey with downheap
        System.out.println("TEST " + testNumber++ + ": ReplaceKey (triggering downheap)");
      
        APQ<Integer, String> apq6 = new APQ<>();
        apq6.insert(10, "Ten");
        Entry<Integer, String> e2 = apq6.insert(20, "Twenty");
        apq6.insert(30, "Thirty");
        apq6.insert(15, "Fifteen");
      
        System.out.println("Before replaceKey - Entry at position has key: " + e2.getKey());
        apq6.replaceKey(e2, 100);
        System.out.println("After replaceKey to 100");
        System.out.println("Top: " + apq6.top().getKey());
        System.out.println();
        
        //test 7: replacevalue
        System.out.println("TEST " + testNumber++ + ": ReplaceValue");
      
        APQ<Integer, String> apq7 = new APQ<>();
        Entry<Integer, String> e3 = apq7.insert(25, "OriginalValue");
        System.out.println("Original value: " + e3.getValue());
        String oldValue = apq7.replaceValue(e3, "NewValue");
      
        System.out.println("Old value returned: " + oldValue);
        System.out.println("New value: " + e3.getValue());
        System.out.println();
        
        //test 8: remove specific entry (middle of heap)
        System.out.println("TEST " + testNumber++ + ": Remove specific entry");
      
        APQ<Integer, String> apq8 = new APQ<>();
        apq8.insert(10, "Ten");
        Entry<Integer, String> e4 = apq8.insert(20, "Twenty");
        apq8.insert(30, "Thirty");
        apq8.insert(5, "Five");
        System.out.println("Before removal - Size: " + apq8.size());
        Entry<Integer, String> removedEntry = apq8.remove(e4);
      
        System.out.println("Removed entry with key: " + removedEntry.getKey());
        System.out.println("After removal - Size: " + apq8.size());
        System.out.println();
        
        //test 9: peekat various positions
        System.out.println("TEST " + testNumber++ + ": PeekAt various positions");
      
        APQ<Integer, String> apq9 = new APQ<>();
        apq9.insert(50, "Fifty");
        apq9.insert(20, "Twenty");
        apq9.insert(70, "Seventy");
        apq9.insert(10, "Ten");
        apq9.insert(30, "Thirty");
      
        System.out.println("1st smallest: " + apq9.peekAt(1).getKey());
        System.out.println("2nd smallest: " + apq9.peekAt(2).getKey());
        System.out.println("3rd smallest: " + apq9.peekAt(3).getKey());
        System.out.println("4th smallest: " + apq9.peekAt(4).getKey());
        System.out.println("5th smallest: " + apq9.peekAt(5).getKey());
        System.out.println();
        
        //test 10: peekat in max-heap mode
        System.out.println("TEST " + testNumber++ + ": PeekAt in Max-Heap mode");
      
        APQ<Integer, String> apq10 = new APQ<>();
        apq10.insert(40, "Forty");
        apq10.insert(20, "Twenty");
        apq10.insert(60, "Sixty");
        apq10.insert(10, "Ten");
        apq10.toggle(); //switch to max-heap
      
        System.out.println("State: " + apq10.state());
        System.out.println("1st largest: " + apq10.peekAt(1).getKey());
        System.out.println("2nd largest: " + apq10.peekAt(2).getKey());
        System.out.println("3rd largest: " + apq10.peekAt(3).getKey());
        System.out.println();
        
        //test 11: merge two apqs (both min-heaps)
        System.out.println("TEST " + testNumber++ + ": Merge two min-heaps");
        APQ<Integer, String> apqA = new APQ<>();
        apqA.insert(10, "Ten");
        apqA.insert(20, "Twenty");
        apqA.insert(30, "Thirty");
        
        APQ<Integer, String> apqB = new APQ<>();
        apqB.insert(5, "Five");
        apqB.insert(15, "Fifteen");
        apqB.insert(25, "TwentyFive");
        
        System.out.println("APQ A size before merge: " + apqA.size());
        System.out.println("APQ B size: " + apqB.size());
        apqA.merge(apqB);
        System.out.println("APQ A size after merge: " + apqA.size());
        System.out.println("APQ A top after merge: " + apqA.top().getKey());
        System.out.println();
        
        //test 12: merge with empty apq
        System.out.println("TEST " + testNumber++ + ": Merge with empty APQ");
        APQ<Integer, String> apqC = new APQ<>();
        apqC.insert(100, "Hundred");
        apqC.insert(200, "TwoHundred");
        
        APQ<Integer, String> apqD = new APQ<>();
        
        System.out.println("APQ C size before merge: " + apqC.size());
        apqC.merge(apqD);
        System.out.println("APQ C size after merging with empty: " + apqC.size());
        System.out.println("Top unchanged: " + apqC.top().getKey());
        System.out.println();
        
        //test 13: array extension (adding 25 elements)
        System.out.println("TEST " + testNumber++ + ": Array extension (adding 25 elements)");
        APQ<Integer, String> apq13 = new APQ<>();
        System.out.println("Adding 25 elements to trigger array resizing...");
        for (int i = 25; i >= 1; i--) {
            apq13.insert(i, "Value" + i);
        }
        System.out.println("Size after 25 inserts: " + apq13.size());
        System.out.println("Top element: " + apq13.top().getKey());
        System.out.println("5th smallest: " + apq13.peekAt(5).getKey());
        System.out.println("25th smallest: " + apq13.peekAt(25).getKey());
        System.out.println();
        
        //test 14: multiple upheap operations
        System.out.println("TEST " + testNumber++ + ": Multiple upheap operations");
      
        APQ<Integer, String> apq14 = new APQ<>();
        System.out.println("Inserting in descending order to trigger upheap...");
        apq14.insert(100, "Hundred");
        apq14.insert(90, "Ninety");
        apq14.insert(80, "Eighty");
        apq14.insert(70, "Seventy");
        apq14.insert(60, "Sixty");
        apq14.insert(50, "Fifty");
      
        System.out.println("Top after descending inserts: " + apq14.top().getKey());
        System.out.println();
        
        //test 15: multiple downheap operations
        System.out.println("TEST " + testNumber++ + ": Multiple downheap operations");
      
        APQ<Integer, String> apq15 = new APQ<>();
        apq15.insert(10, "Ten");
        apq15.insert(20, "Twenty");
        apq15.insert(30, "Thirty");
        apq15.insert(40, "Forty");
        apq15.insert(50, "Fifty");
      
        System.out.println("Removing top repeatedly to trigger downheap...");
        System.out.println("Removed: " + apq15.removeTop().getKey());
        System.out.println("Removed: " + apq15.removeTop().getKey());
        System.out.println("Removed: " + apq15.removeTop().getKey());
        System.out.println("Current top: " + apq15.top().getKey());
        System.out.println();
        
        //test 16: toggle multiple times
        System.out.println("TEST " + testNumber++ + ": Toggle multiple times");
      
        APQ<Integer, String> apq16 = new APQ<>();
        apq16.insert(15, "Fifteen");
        apq16.insert(25, "TwentyFive");
        apq16.insert(5, "Five");
        System.out.println("Initial state: " + apq16.state() + ", Top: " + apq16.top().getKey());
        apq16.toggle();
        System.out.println("After 1st toggle: " + apq16.state() + ", Top: " + apq16.top().getKey());
        apq16.toggle();
        System.out.println("After 2nd toggle: " + apq16.state() + ", Top: " + apq16.top().getKey());
        apq16.toggle();
        System.out.println("After 3rd toggle: " + apq16.state() + ", Top: " + apq16.top().getKey());
        System.out.println();
        
        //test 17: remove from various positions
        System.out.println("TEST " + testNumber++ + ": Remove from various heap positions");
        APQ<Integer, String> apq17 = new APQ<>();
        Entry<Integer, String> e17_1 = apq17.insert(50, "Fifty");
        Entry<Integer, String> e17_2 = apq17.insert(30, "Thirty");
        Entry<Integer, String> e17_3 = apq17.insert(70, "Seventy");
        Entry<Integer, String> e17_4 = apq17.insert(20, "Twenty");
        Entry<Integer, String> e17_5 = apq17.insert(40, "Forty");
        Entry<Integer, String> e17_6 = apq17.insert(60, "Sixty");
        Entry<Integer, String> e17_7 = apq17.insert(80, "Eighty");
        
        System.out.println("Initial size: " + apq17.size());
        apq17.remove(e17_4); // Remove from left subtree
        System.out.println("After removing 20, size: " + apq17.size());
        apq17.remove(e17_6); // Remove from right subtree
        System.out.println("After removing 60, size: " + apq17.size());
        apq17.remove(e17_2); // Remove near top
        System.out.println("After removing 30, size: " + apq17.size());
        System.out.println("Current top: " + apq17.top().getKey());
        System.out.println();
        
        //test 18: replacekey causing restructuring
        System.out.println("TEST " + testNumber++ + ": ReplaceKey causing restructuring");
        APQ<Integer, String> apq18 = new APQ<>();
      
        apq18.insert(50, "Fifty");
        Entry<Integer, String> e18 = apq18.insert(60, "Sixty");
        apq18.insert(40, "Forty");
        apq18.insert(70, "Seventy");
        apq18.insert(30, "Thirty");
        System.out.println("Before replaceKey - Top: " + apq18.top().getKey());
        apq18.replaceKey(e18, 5);
        System.out.println("After replaceKey(60 -> 5) - Top: " + apq18.top().getKey());
        System.out.println();
        
        //test 19: edge case, single element operations
        System.out.println("TEST " + testNumber++ + ": Single element operations");
      
        APQ<Integer, String> apq19 = new APQ<>();
        Entry<Integer, String> single = apq19.insert(42, "Answer");
        System.out.println("Size with one element: " + apq19.size());
        System.out.println("Top: " + apq19.top().getKey());
        System.out.println("PeekAt(1): " + apq19.peekAt(1).getKey());
        apq19.toggle();
      
        System.out.println("After toggle, top: " + apq19.top().getKey());
      
        apq19.remove(single);
      
        System.out.println("After removal, isEmpty: " + apq19.isEmpty());
        System.out.println();
        
        //test 20: empty apq operations
        System.out.println("TEST " + testNumber++ + ": Empty APQ operations");
      
        APQ<Integer, String> apq20 = new APQ<>();
        System.out.println("Is empty: " + apq20.isEmpty());
        System.out.println("Size: " + apq20.size());
        System.out.println("State: " + apq20.state());
        Entry<Integer, String> topEmpty = apq20.top();
      
        System.out.println("Top on empty APQ: " + (topEmpty == null ? "null" : topEmpty.getKey()));
      
        Entry<Integer, String> removeEmpty = apq20.removeTop();
      
        System.out.println("RemoveTop on empty APQ: " + (removeEmpty == null ? "null" : removeEmpty.getKey()));
        System.out.println();
        
        //test 21: large merge operation
        System.out.println("TEST " + testNumber++ + ": Large merge operation");
      
        APQ<Integer, String> apqX = new APQ<>();
        APQ<Integer, String> apqY = new APQ<>();
        
        for (int i = 2; i <= 20; i += 2) {
            apqX.insert(i, "Even" + i);
        }
        
        for (int i = 1; i <= 19; i += 2) {
            apqY.insert(i, "Odd" + i);
        }
        
        System.out.println("APQ X (evens) size: " + apqX.size());
        System.out.println("APQ Y (odds) size: " + apqY.size());
        apqX.merge(apqY);
        System.out.println("After merge, size: " + apqX.size());
        System.out.println("Top after merge: " + apqX.top().getKey());
        System.out.println("10th smallest: " + apqX.peekAt(10).getKey());
        System.out.println();
        
        //test 22: string keys test
        System.out.println("TEST " + testNumber++ + ": String keys test");
      
        APQ<String, Integer> apqStr = new APQ<>();
        apqStr.insert("Zebra", 26);
        apqStr.insert("Apple", 1);
        apqStr.insert("Mango", 13);
        apqStr.insert("Banana", 2);
      
        System.out.println("Top (lexicographically first): " + apqStr.top().getKey());
      
        apqStr.toggle();
      
        System.out.println("After toggle (lexicographically last): " + apqStr.top().getKey());
        System.out.println();
        
        //test 23: stress test with many operations
        System.out.println("TEST " + testNumber++ + ": Stress test with many operations");
        APQ<Integer, String> stressAPQ = new APQ<>();
        System.out.println("Inserting 50 elements...");
        for (int i = 50; i >= 1; i--) {
            stressAPQ.insert(i, "Val" + i);
        }
        System.out.println("Size: " + stressAPQ.size());
        
        System.out.println("Removing top 10 elements...");
        for (int i = 0; i < 10; i++) {
            stressAPQ.removeTop();
        }
        System.out.println("Size after removals: " + stressAPQ.size());
        System.out.println("New top: " + stressAPQ.top().getKey());
        
        System.out.println("Toggling to max-heap...");
        stressAPQ.toggle();
        System.out.println("Top in max mode: " + stressAPQ.top().getKey());
        System.out.println();
    }
}