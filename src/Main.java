import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner keyIn = new Scanner(System.in); // creating a scanner object
        double answer = 0;
        int redo;

        do {
        System.out.print("Enter your first number> "); // prompting user for first value
        double num1 = keyIn.nextDouble(); // storing the first value in a double (num1)
        keyIn.nextLine(); // consumes remaining new line characters
        System.out.print("Please enter your operation of choice. (+, -, x, /)> "); // prompting user for operation
        String n = keyIn.nextLine(); // storing the operation in a temporary string (n)
        System.out.print("Enter your second number> "); // prompting user for second value
        double num2 = keyIn.nextDouble(); // storing the second value in a double (num2)
        keyIn.nextLine(); // consumes remaining new line characters
        char operation = n.toLowerCase().charAt(0); // converting and storing the operation to a character at position zero
        Operations calculator = new Operations();

            try {
                switch (operation) { // starting the switch case for the char operation

                    case '+': { // addition operation
                        answer = calculator.add(num1, num2);
                        break;
                    }

                    case '-': { // subtraction operation
                        answer = calculator.subtract(num1, num2);
                        break;
                    }

                    case 'x': { // multiplication operation
                        answer = calculator.multiply(num1, num2);
                        break;
                    }

                    case '/': { // division operation
                        answer = calculator.divide(num1, num2);
                        break;
                    }
                }
            } catch (ArithmeticException e) {
                throw new ArithmeticException("Cannot divide by zero");
            } catch (Exception e) { // in case of any unaccounted for error
                String message = e.getMessage();
            }
            System.out.println(answer);

            do {

                System.out.print("Again? (1.yes or 2.exit) > ");
                redo = keyIn.nextInt();

                if(redo == 1){
                    System.out.println();
                }
                if(redo == 2){
                    System.out.println("Exiting...");
                }
                else{
                    System.out.println("Error! Please select one of the valid options\n");
                }
            } while(redo != 1 && redo != 2);

        } while(redo != 2);
    }
}