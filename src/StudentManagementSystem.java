import java.util.*;

public class StudentManagementSystem {

    public static void inputData(String names[], int marks[][], Scanner sc) {
        for (int i = 0; i < names.length; i++) {
            System.out.print("\nEnter student " + (i+1) + " name: ");
            names[i] = sc.next();

            for (int j = 0; j < marks[i].length; j++) {
                int m;
                do {
                    System.out.print("Enter marks of subject " + (j+1) + " (0-100): ");
                    m = sc.nextInt();
                } while (m < 0 || m > 100);
                marks[i][j] = m;
            }
        }
    }

    public static int calcTotal(int arr[]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }

    public static double calcAverage(int total, int subjects) {
        return (double) total / subjects;
    }

    public static String getGrade(double avg) {
        if (avg >= 85) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 65) return "C";
        else if (avg >= 50) return "D";
        else return "F";
    }

    public static double gradeToGPA(String grade) {
        if (grade.equals("A")) return 4.0;
        if (grade.equals("B")) return 3.0;
        if (grade.equals("C")) return 2.0;
        if (grade.equals("D")) return 1.0;
        return 0.0;
    }

    public static double calculateFee(double baseFee, double gpa) {
        double scholarship = 0;

        if (gpa == 4.0) scholarship = 0.30;
        else if (gpa >= 3.0) scholarship = 0.20;
        else if (gpa >= 2.0) scholarship = 0.10;

        return baseFee - (baseFee * scholarship);
    }

    public static void displayResult(String names[], int marks[][], double baseFee) {
        double classTotalAvg = 0;

        System.out.println("\n=========== RESULT SHEET ===========");
        System.out.printf("%-12s %-10s %-10s %-8s %-10s\n",
                "Name","Total","Average","Grade","Fee");

        for (int i = 0; i < names.length; i++) {
            int total = calcTotal(marks[i]);
            double avg = calcAverage(total, marks[i].length);
            classTotalAvg += avg;

            String grade = getGrade(avg);
            double gpa = gradeToGPA(grade);
            double fee = calculateFee(baseFee, gpa);

            System.out.printf("%-12s %-10d %-10.2f %-8s %-10.0f\n",
                    names[i], total, avg, grade, fee);
        }

        double classAvg = classTotalAvg / names.length;
        System.out.println("\nClass Average = " + String.format("%.2f", classAvg));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();

        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        System.out.print("Enter base semester fee: ");
        double baseFee = sc.nextDouble();

        String names[] = new String[students];
        int marks[][] = new int[students][subjects];

        inputData(names, marks, sc);
        displayResult(names, marks, baseFee);
    }
}