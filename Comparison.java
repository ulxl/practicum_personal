import java.util.ArrayList;
import java.util.Arrays;

/**
 * Kelas untuk membandingkan kinerja Array dan ArrayList.
 */
public class Comparison {

    public static void main(String[] args) {
        // --- Data Awal ---
        int[] initialData = {10, 50, 30, 20, 40};
        int[] currentArray = Arrays.copyOf(initialData, initialData.length); // Salinan untuk Array
        ArrayList<Integer> currentList = new ArrayList<>(); // ArrayList
        for (int val : initialData) {
            currentList.add(val);
        }

        // --- Instance Kelas Operasi ---
        ArrayOperations arrayOps = new ArrayOperations();
        ArrayListOperations listOps = new ArrayListOperations();

        // --- Operasi dan Pengukuran Waktu ---
        System.out.println("--- Data Awal ---");
        arrayOps.traverse(currentArray);
        listOps.traverse(currentList);
        System.out.println("----------------------------------------");

        // 1. Pencarian (Search)
        System.out.println("--- Pencarian Elemen 30 ---");
        int targetSearch = 30;
        long startTime, endTime;
        double durationArray, durationList;

        // Pencarian Array (Linear)
        startTime = System.nanoTime();
        int indexArray = arrayOps.linearSearch(currentArray, targetSearch);
        endTime = System.nanoTime();
        durationArray = (endTime - startTime) / 1_000_000.0; // konversi ke ms
        System.out.println("Pencarian " + targetSearch + " dalam Array (Linear): Ditemukan di indeks " + indexArray);
        System.out.printf("Waktu eksekusi pencarian pada Array (Linear): %.6f ms%n", durationArray);


        // Pencarian ArrayList
        startTime = System.nanoTime();
        int indexList = listOps.search(currentList, targetSearch);
        endTime = System.nanoTime();
        durationList = (endTime - startTime) / 1_000_000.0; // konversi ke ms
        System.out.println("Pencarian " + targetSearch + " dalam ArrayList: Ditemukan di indeks " + indexList);
        System.out.printf("Waktu eksekusi pencarian pada ArrayList: %.6f ms%n", durationList);
        System.out.println("----------------------------------------");


        // 2. Penyisipan (Insertion)
        System.out.println("--- Penyisipan Elemen 25 di Indeks 2 ---");
        int elementInsert = 25;
        int indexInsert = 2;

        // Penyisipan Array
        startTime = System.nanoTime();
        currentArray = arrayOps.insert(currentArray, elementInsert, indexInsert); // Update array
        endTime = System.nanoTime();
        durationArray = (endTime - startTime) / 1_000_000.0;
        System.out.print("Array setelah penyisipan elemen " + elementInsert + ": ");
        arrayOps.traverse(currentArray); // Tampilkan array baru
        System.out.printf("Waktu eksekusi penyisipan pada Array: %.6f ms%n", durationArray);

        // Penyisipan ArrayList
        startTime = System.nanoTime();
        listOps.addAtIndex(currentList, indexInsert, elementInsert);
        endTime = System.nanoTime();
        durationList = (endTime - startTime) / 1_000_000.0;
        System.out.print("ArrayList setelah penyisipan elemen " + elementInsert + ": ");
        listOps.traverse(currentList); // Tampilkan list baru
        System.out.printf("Waktu eksekusi penyisipan pada ArrayList: %.6f ms%n", durationList);
        System.out.println("----------------------------------------");


        // 3. Penghapusan (Deletion)
        System.out.println("--- Penghapusan Elemen di Indeks 1 ---");
        int indexDelete = 1; // Akan menghapus elemen 50 dari array, 50 dari list

         // Penghapusan Array
        startTime = System.nanoTime();
        currentArray = arrayOps.delete(currentArray, indexDelete); // Update array
        endTime = System.nanoTime();
        durationArray = (endTime - startTime) / 1_000_000.0;
        System.out.print("Array setelah penghapusan elemen di indeks " + indexDelete + ": ");
        arrayOps.traverse(currentArray); // Tampilkan array baru
        System.out.printf("Waktu eksekusi penghapusan pada Array: %.6f ms%n", durationArray);

        // Penghapusan ArrayList
        startTime = System.nanoTime();
        listOps.remove(currentList, indexDelete);
        endTime = System.nanoTime();
        durationList = (endTime - startTime) / 1_000_000.0;
        System.out.print("ArrayList setelah penghapusan elemen di indeks " + indexDelete + ": ");
        listOps.traverse(currentList); // Tampilkan list baru
        System.out.printf("Waktu eksekusi penghapusan pada ArrayList: %.6f ms%n", durationList);
        System.out.println("----------------------------------------");


        // 4. Pengurutan (Sorting) - Hanya untuk ArrayList sesuai instruksi
        System.out.println("--- Pengurutan ArrayList ---");
        startTime = System.nanoTime();
        listOps.sort(currentList);
        endTime = System.nanoTime();
        durationList = (endTime - startTime) / 1_000_000.0;
        System.out.print("ArrayList setelah pengurutan: ");
        listOps.traverse(currentList);
        System.out.printf("Waktu eksekusi pengurutan pada ArrayList: %.6f ms%n", durationList);
        System.out.println("----------------------------------------");

        // 5. Binary Search pada Array (setelah data mungkin berubah & perlu diurutkan)
        System.out.println("--- Pencarian Elemen 40 (Binary Search Array) ---");
        // Pastikan array terurut untuk Binary Search
        Arrays.sort(currentArray);
        System.out.print("Array setelah diurutkan untuk Binary Search: ");
        arrayOps.traverse(currentArray);

        int targetBinary = 40;
        startTime = System.nanoTime();
        int indexBinary = arrayOps.binarySearch(currentArray, targetBinary);
         endTime = System.nanoTime();
        durationArray = (endTime - startTime) / 1_000_000.0; // konversi ke ms

        if (indexBinary >= 0) {
             System.out.println("Pencarian " + targetBinary + " dalam Array (Binary): Ditemukan di indeks " + indexBinary);
        } else {
             System.out.println("Pencarian " + targetBinary + " dalam Array (Binary): Tidak ditemukan.");
        }
        System.out.printf("Waktu eksekusi pencarian pada Array (Binary): %.6f ms%n", durationArray);
        System.out.println("----------------------------------------");
    }
}