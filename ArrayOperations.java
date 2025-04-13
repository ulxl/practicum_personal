import java.util.Arrays;

/**
 * Kelas untuk melakukan operasi dasar pada Array (int[]).
 */
class ArrayOperations {

    // 1. Traversal (Menampilkan isi array)
    public void traverse(int[] arr) {
        System.out.println("Array Traversal: " + Arrays.toString(arr));
    }

    // 2a. Pencarian nilai - Linear Search
    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Mengembalikan indeks jika ditemukan
            }
        }
        return -1; // Mengembalikan -1 jika tidak ditemukan
    }

    // 2b. Pencarian nilai - Binary Search (Array HARUS TERURUT!)
    public int binarySearch(int[] arr, int target) {
        // Pastikan array terurut sebelum menggunakan binary search bawaan
        // Arrays.sort(arr); // Uncomment jika array belum pasti terurut
        return Arrays.binarySearch(arr, target); // Mengembalikan indeks atau nilai negatif jika tidak ada
    }

    // 3. Penyisipan nilai ke dalam array (Membuat array baru)
    public int[] insert(int[] arr, int element, int index) {
        if (index < 0 || index > arr.length) {
            System.out.println("Indeks tidak valid untuk penyisipan.");
            return arr; // Kembalikan array asli jika indeks salah
        }
        int[] newArr = new int[arr.length + 1];
        // Salin elemen sebelum indeks
        System.arraycopy(arr, 0, newArr, 0, index);
        // Sisipkan elemen baru
        newArr[index] = element;
        // Salin elemen setelah indeks
        System.arraycopy(arr, index, newArr, index + 1, arr.length - index);
        return newArr;
    }

    // 4. Penghapusan nilai dari array (Membuat array baru)
    public int[] delete(int[] arr, int index) {
        if (arr == null || index < 0 || index >= arr.length) {
             System.out.println("Indeks tidak valid atau array kosong.");
            return arr; // Kembalikan array asli jika indeks salah
        }
        int[] newArr = new int[arr.length - 1];
        // Salin elemen sebelum indeks
        System.arraycopy(arr, 0, newArr, 0, index);
        // Salin elemen setelah indeks (lewati elemen di 'index')
        System.arraycopy(arr, index + 1, newArr, index, arr.length - index - 1);
        return newArr;
    }
}


