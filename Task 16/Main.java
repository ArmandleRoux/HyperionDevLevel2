public class Main {

  public static void main(String[] args) {

    // Testing of implementation of the factory design pattern.
    Student student1 = HyperionStudents.getStudent("susan");
    student1.create();

    Student student2 = HyperionStudents.getStudent("micheal");
    student2.create();

    Student student3 = HyperionStudents.getStudent("saoirse");
    student3.create();
  }
}
