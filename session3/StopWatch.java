package session3;

import java.util.Random;

public class StopWatch {
    private long startTime;
    private long endTime;

    StopWatch() {

    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public long start() {
        return this.startTime = System.currentTimeMillis();

    }

    public long stop() {
        return this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return getEndTime() - getStartTime();
    }

    public static void main(String[] args) {

        session3.StopWatch stopWatch = new session3.StopWatch();

        int[] randomArray = getArray();

        stopWatch.start();


        selectionSort(randomArray);

        stopWatch.stop();


        System.out.println("The execution time of sorting 100,000 " +
                "numbers using selection sort: " + stopWatch.getElapsedTime() +
                " milliseconds");
    }

    public static int[] getArray() {
        // Create an array of length 100,000
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        return array;
    }

    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = array[i];
            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }
    }
}

