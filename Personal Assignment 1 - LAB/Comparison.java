import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// Kelas untuk mengukur dan membandingkan performa Array dan ArrayList
public class Comparison {
  private ArrayOperations arrayOps;
  private ArrayListOperations arrayListOps;
  
  public Comparison() {
    this.arrayOps = new ArrayOperations();
    this.arrayListOps = new ArrayListOperations();
  }
    
  // Menghasilkan data test untuk perbandingan performa
  public int[] generateTestData(int size) {
    Random random = new Random(42);
    int[] data = new int[size];
    for (int i = 0; i < size; i++) {
      data[i] = random.nextInt(1000);
    }
    return data;
  }
    
  // Mengkonversi array ke ArrayList
  public ArrayList<Integer> arrayToArrayList(int[] arr) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int value : arr) {
      list.add(value);
    }
    return list;
  }
    
  // Membandingkan performa traversal
  public void compareTraversal(int size) {
    System.out.println("\n=== PERBANDINGAN TRAVERSAL (Ukuran: " + size + ") ===");
    
    int[] arr = generateTestData(size);
    ArrayList<Integer> list = arrayToArrayList(arr);
    
    long arrayTime = arrayOps.traversal(arr);
    long arrayListTime = arrayListOps.traversal(list);
    
    System.out.println("Waktu traversal Array: " + arrayTime + " nanodetik");
    System.out.println("Waktu traversal ArrayList: " + arrayListTime + " nanodetik");
    System.out.println("Selisih: " + Math.abs(arrayTime - arrayListTime) + " nanodetik");
  }
    
  // Membandingkan performa pencarian
  public void compareSearch(int size) {
    System.out.println("\n=== PERBANDINGAN PENCARIAN (Ukuran: " + size + ") ===");
    
    int[] arr = generateTestData(size);
    ArrayList<Integer> list = arrayToArrayList(arr);
    int target = arr[size / 2];
    
    long arrayLinearTime = arrayOps.linearSearch(arr, target);
    long arrayListSearchTime = arrayListOps.searchElement(list, target);
    
    int[] sortedArr = arrayOps.getSortedArray(arr);
    long arrayBinaryTime = arrayOps.binarySearch(sortedArr, target);
    
    System.out.println("Waktu pencarian linear Array: " + arrayLinearTime + " nanodetik");
    System.out.println("Waktu pencarian ArrayList: " + arrayListSearchTime + " nanodetik");
    System.out.println("Waktu pencarian binary Array: " + arrayBinaryTime + " nanodetik");
  }
    
  // Membandingkan performa penyisipan
  public void compareInsertion(int size) {
    System.out.println("\n=== PERBANDINGAN PENYISIPAN (Ukuran: " + size + ") ===");
    
    int[] arr = generateTestData(size);
    ArrayList<Integer> list = arrayToArrayList(arr);
    
    int element = 999;
    int position = size / 2;
    
    long arrayInsertTime = arrayOps.insertion(arr, element, position);
    long arrayListInsertTime = arrayListOps.addElementAtPosition(list, element, position);
    
    System.out.println("Waktu penyisipan Array: " + arrayInsertTime + " nanodetik");
    System.out.println("Waktu penyisipan ArrayList: " + arrayListInsertTime + " nanodetik");
    System.out.println("Selisih: " + Math.abs(arrayInsertTime - arrayListInsertTime) + " nanodetik");
  }
    
  // Membandingkan performa penghapusan
  public void compareDeletion(int size) {
    System.out.println("\n=== PERBANDINGAN PENGHAPUSAN (Ukuran: " + size + ") ===");
    
    int[] arr = generateTestData(size);
    ArrayList<Integer> list = arrayToArrayList(arr);
    
    int position = size / 2;
    
    long arrayDeleteTime = arrayOps.deletion(arr, position);
    long arrayListDeleteTime = arrayListOps.removeElementAtPosition(list, position);
    
    System.out.println("Waktu penghapusan Array: " + arrayDeleteTime + " nanodetik");
    System.out.println("Waktu penghapusan ArrayList: " + arrayListDeleteTime + " nanodetik");
    System.out.println("Selisih: " + Math.abs(arrayDeleteTime - arrayListDeleteTime) + " nanodetik");
  }
    
  // Menjalankan perbandingan performa komprehensif
  public void runComprehensiveComparison(int[] sizes) {
    System.out.println("===============================================");
    System.out.println("     PERBANDINGAN PERFORMA ARRAY vs ARRAYLIST");
    System.out.println("===============================================");
    
    System.out.printf("%-12s %-15s %-15s %-15s %-15s %-15s%n", 
                     "Ukuran", "Array Traverse", "AL Traverse", "Array Search", "AL Search", "Array Binary");
    System.out.println("-----------------------------------------------------------------------------------------");
    
    for (int size : sizes) {
      int[] arr = generateTestData(size);
      ArrayList<Integer> list = arrayToArrayList(arr);
      int target = arr[size / 2];
      
      long arrayTraverseTime = measureOperation(() -> arrayOps.traversal(arr));
      long arrayListTraverseTime = measureOperation(() -> arrayListOps.traversal(list));
      long arraySearchTime = measureOperation(() -> arrayOps.linearSearch(arr, target));
      long arrayListSearchTime = measureOperation(() -> arrayListOps.searchElement(list, target));
      
      int[] sortedArr = arrayOps.getSortedArray(arr);
      long arrayBinaryTime = measureOperation(() -> arrayOps.binarySearch(sortedArr, target));
      
      System.out.printf("%-12d %-15d %-15d %-15d %-15d %-15d%n", 
                       size, arrayTraverseTime, arrayListTraverseTime, 
                       arraySearchTime, arrayListSearchTime, arrayBinaryTime);
    }
    
    System.out.println("-----------------------------------------------------------------------------------------");
    System.out.println("Semua waktu dalam nanodetik");
    System.out.println("AL = ArrayList");
  }
    
  // Mengukur waktu operasi dengan beberapa kali percobaan untuk akurasi
  private long measureOperation(Runnable operation) {
    for (int i = 0; i < 3; i++) {
      operation.run();
    }
    
    long totalTime = 0;
    int runs = 5;
    for (int i = 0; i < runs; i++) {
      long startTime = System.nanoTime();
      operation.run();
      long endTime = System.nanoTime();
      totalTime += (endTime - startTime);
    }
    
    return totalTime / runs;
  }
    
  // Menampilkan analisis penggunaan memori
  public void compareMemoryUsage() {
    System.out.println("\n=== ANALISIS PENGGUNAAN MEMORI ===");
    System.out.println("Array:");
    System.out.println("  - Alokasi ukuran tetap");
    System.out.println("  - Memori dialokasikan saat pembuatan");
    System.out.println("  - Overhead memori lebih rendah per elemen");
    System.out.println("  - Tidak dapat mengubah ukuran secara dinamis");
    
    System.out.println("\nArrayList:");
    System.out.println("  - Alokasi ukuran dinamis");
    System.out.println("  - Kapasitas awal 10, bertambah 50% saat diperlukan");
    System.out.println("  - Overhead memori lebih tinggi karena object wrapper");
    System.out.println("  - Manajemen memori otomatis");
    System.out.println("  - Mungkin memiliki ruang alokasi yang tidak terpakai");
  }
}
