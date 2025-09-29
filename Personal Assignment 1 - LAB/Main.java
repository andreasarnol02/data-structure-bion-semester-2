import java.util.ArrayList;
import java.util.Scanner;

// Program utama untuk demonstrasi operasi Array dan ArrayList
public class Main {
  
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayOperations arrayOps = new ArrayOperations();
    ArrayListOperations arrayListOps = new ArrayListOperations();
    Comparison comparison = new Comparison();
    
    System.out.println("===============================================");
    System.out.println("    OPERASI ARRAY vs ARRAYLIST");
    System.out.println("===============================================");
    
    while (true) {
      printMenu();
      System.out.print("Pilih opsi (1-6): ");
      int choice = scanner.nextInt();
      
      switch (choice) {
        case 1:
          demonstrateArrayOperations(arrayOps, scanner);
          break;
        case 2:
          demonstrateArrayListOperations(arrayListOps, scanner);
          break;
        case 3:
          runPerformanceComparison(comparison);
          break;
        case 4:
          runDetailedComparison(comparison);
          break;
        case 5:
          comparison.compareMemoryUsage();
          break;
        case 6:
          System.out.println("Terima kasih telah menggunakan program!");
          scanner.close();
          return;
        default:
          System.out.println("Pilihan tidak valid! Silakan coba lagi.");
      }
      
      System.out.println("\nTekan Enter untuk melanjutkan...");
      scanner.nextLine();
      scanner.nextLine();
    }
  }
    
  private static void printMenu() {
    System.out.println("\n=============== MENU UTAMA ===============");
    System.out.println("1. Demonstrasi Operasi Array");
    System.out.println("2. Demonstrasi Operasi ArrayList");
    System.out.println("3. Perbandingan Performa (Cepat)");
    System.out.println("4. Perbandingan Performa (Detail)");
    System.out.println("5. Analisis Penggunaan Memori");
    System.out.println("6. Keluar");
    System.out.println("========================================");
  }
    
  private static void demonstrateArrayOperations(ArrayOperations arrayOps, Scanner scanner) {
    System.out.println("\n=== DEMONSTRASI OPERASI ARRAY ===");
    
    int[] sampleArray = {10, 25, 30, 45, 50, 65, 70, 85, 90};
    System.out.println("Array contoh dibuat: [10, 25, 30, 45, 50, 65, 70, 85, 90]");
    
    System.out.println("\n1. Operasi Traversal:");
    long traversalTime = arrayOps.traversal(sampleArray);
    System.out.println("Waktu yang diperlukan: " + traversalTime + " nanodetik");
    
    System.out.println("\n2. Operasi Pencarian Linear:");
    System.out.print("Masukkan elemen yang dicari: ");
    int searchElement = scanner.nextInt();
    long linearSearchTime = arrayOps.linearSearch(sampleArray, searchElement);
    System.out.println("Waktu yang diperlukan: " + linearSearchTime + " nanodetik");
    
    System.out.println("\n3. Operasi Pencarian Binary:");
    int[] sortedArray = arrayOps.getSortedArray(sampleArray);
    System.out.println("Array sudah diurutkan untuk pencarian binary");
    long binarySearchTime = arrayOps.binarySearch(sortedArray, searchElement);
    System.out.println("Waktu yang diperlukan: " + binarySearchTime + " nanodetik");
    
    System.out.println("\n4. Operasi Penyisipan:");
    System.out.print("Masukkan elemen yang akan disisipkan: ");
    int insertElement = scanner.nextInt();
    System.out.print("Masukkan posisi (0-" + sampleArray.length + "): ");
    int insertPosition = scanner.nextInt();
    long insertionTime = arrayOps.insertion(sampleArray, insertElement, insertPosition);
    System.out.println("Waktu yang diperlukan: " + insertionTime + " nanodetik");
    
    System.out.println("\n5. Operasi Penghapusan:");
    System.out.print("Masukkan posisi yang akan dihapus (0-" + (sampleArray.length - 1) + "): ");
    int deletePosition = scanner.nextInt();
    long deletionTime = arrayOps.deletion(sampleArray, deletePosition);
    System.out.println("Waktu yang diperlukan: " + deletionTime + " nanodetik");
  }
    
  private static void demonstrateArrayListOperations(ArrayListOperations arrayListOps, Scanner scanner) {
    System.out.println("\n=== DEMONSTRASI OPERASI ARRAYLIST ===");
    
    ArrayList<Integer> sampleList = new ArrayList<>();
    int[] initialData = {10, 25, 30, 45, 50, 65, 70, 85, 90};
    for (int value : initialData) {
      sampleList.add(value);
    }
    System.out.println("ArrayList contoh dibuat: [10, 25, 30, 45, 50, 65, 70, 85, 90]");
    
    System.out.println("\n1. Operasi Traversal:");
    long traversalTime = arrayListOps.traversal(sampleList);
    System.out.println("Waktu yang diperlukan: " + traversalTime + " nanodetik");
    
    System.out.println("\n2. Operasi Tambah Elemen:");
    System.out.print("Masukkan elemen yang akan ditambahkan: ");
    int addElement = scanner.nextInt();
    long addTime = arrayListOps.addElement(sampleList, addElement);
    System.out.println("Waktu yang diperlukan: " + addTime + " nanodetik");
    System.out.println("Ukuran ArrayList saat ini: " + arrayListOps.getSize(sampleList));
    
    System.out.println("\n3. Tambah Elemen pada Posisi:");
    System.out.print("Masukkan elemen yang akan disisipkan: ");
    int insertElement = scanner.nextInt();
    System.out.print("Masukkan posisi (0-" + sampleList.size() + "): ");
    int insertPosition = scanner.nextInt();
    long insertTime = arrayListOps.addElementAtPosition(sampleList, insertElement, insertPosition);
    System.out.println("Waktu yang diperlukan: " + insertTime + " nanodetik");
    
    System.out.println("\n4. Operasi Pencarian:");
    System.out.print("Masukkan elemen yang dicari: ");
    int searchElement = scanner.nextInt();
    long searchTime = arrayListOps.searchElement(sampleList, searchElement);
    System.out.println("Waktu yang diperlukan: " + searchTime + " nanodetik");
    
    System.out.println("\n5. Operasi Hapus Elemen:");
    System.out.print("Masukkan elemen yang akan dihapus: ");
    int removeElement = scanner.nextInt();
    long removeTime = arrayListOps.removeElement(sampleList, removeElement);
    System.out.println("Waktu yang diperlukan: " + removeTime + " nanodetik");
    
    System.out.println("\n6. Operasi Pengurutan:");
    long sortTime = arrayListOps.sortArrayList(sampleList);
    System.out.println("Waktu yang diperlukan: " + sortTime + " nanodetik");
    arrayListOps.traversal(sampleList);
  }
    
  private static void runPerformanceComparison(Comparison comparison) {
    System.out.println("\n=== PERBANDINGAN PERFORMA CEPAT ===");
    
    int[] testSizes = {100, 500, 1000};
    
    for (int size : testSizes) {
      System.out.println("\n--- Pengujian dengan " + size + " elemen ---");
      comparison.compareTraversal(size);
      comparison.compareSearch(size);
      comparison.compareInsertion(size);
      comparison.compareDeletion(size);
    }
  }
    
  private static void runDetailedComparison(Comparison comparison) {
    System.out.println("\n=== PERBANDINGAN PERFORMA DETAIL ===");
    System.out.println("Ini mungkin memerlukan waktu sebentar...");
    
    int[] testSizes = {10, 50, 100, 500, 1000, 5000};
    comparison.runComprehensiveComparison(testSizes);
    
    System.out.println("\n=== ANALISIS PERFORMA ===");
    System.out.println("1. Traversal: Array dan ArrayList memiliki performa O(n) yang serupa");
    System.out.println("2. Pencarian: ArrayList menggunakan indexOf() yang dioptimasi, pencarian linear Array adalah O(n)");
    System.out.println("3. Pencarian Binary: Pencarian binary Array adalah O(log n) - tercepat untuk data terurut");
    System.out.println("4. Penyisipan: ArrayList umumnya lebih cepat karena pengubahan ukuran dinamis");
    System.out.println("5. Penghapusan: ArrayList menangani penghapusan lebih efisien");
    
    System.out.println("\n=== RINGKASAN KOMPLEKSITAS ===");
    System.out.println("Operasi Array:");
    System.out.println("  - Akses: O(1)");
    System.out.println("  - Pencarian: O(n) linear, O(log n) binary (jika terurut)");
    System.out.println("  - Penyisipan: O(n) karena pergeseran elemen");
    System.out.println("  - Penghapusan: O(n) karena pergeseran elemen");
    
    System.out.println("\nOperasi ArrayList:");
    System.out.println("  - Akses: O(1)");
    System.out.println("  - Pencarian: O(n)");
    System.out.println("  - Penyisipan: O(1) amortized di akhir, O(n) pada posisi sembarang");
    System.out.println("  - Penghapusan: O(n) karena pergeseran elemen");
  }
}
