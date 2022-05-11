package variables;

import java.text.DecimalFormat;

public class School {

    private int classroomCount = 10;
    private int studentCount = 86;
    private int teacherCount = 14;
    private int averageTeacherSalary = 70000;
    private double totalExpenditure = 1206720.86;
    private double totalBudget = 1500000;
    private String schoolName = "Red Mountain High School";
    boolean isAccredited = true;

    public void main() {
        System.out.println("Students per classroom: " + studentsPerClassroom());
        System.out.println("Cost per student: " + costPerStudent());
        System.out.println("Cost per classroom: " + costPerClassroom());
        System.out.println("Cost is within budget: " + isWithinBudget());
    }

    private double roundToNearestCent(double num) {
        DecimalFormat round = new DecimalFormat("###.##");
        return Double.parseDouble(round.format(num));
    }

    private boolean isWithinBudget() {
        return  totalBudget > totalExpenditure;
    }

    private double costPerStudent() {
        double cost = (totalExpenditure - (averageTeacherSalary * teacherCount)) / studentCount;
        return roundToNearestCent(cost);
    }

    private int studentsPerClassroom() {
        double equation = (double)studentCount / classroomCount;
        Long rounded = Math.round(equation);
        return rounded.intValue();
    }

    private double costPerClassroom() {
        double cost = costPerStudent() * studentsPerClassroom();
        return roundToNearestCent(cost);
    }

}
