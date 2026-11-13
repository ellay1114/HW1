
public class Assignment01Q03 {

    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]);
        int numOdd = 0;
        long currVal = 1;
        long nextVal = 1;

        System.out.println("The first " + x + " Fibonacci numbers are:");

        for (int i = 0; i < x; i++) {
            System.out.print(currVal);

            if (currVal % 2 == 1) {
                numOdd++;
            }
            
            long valHolder = currVal + nextVal;
            currVal = nextVal;
            nextVal = valHolder;

            if (i < x - 1) {
                // Make sure we don't print a trailing space
                System.out.print(" ");
            }
        }
        System.out.println();
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
