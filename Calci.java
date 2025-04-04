import java.util.Arrays;

public class Calci {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("At least two operands are required to perform statistical calculations.");
            return;
        }

        String operation = args[0].toLowerCase();
        double[] numbers = new double[args.length - 1];

        for (int i = 1; i < args.length; i++) {
            try {
                numbers[i - 1] = Double.parseDouble(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number:" + args[i]);
                return;
            }
        }

        if (operation.equals("mean")) {
            System.out.println("Mean:" + Mean(numbers));
        } else if (operation.equals("median")) {
            System.out.println("Median:" + Median(numbers));
        } else if (operation.equals("mode")) {
            double mode = Mode(numbers);
            if (!Double.isNaN(mode)) {
                System.out.println("Mode:" + mode);
            }
        } else if (operation.equals("stddev")) {
            System.out.println("Standard Deviation" + Deviation(numbers));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public static double Mean(double[] numbers) {
        double sum = 0;
        for (double n : numbers) {
            sum += n;
        }
        return sum / numbers.length;
    }

    public static double Median(double[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        if (n % 2 == 0) {
            return (numbers[n / 2 - 1] + numbers[n / 2]) / 2.0;
        } else {
            return numbers[n / 2];
        }
    }

    public static double Mode(double[] numbers) {
        Arrays.sort(numbers);
        double mode = numbers[0];
        int max = 1;
        int count = 1;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == numbers[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if (count > max) {
                max = count;
                mode = numbers[i];
            }
        }
        if (max == 1) {
            System.out.println("No mode found!");
            return Double.NaN;
        }
        return mode;
    }

    public static double Deviation(double[] numbers) {
        double mean = Mean(numbers);
        double sum = 0;

        for (double n : numbers) {
            sum += Math.pow(n - mean, 2);
        }
        return Math.sqrt(sum / numbers.length);
    }
}