package ru.alexanna;

public class Main {

    public static void main(String[] args) {
//        String[][] strArray = { {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"} };
        String[][] strArray = { {"1","1","1","1"}, {"1","1"}, {"1","1","1","1"}, {"1","1","1","1"} };
//        String[][] strArray = { {"1fsdf","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"}, {"1","1","1","1"} };
        try {
            int sum = sumArrayItems(strArray);
            System.out.println("Sum of array items: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public static int sumArrayItems(String[][] strArray) throws RuntimeException {
         if (strArray.length != 4 || strArray[0].length != 4 || strArray[1].length != 4 || strArray[2].length != 4 || strArray[3].length != 4) {
            throw new MyArraySizeException("Invalid array size");
        }
        int sum = 0;

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    try {
                        sum += Integer.parseInt(strArray[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException("Value is not parsable", e);
                    }
                }
            }

        return sum;
    }

}
