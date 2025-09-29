import java.util.ArrayList;
import java.util.Collections;

// Kelas untuk operasi dasar pada ArrayList
public class ArrayListOperations {
  
  // Menambahkan elemen ke ArrayList
  public long addElement(ArrayList<Integer> list, int element) {
    long startTime = System.nanoTime();
    
    list.add(element);
    
    long endTime = System.nanoTime();
    
    System.out.println("Elemen " + element + " ditambahkan ke ArrayList");
    
    return endTime - startTime;
  }
  
  // Menambahkan elemen pada posisi tertentu
  public long addElementAtPosition(ArrayList<Integer> list, int element, int position) {
    long startTime = System.nanoTime();
    
    if (position < 0 || position > list.size()) {
      System.out.println("Posisi tidak valid untuk penyisipan");
      return System.nanoTime() - startTime;
    }
    
    list.add(position, element);
    
    long endTime = System.nanoTime();
    
    System.out.println("Elemen " + element + " ditambahkan pada posisi " + position + " di ArrayList");
    
    return endTime - startTime;
  }
  
  // Menghapus elemen berdasarkan nilai
  public long removeElement(ArrayList<Integer> list, int element) {
    long startTime = System.nanoTime();
    
    boolean removed = list.remove(Integer.valueOf(element));
    
    long endTime = System.nanoTime();
    
    if (removed) {
      System.out.println("Elemen " + element + " dihapus dari ArrayList");
    } else {
      System.out.println("Elemen " + element + " tidak ditemukan di ArrayList");
    }
    
    return endTime - startTime;
  }
  
  // Menghapus elemen pada posisi tertentu
  public long removeElementAtPosition(ArrayList<Integer> list, int position) {
    long startTime = System.nanoTime();
    
    if (position < 0 || position >= list.size()) {
      System.out.println("Posisi tidak valid untuk penghapusan");
      return System.nanoTime() - startTime;
    }
    
    int removedElement = list.remove(position);
    
    long endTime = System.nanoTime();
    
    System.out.println("Elemen " + removedElement + " pada posisi " + position + " dihapus dari ArrayList");
    
    return endTime - startTime;
  }
  
  // Pencarian elemen dalam ArrayList
  public long searchElement(ArrayList<Integer> list, int target) {
    long startTime = System.nanoTime();
    
    int index = list.indexOf(target);
    
    long endTime = System.nanoTime();
    
    if (index != -1) {
      System.out.println("Pencarian ArrayList: Elemen " + target + " ditemukan di indeks " + index);
    } else {
      System.out.println("Pencarian ArrayList: Elemen " + target + " tidak ditemukan");
    }
    
    return endTime - startTime;
  }
  
  // Mengurutkan ArrayList secara ascending
  public long sortArrayList(ArrayList<Integer> list) {
    long startTime = System.nanoTime();
    
    Collections.sort(list);
    
    long endTime = System.nanoTime();
    
    System.out.println("ArrayList telah diurutkan secara ascending");
    
    return endTime - startTime;
  }
  
  // Operasi traversal - menampilkan semua elemen ArrayList
  public long traversal(ArrayList<Integer> list) {
    long startTime = System.nanoTime();
    
    System.out.print("Elemen ArrayList: ");
    for (int element : list) {
      System.out.print(element + " ");
    }
    System.out.println();
    
    long endTime = System.nanoTime();
    return endTime - startTime;
  }
  
  // Mendapatkan ukuran ArrayList saat ini
  public int getSize(ArrayList<Integer> list) {
    return list.size();
  }
}
