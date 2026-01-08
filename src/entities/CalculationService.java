package entities;

import java.util.TreeSet;

public class CalculationService {
    public static <T extends Comparable<T>> T max(TreeSet<T> treeSet) { 
        //<T extends Comparable<T>> indica que a arvore passada precisa ser de objetos que implementam Comparable
        //tipos primitivos não implementam interfaces, por isso não podem ser usados como tipos genéricos nesse caso
        //whrapper classes (Integer, Double, etc) implementam Comparable, por isso podem ser usados como tipos genéricos nesse caso
        if (treeSet.isEmpty()) {
        throw new IllegalStateException("List can't be empty");
        }

        T max = treeSet.first();
        for (T item : treeSet) {
            if (item.compareTo(max) > 0) {
            max = item;
            }
        }

        return max;
    }
}