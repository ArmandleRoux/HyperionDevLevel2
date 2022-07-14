public class HyperionStudents {

  // Method to return the object class based on
  // the provided condition.
  public static Student getStudent(String student) {
    if(student == null) {
      return null;
    }
    if(student.equalsIgnoreCase("Susan")) {
      return new Susan();
    }
    else if(student.equalsIgnoreCase("Micheal")) {
      return new Micheal();
    }
    else if (student.equalsIgnoreCase("Saoirse")) {
      return new Saoirse();
    }

    return null;
  }
}
