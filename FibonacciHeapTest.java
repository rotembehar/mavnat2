public class FibonacciHeapTest {

    public static void main(String[] args) {
        FibonacciHeap heap = new FibonacciHeap(2);

        System.out.println(">>> Inserting values:");
        int[] keys = {30, 20, 50, 10, 40};

        for (int key : keys) {
            FibonacciHeap.HeapNode node = heap.insert(key, "info_" + key);
            System.out.println("Inserted: " + key + ", current min: " + heap.min.key);
        }

        // ✔ בדיקת גודל
        if (heap.size() != keys.length) {
            System.out.println("❌ Error: size() should be " + keys.length + " but got " + heap.size());
        } else {
            System.out.println("✅ size() correct");
        }

        // ✔ בדיקת מינימום
        if (heap.findMin().key != 10) {
            System.out.println("❌ Error: min key should be 10 but got " + heap.findMin().key);
        } else {
            System.out.println("✅ findMin() correct");
        }

        // ✔ בדיקת מבנה מעגלי של next/prev
        boolean circular = true;
        FibonacciHeap.HeapNode start = heap.min;
        FibonacciHeap.HeapNode curr = start.next;
        int steps = 1;

        while (curr != null && curr != start) {
            if (curr.prev.next != curr || curr.next.prev != curr) {
                circular = false;
                break;
            }
            curr = curr.next;
            steps++;
            if (steps > heap.size) { // כדי להימנע מלולאה אינסופית
                circular = false;
                break;
            }
        }

        if (circular) {
            System.out.println("✅ Circular next/prev structure correct");
        } else {
            System.out.println("❌ Error in next/prev circular structure");
        }
    }
}


