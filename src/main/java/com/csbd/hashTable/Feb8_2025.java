package com.csbd.hashTable;

import java.util.*;

public class Feb8_2025 {
    private final Map<Integer, Integer> indexToNumber;
    private final Map<Integer, Set<Integer>> numberToIndexes;

    public Feb8_2025() {
        indexToNumber = new HashMap<>();
        numberToIndexes = new HashMap<>();
    }

    public void change(int index, int number) {
        Integer previousNumber = indexToNumber.get(index);
        if (previousNumber != null) {
            Set<Integer> previousQueue = numberToIndexes.getOrDefault(previousNumber, new TreeSet<>());
            previousQueue.remove(index);
        }
        indexToNumber.put(index, number);
        Set<Integer> queue = numberToIndexes.getOrDefault(number, new TreeSet<>());
        queue.add(index);
        numberToIndexes.put(number, queue);
    }

    public int find(int number) {
        Set<Integer> indexes = numberToIndexes.get(number);
        if (indexes == null || indexes.isEmpty())
            return -1;
        return indexes.stream().findFirst().get();
    }

    public static void main(String[] args) {
        Feb8_2025 input =  new Feb8_2025();
        input.change(2, 10);
        input.change(1, 10);
        input.change(3, 10);
        input.change(5, 10);
        input.change(1, 20);
    }
}
