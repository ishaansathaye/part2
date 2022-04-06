import java.util.*;

public class Applicant {
    
    private final String name;
    private final List<CourseGrade> grades;
    private final double gpa;

    public Applicant(String name, List<CourseGrade> grades, double gpa) {
        this.name = name;
        this.grades = grades;
        this.gpa = gpa;
    }

    public Applicant(String name, List<CourseGrade> grades) {
        this.name = name;
        this.grades = grades;
        this.gpa = 4.0;
    }

    public String getName()
    {
      return name;
    }

    public List<CourseGrade> getGrades()
    {
      return grades;
    }

    public CourseGrade getGradeFor(String courseName)
    {
      for (CourseGrade grade : grades) {
        if (grade.getCourseName().equals(courseName)) {
          return grade;
        }
      }
      return null;
    }

    public double getGPA()
    {
      return gpa;
    }



}
