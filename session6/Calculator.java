package session6;

public class Calculator {
     static final char ADDITION = '+';
     static final char SUBTRACTION = '-';
     static final char MULTIPLICATION = '*';
     static final char DIVISION = '/';

    public static int calculate(int firtNumber, int seconNumber, char operator) {
        switch (operator) {
            case ADDITION:
                return firtNumber + seconNumber;
            case SUBTRACTION:
                return firtNumber - seconNumber;
            case MULTIPLICATION:
                return firtNumber * seconNumber;
            case DIVISION:
                if (seconNumber != 0)
                    return firtNumber / seconNumber;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }
}
