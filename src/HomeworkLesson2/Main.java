package HomeworkLesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Задание 1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;

        System.out.println("Задание 1");
        System.out.print("Массив перед изменением: ");
        int[] firstArray = {1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0};
        for (int i = 0; i < firstArray.length; i++) {
            System.out.print(firstArray[i] + " ");
        }
        System.out.println();
        System.out.print("Массив после изменения:  ");
        for (int i = 0; i < firstArray.length; i++) {
            if (firstArray[i] == 1) {
                firstArray[i] = 0;
            } else {
                firstArray[i] = 1;
            }
            System.out.print(firstArray[i] + " ");
        }

        //Задание 2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;

        System.out.println();
        System.out.println("Задание 2");
        int[] secondArray = new int[8];
        for (int i = 0, j = 0; i < secondArray.length; j = j + 3, i++) {
            secondArray[i] = j;
            System.out.print(secondArray[i] + " ");
        }

        //Задание 3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;

        System.out.println();
        System.out.println("Задание 3");
        int[] thirdArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < thirdArray.length; i++) {
            if (thirdArray[i] < 6) {
                thirdArray[i] = thirdArray[i] * 2;
            }
            System.out.print(thirdArray[i] + " ");
        }

        //Задание 4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое), и с помощью цикла(-ов) заполнить его диагональные элементы единицами;

        System.out.println();
        System.out.print("Задание 4");
        int[][] fifthArray = new int[9][9];
        for (int i = 0; i < fifthArray.length; i++) {
            System.out.println();
            for (int j = 0; j < fifthArray[i].length; j++) {
                if (i == j || i + j == fifthArray.length - 1) {
                    fifthArray[i][j] = 1;
                }
                System.out.print(fifthArray[i][j] + " ");
            }
        }

        //Задание 5. ** Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);

        System.out.println();
        System.out.println("Задание 5");
        int[] sixthArray = {5, 2, 3, 1, 4, 5, 6, 9, 7, 8};
        int max = sixthArray[0];
        int min = sixthArray[1];
        for (int i = 0; i < sixthArray.length; i++) {
            if (sixthArray[i] > max) {
                max = sixthArray[i];
            } else if (sixthArray[i] < min) {
                min = sixthArray[i];
            }
        }
        System.out.println("Максимальный элемент: " + max + ", минимальный элемент: " + min);

        //Задание 6. ** Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true, если в массиве есть место, в котором сумма левой и правой части массива равны. Примеры: checkBalance([2, 2, 2, 1, 2, 2, || 10, 1]) → true, checkBalance([1, 1, 1, || 2, 1]) → true, граница показана символами ||, эти символы в массив не входят.

        System.out.println("Задание 6");

        int[] newArray = {1, 2, 3, 4, 8, 2};
        System.out.println(checkBalance(newArray));

        //Задание 7. **** Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично. Для усложнения задачи нельзя пользоваться вспомогательными массивами. Примеры: [ 1, 2, 3 ] при n = 1 (на один вправо) -> [ 3, 1, 2 ]; [ 3, 5, 6, 1] при n = -2 (на два влево) -> [ 6, 1, 3, 5 ]. При каком n в какую сторону сдвиг можете выбирать сами.

        System.out.println("Задание 7");
        int[] newArray2 = {1, 2, 3, 4, 5, 6, 8};
        System.out.println(Arrays.toString(newArray2));
        shiftArray(newArray2, 5);
    }

    public static boolean checkBalance(int[] array) {
        int leftSide = 0;
        for (int i = 0; i < array.length; i++) {
            leftSide += array[i];
            int rightSide = 0;
            for (int j = 0; j < array.length; j++) {
                if (j > i) {
                    rightSide += array[j];
                } else {
                    rightSide += 0;
                }
            }
            if (leftSide == rightSide) {
                return true;
            }
        }
        return false;
    }

    //Не смог сделать метод без использования вспомогательных массивов. Только с помощью них
    public static void shiftArray(int[] array, int n) {
        if (n > 0) {
            int[] destination = new int[array.length + n];
            System.arraycopy(array, 0, destination, n, array.length);
            for (int i = 0; i < n; i++) {
                destination[i] = destination[destination.length - n + i];
            }
            int[] finish = new int[array.length];
            System.arraycopy(destination, 0, finish, 0, array.length);
            System.out.println(Arrays.toString(finish));
        }
        if (n < 0) {
            int[] destination = new int[array.length - n];
            System.arraycopy(array, 0, destination, 0, array.length);
            for (int i = 0; i < -n; i++) {
                destination[destination.length + n + i] = destination[i];
            }
            int[] finish = new int[array.length];
            System.arraycopy(destination, -n, finish, 0, array.length);
            System.out.println(Arrays.toString(finish));
        }
    }
}





