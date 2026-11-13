
public class Assignment01Q02 {

    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int n = Integer.parseInt(args[0]);

        for (int i = 1; i <= n; i++) {
            double currFraction = 1.0 / (2.0 * i - 1.0);
            if (i % 2 == 0) {
                approxPi -= currFraction;
            } else {
                approxPi += currFraction;
            }
        }

        approxPi = 4 * approxPi;

        System.out.println(approxPi + " " + actualPi);
    }
}
