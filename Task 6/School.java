package level_2;

public class School
{
  public static void main (String [] args)
  {
    // Declaration of classes
    Student sally = new Student("Sally", 15, 8, 'D');
    Student sipho = new Student("Sipho", 17 , 11, 'A');
    Student rajesh = new Student("Rajesh", 19, 12, 'B');

    Teacher jade = new Teacher("Jade", "English", 150, 5, 15000);
    Teacher adam = new Teacher("Adam", "Economics", 75, 3, 10000);
    Teacher lana = new Teacher("Lana", "Math", 150, 5, 25000);

    Secretary mia = new Secretary("Mia", "Main", "1", "Main Office Secretary", 15000);
    Secretary janet = new Secretary("Janet", "Accounting", "7", "Accountant", 25000);
    Secretary ashley = new Secretary("Ashley", "Main", "2", "Main Office Secretary", 15000);

    // Testing of toString()
    System.out.println("Students\n");
    System.out.println(sally + "\n");
    System.out.println(sipho + "\n");
    System.out.println(rajesh + "\n");

    System.out.println("Teachers:\n");
    System.out.println(jade + "\n");
    System.out.println(adam + "\n");
    System.out.println(lana + "\n");

    System.out.println("Secretaries:\n");
    System.out.println(mia + "\n");
    System.out.println(janet + "\n");
    System.out.println(ashley + "\n");
  }
}