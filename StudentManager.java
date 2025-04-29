package hus.oop.students;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    // Singleton pattern
    private static StudentManager instance;

    private List<Student> studentList;

    private StudentManager() {
        /* TODO */
        studentList = new ArrayList<>();
    }

    public static StudentManager getInstance() {
        /* TODO */
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    /**
     * Thêm sinh viên vào cuối danh sách.
     * @param student
     */
    public void append(Student student) {
        /* TODO */
        studentList.add(student);
    }

    /**
     * Thêm sinh viên vào danh sách ở vị trí index.
     * @param student
     * @param index
     */
    public void add(Student student, int index) {
        /* TODO */
        studentList.add(index, student);
    }

    /**
     * Xóa sinh viên ở vị trí index.
     * @param index
     */
    public void remove(int index) {
        /* TODO */
        studentList.remove(index);
    }

    /**
     * Lấy ra sinh viên ở vị trí index.
     * @param index
     * @return
     */
    public Student studentAt(int index) {
        /* TODO */
        return studentList.get(index);
    }

    /**
     * Trả về số student trong danh sách.
     * @return
     */
    public int numberOfStudents() {
        /* TODO */
        return studentList.size();
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên,
     * nếu tên như nhau thì sắp xếp theo họ.
     * Sử dụng giao diện StudentComparable để sắp xếp.
     * @return
     */
    public List<Student> sortStudentsByName() {
        /* TODO */
        for (int i = 0; i < studentList.size() - 1; i++) {
            for (int j = 0; j < studentList.size() - i - 1; j++) {
                if (studentList.get(j).compareTo(studentList.get(j + 1)) > 0) {
                    // Swap the hus.oop.students
                    Student temp = studentList.get(j);
                    studentList.set(j, studentList.get(j + 1));
                    studentList.set(j + 1, temp);
                }
            }
        }
        return studentList;
    }

    /**
     * Trả về danh sách sinh viên sắp xếp theo thứ tự điểm trung bình tăng dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * Không làm thay đổi thứ tự sinh viên trong danh sách ban đầu.
     * @return
     */
    public List<Student> sortAverageGradeIncreasing() {
        List<Student> sortedList = new ArrayList<>(studentList);

        StudentComparator comparator = new StudentComparator() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(left.getAverageGrade(), right.getAverageGrade());
            }
        };

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (comparator.compare(sortedList.get(j), sortedList.get(j + 1)) > 0) {
                    Student temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }

    /**
     * Trả về danh sách sinh viên sắp xếp theo thứ tự điểm trung bình giảm dần.
     * Sử dụng giao diện StudentComparator để sắp xếp.
     * Không làm thay đổi thứ tự sinh viên trong danh sách ban đầu.
     * @return
     */
    public List<Student> sortAverageGradeDecreasing() {
        /* TODO */
        List<Student> sortedList = new ArrayList<>(studentList);
        StudentComparator comparator = new StudentComparator() {
            @Override
            public int compare(Student left, Student right) {
                return Double.compare(right.getAverageGrade(), left.getAverageGrade());
            }
        };

        for (int i = 0; i < sortedList.size() - 1; i++) {
            for (int j = 0; j < sortedList.size() - i - 1; j++) {
                if (comparator.compare(sortedList.get(j), sortedList.get(j + 1)) > 0) {
                    Student temp = sortedList.get(j);
                    sortedList.set(j, sortedList.get(j + 1));
                    sortedList.set(j + 1, temp);
                }
            }
        }

        return sortedList;
    }

    /**
     * Lọc ra danh sách sinh viên có tất cả các điểm trên 4.0 và điểm trung bình trên 5.0.
     * @return
     */
    public List<Student> filterPassStudents() {
        /* TODO */
        List<Student> passStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMathsGrade() > 4.0 &&
                    student.getPhysicsGrade() > 4.0 &&
                    student.getChemistryGrade() > 4.0 &&
                    student.getAverageGrade() > 5.0) {
                passStudents.add(student);
            }
        }
        return passStudents;
    }

    /**
     * Lọc ra danh sách sinh viên có ít nhất 1 môn dưới 4.0 hoặc điểm trung bình dưới 5.0.
     * @param howMany
     * @return
     */
    public List<Student> filterFailureStudents(int howMany) {
        /* TODO */
        List<Student> failureStudents = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getMathsGrade() < 4.0 ||
                    student.getPhysicsGrade() < 4.0 ||
                    student.getChemistryGrade() < 4.0 ||
                    student.getAverageGrade() < 5.0) {
                failureStudents.add(student);
            }
            if (failureStudents.size() == howMany) {
                break;
            }
        }
        return failureStudents;
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student country : studentList) {
            idOfStudents.append(country.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}
