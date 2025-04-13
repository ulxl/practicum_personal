import java.util.ArrayList;
import java.util.Collections;

class ArrayListOperations {

   // 1. Menambahkan elemen ke dalam ArrayList (di akhir)
   public void add(ArrayList<Integer> list, int element) {
       list.add(element);
   }

    // Menambahkan elemen ke dalam ArrayList (di indeks tertentu) - untuk perbandingan
   public void addAtIndex(ArrayList<Integer> list, int index, int element) {
       if (index < 0 || index > list.size()) {
            System.out.println("Indeks tidak valid untuk penyisipan.");
            return;
       }
       list.add(index, element);
   }

   // 2. Menghapus elemen dari ArrayList (berdasarkan indeks)
   public void remove(ArrayList<Integer> list, int index) {
        if (list == null || list.isEmpty() || index < 0 || index >= list.size()) {
            System.out.println("Indeks tidak valid atau list kosong.");
            return;
        }
       list.remove(index);
   }

   // 3. Melakukan pencarian elemen dalam ArrayList
   public int search(ArrayList<Integer> list, int target) {
       return list.indexOf(target); // Mengembalikan indeks atau -1 jika tidak ditemukan
   }

   // 4. Mengurutkan elemen dalam ArrayList
   public void sort(ArrayList<Integer> list) {
       Collections.sort(list);
   }

   // Helper untuk menampilkan isi ArrayList
    public void traverse(ArrayList<Integer> list) {
       System.out.println("ArrayList Traversal: " + list.toString());
   }
}