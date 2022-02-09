package ru.vsu.cs.course1;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.in;
import static java.lang.System.out;

public class Task {
//15. (*) Необходимо из списка чисел путем вычеркивания некоторых чисел, не меняя порядка
//остальных, составить максимально длинный новый список чисел, образующих
//арифметическую прогрессию. Будем считать, что два любых числа (или одно для списка
//из одного элемента) всегда образуют такую прогрессию. Если можно составить
//несколько таких списков одинаковой максимальной длины, разрешается составить
//любой, например:
//{ 11, 3, 2, 5, 4, 7, 7, 1, 4, 6, 9, 8, 8, 7, 1, 3, 2 } →
// { 3, 5, 7, 9 }
//или { 2, 4, 6, 8 }
//или { 5, 4, 3, 2 }

     public static ArrayList<Integer> createNewList(ArrayList<Integer> list) {
         ArrayList<ArrayList<Integer>> container = new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> result = new ArrayList<>();
         int len = list.size(), max = 0;

         for (int i = 0; i < len - 1; i++) {
             for (int j = i + 1; j < len; j++) {
                 ArrayList<Integer> current = new ArrayList<>();
                 current.add(list.get(i));
                 current.add(list.get(j));
                 int prev = list.get(j); //предыдущий член найденной прогрессии
                 int d = list.get(j) - list.get(i); //разность прогрессии

                 for (int k = j + 1; k < len; k++) {
                     if (list.get(k) - prev == d) {
                         current.add(list.get(k));
                         prev = list.get(k);
                     }
                 }

                 max = Math.max(max, current.size());
                 container.add(current);
             }
         }

         for (ArrayList<Integer> x : container) {
             if (x.size() == max) {
                 result = x;
                 break;
             }
         }

         return result;
     }

     public static ArrayList<Integer> arrToList(int[] arr){
         ArrayList<Integer> list = new ArrayList<>();
         for (int cur : arr){
            list.add(cur);
        }
        return list;
    }
    public static int[] listToArr(ArrayList<Integer> list){
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }
}
