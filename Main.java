package ru.alexanna.lesson_5;

public class Main {
    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();
        recalculateArrayValues(arr);
        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    public static void secondMethod() {
        int size = 10_000_000;
        float[] arr = new float[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1.0f;
        }
        long startTime = System.currentTimeMillis();

        int newSize = 5_000_000;
        float[] leftArray = new float[newSize];
        float[] rightArray = new float[newSize];

        System.arraycopy(arr, 0, leftArray, 0, newSize);
        System.arraycopy(arr, newSize, rightArray, 0, newSize);

        Thread firstThread = new Thread( () -> {
            recalculateArrayValues(leftArray);
        });

        Thread secondThread = new Thread( () -> {
            recalculateArrayValues(rightArray);
        });

        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] mergedArray = new float[size];
        System.arraycopy(leftArray, 0, mergedArray, 0, newSize);
        System.arraycopy(rightArray, 0, mergedArray, newSize, newSize);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private static void recalculateArrayValues(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }

}
