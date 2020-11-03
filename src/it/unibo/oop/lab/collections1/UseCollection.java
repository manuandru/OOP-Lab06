package it.unibo.oop.lab.collections1;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Example class using {@link java.util.List} and {@link java.util.Map}.
 * 
 */
public final class UseCollection {

	private static final int NUM1 = 1000;
	private static final int NUM2 = 2000;
    private static final int TO_MS = 1_000_000;
	
	
	
    private UseCollection() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
    	final List<Integer> arrayList = new ArrayList<>();
    	
    	for (int i = NUM1; i < NUM2 ; i++) {
    		arrayList.add(i);
    	}
    	
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
    	final List<Integer> linkedList = new LinkedList<>(arrayList);
 
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
    	int listLength = arrayList.size();
    	for (int i = 0 ; i < listLength / 2 ; i++) {
    		int value = arrayList.get(i);
    		arrayList.set(i, arrayList.get(listLength - i - 1));
    		arrayList.set(listLength - i - 1, value);
    	}
    	
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
    	for (int i : arrayList) {
    		System.out.print(i + " ");
    	}
    	System.out.println("");
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
    	long time;
    	time = System.nanoTime();
    	
    	for (int i = 0 ; i < 100_000; i++) {
    		arrayList.add(0, 1);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Insert into head of ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
    	
    	time = System.nanoTime();
    	
    	for (int i = 0 ; i < 100_000; i++) {
    		linkedList.add(0, 1);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Insert into head of LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
    	
    	time = System.nanoTime();
    	
    	for (int i = 0 ; i < 1000; i++) {
    		arrayList.get(arrayList.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Read at middle ArrayList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
    	
    	time = System.nanoTime();
    	
    	for (int i = 0 ; i < 1000; i++) {
    		linkedList.get(linkedList.size() / 2);
    	}
    	
    	time = System.nanoTime() - time;
    	System.out.println("Read at middle LinkedList took " + time
                + "ns (" + time / TO_MS + "ms)");
    	
    	
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         * 
         * Africa -> 1,110,635,000
         * 
         * Americas -> 972,005,000
         * 
         * Antarctica -> 0
         * 
         * Asia -> 4,298,723,000
         * 
         * Europe -> 742,452,000
         * 
         * Oceania -> 38,304,000
         */
    	final Map<String, Long> map = new HashMap<>();
    	
    	map.put("Africa", 1_110_635_000L);
    	map.put("Americas", 927_005_000L);
    	map.put("Antarctica", 0L);
    	map.put("Asia", 4_298_723_000L);
    	map.put("Europe", 742_452_000L);
    	map.put("Oceania", 38_304_000L);
    	
        /*
         * 8) Compute the population of the world
         */
    	long population = 0;
    	for (var a : map.entrySet()) {
    		population += a.getValue();
    	}
    	
    	
    	System.out.println(population);
    }
}
