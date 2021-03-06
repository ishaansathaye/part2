import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;


public class TestCases
{
   /*
    * This test is just to get you started.
    */
   @Test
   public void testGetName()
   {
      // This will not compile until you implement the Applicant class
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("Aakash", grades, 3.2);
      assertEquals("Aakash", testApplicant.getName());
   }

   @Test
   public void testGetGrades()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("S1", grades, 3.9);
      assertEquals(grades, testApplicant.getGrades());
   }

   @Test
   public void testGetGradesFor()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("S2", grades, 3.1);
      assertEquals(grades.get(3), testApplicant.getGradeFor("Computer Organization"));
   }

   @Test
   public void testGetGPA()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 75),
         new CourseGrade("Non-CS", 83)
      );
      Applicant testApplicant = new Applicant("S3", grades, 3.1);
      assertEquals(3.1, testApplicant.getGPA(), 0.001);
   }

   @Test
   public void testSimpleIf1()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 100),
         new CourseGrade("Data Structures", 95),
         new CourseGrade("Algorithms", 91),
         new CourseGrade("Computer Organization", 91),
         new CourseGrade("Operating Systems", 69),
         new CourseGrade("Non-CS", 75)
      );
      Applicant testApplicant = new Applicant("Student1", grades, 3.1);
      assertFalse("Testing if applicant passes", SimpleIf.analyzeApplicant2(testApplicant));
   }

   @Test
   public void testSimpleIf2()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 76),
         new CourseGrade("Data Structures", 89),
         new CourseGrade("Algorithms", 90),
         new CourseGrade("Computer Organization", 65),
         new CourseGrade("Operating Systems", 90),
         new CourseGrade("Non-CS", 88)
      );
      Applicant testApplicant = new Applicant("Student2", grades, 3.3);
      assertFalse("Testing if applicant passes", SimpleIf.analyzeApplicant2(testApplicant));
   }

   @Test
   public void testSimpleIf3()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 90),
         new CourseGrade("Data Structures", 90),
         new CourseGrade("Algorithms", 90),
         new CourseGrade("Computer Organization", 90),
         new CourseGrade("Operating Systems", 90),
         new CourseGrade("Non-CS", 71)
      );
      Applicant testApplicant = new Applicant("Student3", grades, 3.3);
      assertFalse("Testing if applicant passes", SimpleIf.analyzeApplicant2(testApplicant));
   }

   @Test
   public void testSimpleIf4()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 90),
         new CourseGrade("Data Structures", 90),
         new CourseGrade("Algorithms", 90),
         new CourseGrade("Computer Organization", 90),
         new CourseGrade("Operating Systems", 90),
         new CourseGrade("Non-CS", 80)
      );
      Applicant testApplicant = new Applicant("Student4", grades, 3.3);
      assertTrue("Testing if applicant passes", SimpleIf.analyzeApplicant2(testApplicant));
   }

   @Test
   public void testSimpleIf5()
   {
      List<CourseGrade> grades = Arrays.asList(
         new CourseGrade("Intro to CS", 85),
         new CourseGrade("Data Structures", 90),
         new CourseGrade("Algorithms", 90),
         new CourseGrade("Computer Organization", 88),
         new CourseGrade("Operating Systems", 90),
         new CourseGrade("Non-CS", 75)
      );
      Applicant testApplicant = new Applicant("Student5", grades, 4.0);
      assertTrue("Testing if applicant passes", SimpleIf.analyzeApplicant2(testApplicant));
   }

   /*
    * The tests below here are to verify the basic requirements regarding
    * the "design" of your class.  These are to remain unchanged.
    */
   // @Test
   // public void testImplSpecifics()
   //    throws NoSuchMethodException
   // {
   //    final List<String> expectedMethodNames = Arrays.asList(
   //       "getName",
   //       "getGrades",
   //       "getGradeFor"
   //    );

   //    final List<Class> expectedMethodReturns = Arrays.asList(
   //       String.class,
   //       List.class,
   //       CourseGrade.class
   //    );

   //    final List<Class[]> expectedMethodParameters = Arrays.asList(
   //       new Class[0],
   //       new Class[0],
   //       new Class[] { String.class }
   //       );

   //    verifyImplSpecifics(Applicant.class, expectedMethodNames,
   //       expectedMethodReturns, expectedMethodParameters);
   // }

   // private static void verifyImplSpecifics(
   //    final Class<?> clazz,
   //    final List<String> expectedMethodNames,
   //    final List<Class> expectedMethodReturns,
   //    final List<Class[]> expectedMethodParameters)
   //    throws NoSuchMethodException
   // {
   //    // assertEquals(0, Applicant.class.getFields().length,
   //    //         "Unexpected number of public fields");
   //    assertEquals("Unexpected number of public fields", 0, Applicant.class.getFields().length);

   //    final List<Method> publicMethods = Arrays.stream(
   //       clazz.getDeclaredMethods())
   //          .filter(m -> Modifier.isPublic(m.getModifiers()))
   //          .collect(Collectors.toList());

   //    // assertTrue(expectedMethodNames.size()+1 >= publicMethods.size(),
   //    //         "Unexpected number of public methods");
   //    assertTrue("Unexpected number of public methods", expectedMethodNames.size()+1 >= publicMethods.size());
   //    // assertTrue(expectedMethodNames.size() == expectedMethodReturns.size(),
   //    //         "Invalid test configuration");
   //    assertTrue("Invalid test configuration", expectedMethodNames.size() == expectedMethodReturns.size());
   //    // assertTrue(expectedMethodNames.size() == expectedMethodParameters.size(),
   //    //         "Invalid test configuration");
   //    assertTrue("Invalid test configuration", expectedMethodNames.size() == expectedMethodParameters.size());

   //    for (int i = 0; i < expectedMethodNames.size(); i++)
   //    {
   //       Method method = clazz.getDeclaredMethod(expectedMethodNames.get(i),
   //          expectedMethodParameters.get(i));
   //       assertEquals(expectedMethodReturns.get(i), method.getReturnType());
   //    }
   // }
}
