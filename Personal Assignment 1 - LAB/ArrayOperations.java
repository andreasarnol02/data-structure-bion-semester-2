// Kelas untuk operasi dasar pada Array
public class ArrayOperations {
  
  // Operasi traversal - menampilkan semua elemen array
  public long traversal(int[] arr) {
    long startTime = System.nanoTime();
    
    System.out.print("Elemen Array: ");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    
    long endTime = System.nanoTime();
    return endTime - startTime;
  }
  
  // Pencarian linear
  public long linearSearch(int[] arr, int target) {
    long startTime = System.nanoTime();
    
    int index = -1;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == target) {
        index = i;
        break;
      }
    }
    
    long endTime = System.nanoTime();
    
    if (index != -1) {
      System.out.println("Pencarian Linear: Elemen " + target + " ditemukan di indeks " + index);
    } else {
      System.out.println("Pencarian Linear: Elemen " + target + " tidak ditemukan");
    }
    
    return endTime - startTime;
  }
  
  // Pencarian binary (memerlukan array yang sudah terurut)
  public long binarySearch(int[] arr, int target) {
    long startTime = System.nanoTime();
    
    int left = 0;
    int right = arr.length - 1;
    int index = -1;
    
    while (left <= right) {
      int mid = left + (right - left) / 2;
      
      if (arr[mid] == target) {
        index = mid;
        break;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    
    long endTime = System.nanoTime();
    
    if (index != -1) {
      System.out.println("Pencarian Binary: Elemen " + target + " ditemukan di indeks " + index);
    } else {
      System.out.println("Pencarian Binary: Elemen " + target + " tidak ditemukan");
    }
    
    return endTime - startTime;
  }
  
  // Penyisipan elemen pada posisi tertentu
  public long insertion(int[] arr, int element, int position) {
    long startTime = System.nanoTime();
    
    if (position < 0 || position > arr.length) {
      System.out.println("Posisi tidak valid untuk penyisipan");
      return System.nanoTime() - startTime;
    }
    
    int[] newArr = new int[arr.length + 1];
    System.arraycopy(arr, 0, newArr, 0, position);
    newArr[position] = element;
    System.arraycopy(arr, position, newArr, position + 1, arr.length - position);
    
    long endTime = System.nanoTime();
    
    System.out.println("Elemen " + element + " disisipkan pada posisi " + position);
    
    return endTime - startTime;
  }
  
  // Penghapusan elemen pada posisi tertentu
  public long deletion(int[] arr, int position) {
    long startTime = System.nanoTime();
    
    if (position < 0 || position >= arr.length) {
      System.out.println("Posisi tidak valid untuk penghapusan");
      return System.nanoTime() - startTime;
    }
    
    int[] newArr = new int[arr.length - 1];
    System.arraycopy(arr, 0, newArr, 0, position);
    System.arraycopy(arr, position + 1, newArr, position, arr.length - position - 1);
    
    long endTime = System.nanoTime();
    
    System.out.println("Elemen pada posisi " + position + " telah dihapus");
    
    return endTime - startTime;
  }
  
  // Membuat salinan array yang terurut untuk pencarian binary
  public int[] getSortedArray(int[] arr) {
    int[] sortedArr = arr.clone();
    java.util.Arrays.sort(sortedArr);
    return sortedArr;
  }
}
