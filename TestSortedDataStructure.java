package hus.oop.sorteddatastructure;
import java.util.Random;

public class TestSortedDataStructure {
    private static final Random random = new Random();
    public static void main(String[] args) {
        /* TODO
        - Hoàn thiện code chương trình theo mẫu đã cho.
        - Viết code để test cho tất cả các hàm test bên dưới.

        - Thực hiện chạy từng hàm test theo format:
              Tên test:
              Kết quả chạy chương trình.

          Lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_SortedDataStructure>.txt (Ví dụ, NguyenVanA_123456_SortedDataStructure.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_SortedDataStructure>.zip (Ví dụ, NguyenVanA_123456_SortedDataStructure.zip),
          nộp lên classroom.
         */
        testSortedArrayList();
        testSortedLinkedList();
    }

    public static void testSortedArrayList() {
        /* TODO
         - Sinh ngẫu nhiên ra 1 số tự nhiên nằm trong đoạn [20, 30], lưu giá trị và biến n.
         - Sinh ngẫu nhiên ra n số tự nhiên nằm trong đoạn [10, 100], cho vào SortedArrayList.
             - In ra danh sách các số tự nhiên theo định dạng [a1, a2, ... an] trên 1 dòng.
               Mỗi lần thêm phần tử vào in ra danh sách các phần tử trên 1 dòng.
             - Sinh ngẫu nhiên ra các số tự nhiên, test kiểm tra xem giá trị đó có nằm trong list hay không,
               nếu có chỉ số của nó trong danh sách là gì.
         */
        int n = random.nextInt(11) + 20;
        System.out.println("Generating " + n + " random numbers for SortedArrayList");
        MySortedArrayList list = new MySortedArrayList();
        System.out.println("\nAdding elements to list:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(91) + 10;
            System.out.print("Adding " + value + " to the list: ");
            list.add(value);
            System.out.println(list);
        }

        System.out.println("\nTesting search operations:");
        for (int i = 0; i < 5; i++) {
            int value = random.nextInt(91) + 10;
            int index = list.binarySearch(value);
            if (list.contains(value)) {
                System.out.println("Value " + value + " found at index " + index);
            } else {
                System.out.println("Value " + value + " not found in the list");
            }
        }
    }

    public static void testSortedLinkedList() {
        /* TODO
         - Sinh ngẫu nhiên ra 1 số tự nhiên nằm trong đoạn [20, 30], lưu giá trị và biến n.
         - Sinh ngẫu nhiên ra n số tự nhiên nằm trong đoạn [10, 100], cho vào SortedLinkedList.
             - In ra danh sách các số tự nhiên theo định dạng [a1, a2, ... an] trên 1 dòng.
               Mỗi lần thêm phần tử vào in ra danh sách các phần tử trên 1 dòng.
             - Sinh ngẫu nhiên ra các số tự nhiên, test kiểm tra xem giá trị đó có nằm trong list hay không,
               nếu có chỉ số của nó trong danh sách là gì.
         */
        int n = random.nextInt(11) + 20;
        System.out.println("Generating " + n + " random numbers for SortedLinkedList");
        MySortedLinkedList list = new MySortedLinkedList();
        System.out.println("\nAdding elements to list:");
        for (int i = 0; i < n; i++) {
            int value = random.nextInt(91) + 10; // [10, 100]
            System.out.print("Adding " + value + " to the list: ");
            list.add(value);
            System.out.println(list);
        }

        System.out.println("\nTesting search operations:");
        for (int i = 0; i < 5; i++) {
            int value = random.nextInt(91) + 10; // [10, 100]
            int index = list.binarySearch(value);
            if (list.contains(value)) {
                System.out.println("Value " + value + " found at index " + index);
            } else {
                System.out.println("Value " + value + " not found in the list");
            }
        }
    }
}
