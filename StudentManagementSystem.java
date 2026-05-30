import java.util.Scanner;

/**
 * Student Management System
 * Calculates student grades, GPA, and semester fee with scholarship discounts.
 * Author: Mahnoor Shahbaz
 */
public class StudentManagementSystem {

    // ─── CONSTANTS ───────────────────────────────────────────
    static final double GPA_A = 4.0;
    static final double GPA_B = 3.0;
    static final double GPA_C = 2.0;
    static final double GPA_D = 1.0;

    static final double SCHOLARSHIP_A = 0.30;
    static final double SCHOLARSHIP_B = 0.20;
    static final double SCHOLARSHIP_C = 0.10;

    // ─── INPUT STUDENT DATA ───────────────────────────────────
    public static void inputStudentData(String[] names, int[][] marks, Scanner scanner) {
        for (int i = 0; i < names.length; i++) {
            System.out.print("\nEnter student " + (i + 1) + " name: ");
            names[i] = scanner.next();

            for (int j = 0; j < marks[i].length; j++) {
                int mark;
                do {
                    System.out.print("Enter marks for subject " + (j + 1) + " (0-100): ");
                    mark = scanner.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid marks. Please enter a value between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);
                marks[i][j] = mark;
            }
        }
    }

    // ─── CALCULATE TOTAL MARKS ────────────────────────────────
    public static int calculateTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) total += mark;
        return total;
    }

    // ─── CALCULATE AVERAGE ────────────────────────────────────
    public static double calculateAverage(int total, int subjectCount) {
        return (double) total / subjectCount;
    }

    // ─── GET LETTER GRADE FROM AVERAGE ───────────────────────
    public static String getGrade(double average) {
        if (average >= 85) return "A";
        if (average >= 75) return "B";
        if (average >= 65) return "C";
        if (average >= 50) return "D";
        return "F";
    }

    // ─── CONVERT GRADE TO GPA ─────────────────────────────────
    public static double getGPA(String grade) {
        switch (grade) {
            case "A": return GPA_A;
            case "B": return GPA_B;
            case "C": return GPA_C;
            case "D": return GPA_D;
            default:  return 0.0;
        }
    }

    // ─── CALCULATE FEE AFTER SCHOLARSHIP ─────────────────────
    public static double calculateFeeAfterScholarship(double baseFee, double gpa) {
        double scholarshipRate = 0;
        if (gpa == GPA_A)      scholarshipRate = SCHOLARSHIP_A;
        else if (gpa >= GPA_B) scholarshipRate = SCHOLARSHIP_B;
        else if (gpa >= GPA_C) scholarshipRate = SCHOLARSHIP_C;
        return baseFee - (baseFee * scholarshipRate);
    }

    // ─── DISPLAY RESULT SHEET ─────────────────────────────────
    public static void displayResultSheet(String[] names, int[][] marks, double baseFee) {
        double classTotalAverage = 0;

        String line = "-----------------------------------------------------------------";

        System.out.println("\n" + line);
        System.out.println("|                        RESULT SHEET                          |");
        System.out.println(line);
        System.out.printf("| %-15s | %-7s | %-9s | %-5s | %-3s | %-8s |%n",
                "Name", "Total", "Average", "Grade", "GPA", "Fee(PKR)");
        System.out.println(line);

        for (int i = 0; i < names.length; i++) {
            int    total   = calculateTotal(marks[i]);
            double average = calculateAverage(total, marks[i].length);
            String grade   = getGrade(average);
            double gpa     = getGPA(grade);
            double fee     = calculateFeeAfterScholarship(baseFee, gpa);

            classTotalAverage += average;

            System.out.printf("| %-15s | %-7d | %-9.2f | %-5s | %-3.1f | %-8.0f |%n",
                    names[i], total, average, grade, gpa, fee);
        }

        double classAverage = classTotalAverage / names.length;
        System.out.println(line);
        System.out.printf("| Class Average: %-47.2f|%n", classAverage);
        System.out.println(line);
    }

    // ─── MAIN METHOD ──────────────────────────────────────────
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== STUDENT MANAGEMENT SYSTEM ===");

        System.out.print("Enter number of students: ");
        int studentCount = scanner.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjectCount = scanner.nextInt();

        System.out.print("Enter base semester fee (PKR): ");
        double baseFee = scanner.nextDouble();

        String[] names = new String[studentCount];
        int[][]  marks = new int[studentCount][subjectCount];

        inputStudentData(names, marks, scanner);
        displayResultSheet(names, marks, baseFee);

        scanner.close();
    }
}