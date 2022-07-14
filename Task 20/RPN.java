import java.util.Scanner;

class RPN {

  private String equation;
  private StackNode eqStack;

  // Constructor
  public RPN(String equation) {
    this.eqStack = null;
    this.equation = equation;
  }

  // Add new data to stack.
  public void addToStack(double data) {
    eqStack = new StackNode(data, eqStack);
  }

  // Retrieve last added data from stack.
  public double removeFromStack( ) {
    double top_data = eqStack.data;
    eqStack = eqStack.getUnderneath();
    return top_data;
  }

  /* Split input of user to get the numbers and operator entered.
  *  Add numbers to stack and determine operator. Once you have the
  *  operator calculate the result and add it to the stack. Return
  *  the answer retrieved from the stack.*/
  public double getAnswer( ) {
    double num1;
    double num2;
    int j = 0;

    for(int i = 0; i < equation.length( ); i = j) {
      // Check if it's num1 digit.
      if(Character.isDigit(equation.charAt(i))) {
        double number;

        // Get num1 string of the number.
        StringBuilder strBuilder = new StringBuilder("");
        try {
          for (j = i; (j < 100)
                  && (Character.isDigit(equation.charAt(j))
                  || (equation.charAt(j) == '.')); j++) {
            strBuilder.append(equation.charAt(j));
          }
        } catch (StringIndexOutOfBoundsException ignored){}

        String numberStr = strBuilder.toString();

        // Convert to double and add to the stack.
        number = Double.parseDouble(numberStr);
        addToStack(number);

        /* Determine operator and retrieve entered numbers from stack.
        *  Calculate result and add result to stack.*/
      } else if(equation.charAt(j) == '+') {
        num2 = removeFromStack( );
        num1 = removeFromStack( );
        addToStack(num1 + num2);
      } else if(equation.charAt(i) == '-') {
        num2 = removeFromStack( );
        num1 = removeFromStack( );
        addToStack(num1 - num2);
      } else if(equation.charAt(i) == '*') {
        num2 = removeFromStack( );
        num1 = removeFromStack( );
        addToStack(num1 * num2);
      } else if(equation.charAt(i) == '/') {
        num2 = removeFromStack( );
        num1 = removeFromStack( );
        addToStack(num1 / num2);
      } else if(equation.charAt(i) == '^') {
        num2 = removeFromStack( );
        num1 = removeFromStack( );
        addToStack(Math.pow(num1, num2));
      } else if (equation.charAt(i) != ' ') {
        throw new IllegalArgumentException( );
      }
      j++;
    }
    // Retrieve answer from stack.
    double answer = removeFromStack( );

    if(eqStack != null) {
      throw new IllegalArgumentException( );
    }
    return answer;
  }

  /* main method
  *
  * Ask user to enter an RPN expression and read the
  * calculated result to console.*/
  public static void main(String[] args) {
    while(true) {
      Scanner input = new Scanner(System.in);

      String errorMessage = """
              Input Error!
              Please enter 2 numbers followed by an operator.
              (eg. 15 20 *)""";

      System.out.println("Enter RPN expression or \"quit\".");
      String line = input.nextLine( );

      if(line.equals("quit")) {
        break;
      }
      else {
        try {
          RPN calculation = new RPN(line);
          System.out.printf("Answer is %f%n", calculation.getAnswer());
        } catch (IllegalArgumentException | NullPointerException e) {
          System.out.println(errorMessage);
        }
      }
    }
  }
}

class StackNode {
  private StackNode underneath;
  public double data;

  // Constructor
  public StackNode(double data, StackNode lastIn) {
    this.data = data;
    this.setUnderneath(lastIn);
  }

  // Return last added data.
  public StackNode getUnderneath() {
    return underneath;
  }

  // Add data to stack.
  public void setUnderneath(StackNode underneath) {
    this.underneath = underneath;
  }
}