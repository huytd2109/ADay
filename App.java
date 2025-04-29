package hus.oop.students;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class App {
    private static final String COMMA_DELIMITER = ",";

    public static void readListData(String filePath) {
        BufferedReader dataReader = null;
        try {
            String line;
            dataReader = new BufferedReader(new FileReader(filePath));

            // Read file line by line?
            while ((line = dataReader.readLine()) != null) {
                List<String> dataList = parseDataLineToList(line);
                if (dataList.size() != 7) {
                    continue;
                }

                if (dataList.get(0).equals("id")) {
                    continue;
                }

                /*
                TODO

                - Đọc được dữ liệu, tạo ra các đối tượng sinh viên ở đây, và cho vào đối tượng được tạo ra từ
                lớp StudentManager để quản lý.

                Chú ý:
                - Các đội tượng Student không thể được tạo trực tiếp ở đây do hàm dựng là private,
                  các đối tượng này được tạo ra bằng cách sử dụng Builder Pattern, ví dụ theo cách sau:
                  Student newStudent = new Student.StudentBuilder(id).
                    .withLastname(lastName)
                    .withFirstname(firstName)
                    ...
                    .build();

                - Đối tượng tạo ra từ lớp StudentManager là duy nhất trong chương trình, do dùng Singleton Pattern,
                  và được tạo ra bằng cách gọi hàm StudentManager.getInstance().
                */
                Student newStudent = new Student.StudentBuilder(dataList.get(0))
                        .withLastname(dataList.get(1))
                        .withFirstname(dataList.get(2))
                        .withYearOfBirth(Integer.parseInt(dataList.get(3)))
                        .withMathsGrade(Double.parseDouble(dataList.get(4)))
                        .withPhysicsGrade(Double.parseDouble(dataList.get(5)))
                        .withChemistryGrade(Double.parseDouble(dataList.get(6)))
                        .build();

                StudentManager.getInstance().append(newStudent);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (dataReader != null)
                    dataReader.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
    }

    public static List<String> parseDataLineToList(String dataLine) {
        List<String> result = new ArrayList<>();
        if (dataLine != null) {
            String[] splitData = dataLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }

    public static String[] parseDataLineToArray(String dataLine) {
        if (dataLine == null) {
            return null;
        }

        return dataLine.split(COMMA_DELIMITER);
    }

    public static void main(String[] args) {
        init();
        testOriginalData();
        testSortStudentsByName();
        testSortAverageGradeIncreasing();
        testSortAverageGradeDecreasing();
        testFilterPassStudents();
        testFilterFailureStudents();

        /* Yêu cầu:
        - Hoàn thiện code chương trình theo mẫu và theo yêu cầu đã cho.
        - Viết code để test cho tất cả các hàm test.

        - Thực hiện chạy từng hàm test, lưu kết quả chạy chương trình và file text được đặt tên
          là <TenSinhVien_MaSinhVien_StudentManager>.txt (Ví dụ, NguyenVanA_123456_StudentManager.txt).
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom.
         */
    }

    public static void init() {
        String filePath = "data/students.csv";
        readListData(filePath);
    }

    /*
     * Test in ra danh sách các sinh viên theo thứ tự đọc vào ban đầu.
     * Mỗi sinh viên trên một dòng, theo format được định nghĩa trong hàm toString() của Student.
     */
    public static void testOriginalData() {
        System.out.println("Original Student List:");
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < StudentManager.getInstance().numberOfStudents(); i++) {
            students.add(StudentManager.getInstance().studentAt(i));
        }
        StudentManager.print(students);
        System.out.println();
    }

    /*
     * Test in ra danh sách sinh viên được sắp xếp theo thứ tự tăng dần, đầu tiên tính đến tên, sau đó tính đến họ.
     */
    public static void testSortStudentsByName() {
        System.out.println("Students Sorted By Name:");
        List<Student> sortedStudents = StudentManager.getInstance().sortStudentsByName();
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /*
     * Test in ra danh sách sinh viên sắp xếp theo thứ tự điểm trung bình tăng dần.
     * Mỗi sinh viên trên một dòng, theo format được định nghĩa trong hàm toString() của Student.
     */
    public static void testSortAverageGradeIncreasing() {
        System.out.println("Students Sorted By Average Grade (Increasing):");
        List<Student> sortedStudents = StudentManager.getInstance().sortAverageGradeIncreasing();
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /*
     * Test in ra danh sách sinh viên sắp xếp theo thứ tự điểm trung bình giảm dần.
     * Mỗi sinh viên trên một dòng, theo format được định nghĩa trong hàm toString() của Student.
     */
    public static void testSortAverageGradeDecreasing() {
        System.out.println("Students Sorted By Average Grade (Decreasing):");
        List<Student> sortedStudents = StudentManager.getInstance().sortAverageGradeDecreasing();
        StudentManager.print(sortedStudents);
        System.out.println();
    }

    /*
     * Test in ra danh sách sinh viên thi đỗ.
     * Mỗi sinh viên trên một dòng, theo format được định nghĩa trong hàm toString() của Student.
     */
    public static void testFilterPassStudents() {
        System.out.println("Pass Students (all grades > 4.0 and average > 5.0):");
        List<Student> passStudents = StudentManager.getInstance().filterPassStudents();
        StudentManager.print(passStudents);
        System.out.println();
    }

    /*
     * Test in ra danh sách sinh viên thi trượt.
     * Mỗi sinh viên trên một dòng, theo format được định nghĩa trong hàm toString() của Student.
     */
    public static void testFilterFailureStudents() {
        System.out.println("Failure Students (at least one grade < 4.0 or average < 5.0):");
        List<Student> failureStudents = StudentManager.getInstance().filterFailureStudents(
                StudentManager.getInstance().numberOfStudents());
        StudentManager.print(failureStudents);
        System.out.println();
    }
}
