import java.util.*;

public class SimpleIf {

  /**
   * Takes an applicant's average score and accepts the applicant if the average
   * is higher than 85.
   * 
   * @param avg The applicant's average score
   * @param threshold The threshold score
   * @return true if the applicant's average is over the threshold, and false otherwise
   */
  public static boolean analyzeApplicant(double avg, double threshold) {
    /*
     * TO DO: Write an if statement to determine if the avg is larger than the threshold and
     * return true if so, false otherwise
     */
    for (int i = 0; i < avg; i++) {
      if (avg > threshold) {
        return true;
      }
    }

    return false; // A bit pessimistic!
  }

  /**
   * Takes two applicants' average scores and returns the score of the applicant
   * with the higher average.
   * 
   * @param avg1 The first applicant's average score
   * @param avg2 The second applicant's average score
   * @return the higher average score
   */
  public static double maxAverage(double avg1, double avg2) {
    /*
     * TO DO: Write an if statement to determine which average is larger and return
     * that value.
     */
    if (avg1 > avg2) {
      return avg1;
    } else if (avg2 > avg1) {
      return avg2;
    } else if (avg1 == avg2) {
      return avg1;
    }

    return 0; // Clearly not correct, but testable.
  }

  public static boolean analyzeApplicant2(Applicant applicant) {
    /**
     * This filtering algorithms works on checks that need to be passed.
     * The first check is if the overall gpa that the applicant has is higher than 
     * the overall gpa threshold.
     * The next check is if the cs courses have an average score that is higher than the
     * threshold of 85. In this check, the algo also checks if the applicant is well-rounded
     * so it ensures that the Non-CS grade is greater than or equal to 80.
     * After that the algorithm checks whether at least 4 of the courses in the course list
     * are greater than the threshold of 85.
     * Then the algorithm checks if their lowest grade is acceptable enough to considered
     * for an interview.
     * These checks then are evaluated to determine if the sufficient conditions are met.
     * This algorithm checks for applicants that are satisfy all criteria and are overall
     * a good fit for the company.
     * If the sufficient number of checks are met then the algorithm returns true, which is
     * when means that the applicant can schedule an interview.
     */
    int threshold = 85;

    double overall_gpa_check;;
    int avg_cs = 0;
    int non_cs = 0;
    int course_4 = 0;
    int lowest_grade = 0;

    //Checking if overall GPA is acceptable
    overall_gpa_check = (applicant.getGPA()/4.0)*100;

    //Checking if the average of all the non cs grades is acceptable
    List<Integer> course_grades = new ArrayList<Integer>();
    List<CourseGrade> grades = applicant.getGrades();
    int sumGrades = 0;
    for (CourseGrade grade : grades) {
      course_grades.add(grade.getScore());
      if (grade.getCourseName() != "Non-CS") {
        sumGrades += grade.getScore();
      } else {
        //Checks if the non cs grade is acceptable
        if (grade.getScore() >= 80) {
          non_cs = 100;
        } else if (grade.getScore() >= 70 && grade.getScore() < 80) {
          non_cs = 75;
        } else {
          non_cs = 50;
        }
      }
    }
    avg_cs = (sumGrades/5);

    //Checking if at least 4 of the courses are over threshold
    int counter = 0;
    for (int i = 0; i < course_grades.size(); i++) {
      if (course_grades.get(i) > threshold)  {
        counter++;
      }
    }
    if (counter >=4) {
      course_4 = 100;
    } else if (counter >= 3 && counter < 4) {
      course_4 = 75;
    } else {
      course_4 = 50;
    }

    //Checking if the lowest score is over 70
    if (Collections.min(course_grades) > 70) {
      lowest_grade = 100;
    } else if (Collections.min(course_grades) >= 60 && Collections.min(course_grades) < 70) {
      lowest_grade = 75;
    } else {
      lowest_grade = 50;
    }

    //Creating the weighted equation and then checking if the applicant is qualified
    double equation = (0.2*overall_gpa_check + 0.3*avg_cs + 0.1*course_4 + 0.2*lowest_grade + 0.2*non_cs);
    System.out.println(equation + ": " + overall_gpa_check + " " + avg_cs + " " + course_4 + " " + lowest_grade + " " + non_cs);
    if (equation >= 90) {
      return true;
    } else {
      return false;
    }

  }
}
