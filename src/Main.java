/*
DO NOT MODIFY THIS FILE.

This file tests the following methods of DoublyLinkedList:
- size, isEmpty
- toString, toReverseString
- addFirst, addLast
- getFirst, getLast
- removeFirst, removeLast
- clear
- contains
- add(E e), remove(Object o)
- equals
- indexOf
- lastIndexOf
- get
- set
- add(int index, E e)
- remove(int index)
- iterator()
- Iterator's next()
- Iterator's hasNext()
- Iterator's remove()
 */

import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        testAddFirst();
        testAddLast();
        testAddFirstAndAddLast();
        testGetFirst();
        testGetLast();
        testRemoveFirst();
        testRemoveLast();
        testClear();
        testContains();
        testAdd();
        testRemoveObject();
        testEquals();
        testIndexOf();
        testLastIndexOf();
        testGet();
        testSet();
        testAddAtIndex();
        testRemoveAtIndex();
        testImplementsList3130();
        testIterator();
        testIteratorNext();
        testIteratorHasNext();
        testOverridesReplaceAll();
        testReplaceAll();
        testIteratorRemove();
    }

    private static void testAddFirst() {
        System.out.println("testing addFirst");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.addFirst("aa");
        System.out.println(list.size());            // expected: 1
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa]
        System.out.println(list.toReverseString()); // expected: [aa]
        System.out.println();

        list.addFirst("b");
        System.out.println(list.size());            // expected: 2
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [b, aa]
        System.out.println(list.toReverseString()); // expected: [aa, b]
        System.out.println();

        list.addFirst("c");
        System.out.println(list.size());            // expected: 3
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [c, b, aa]
        System.out.println(list.toReverseString()); // expected: [aa, b, c]
        System.out.println();

        list.addFirst("d");
        System.out.println(list.size());            // expected: 4
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [d, c, b, aa]
        System.out.println(list.toReverseString()); // expected: [aa, b, c, d]
        System.out.println();

        list.addFirst("c");
        System.out.println(list.size());            // expected: 5
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [c, d, c, b, aa]
        System.out.println(list.toReverseString()); // expected: [aa, b, c, d, c]
        System.out.println();
    }

    private static void testAddLast() {
        System.out.println("testing addLast");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.addLast("aa");
        System.out.println(list.size());            // expected: 1
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa]
        System.out.println(list.toReverseString()); // expected: [aa]
        System.out.println();

        list.addLast("b");
        System.out.println(list.size());            // expected: 2
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b]
        System.out.println(list.toReverseString()); // expected: [b, aa]
        System.out.println();

        list.addLast("c");
        System.out.println(list.size());            // expected: 3
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b, c]
        System.out.println(list.toReverseString()); // expected: [c, b, aa]
        System.out.println();

        list.addLast("d");
        System.out.println(list.size());            // expected: 4
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b, c, d]
        System.out.println(list.toReverseString()); // expected: [d, c, b, aa]
        System.out.println();

        list.addLast("c");
        System.out.println(list.size());            // expected: 5
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b, c, d, c]
        System.out.println(list.toReverseString()); // expected: [c, d, c, b, aa]
        System.out.println();
    }

    private static void testAddFirstAndAddLast() {
        System.out.println("testing addFirst and addLast");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.addLast("a");
        list.addFirst("b");
        list.addFirst("c");
        list.addLast("d");
        list.addLast("e");

        System.out.println(list);                   // expected: [c, b, a, d, e]
        System.out.println(list.toReverseString()); // expected: [e, d, a, b, c]
        System.out.println();
    }

    private static void testGetFirst() {
        System.out.println("testing getFirst");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.getFirst();
            System.out.println("an exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        list.addFirst("a");
        System.out.println(list.getFirst()); // expected: a

        list.addFirst("b");
        System.out.println(list.getFirst()); // expected: b

        list.addFirst("c");
        System.out.println(list.getFirst()); // expected: c

        list.addLast("d");
        System.out.println(list.getFirst()); // expected: c

        System.out.println();

        // ------------------------------------------------------------------

        list = new DoublyLinkedList<>();

        list.addLast("a");
        System.out.println(list.getFirst()); // expected: a

        list.addLast("b");
        System.out.println(list.getFirst()); // expected: a

        list.addFirst("c");
        System.out.println(list.getFirst()); // expected: c

        System.out.println();
    }

    private static void testGetLast() {
        System.out.println("testing getLast");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.getLast();
            System.out.println("an exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        list.addLast("a");
        System.out.println(list.getLast()); // expected: a

        list.addLast("b");
        System.out.println(list.getLast()); // expected: b

        list.addLast("c");
        System.out.println(list.getLast()); // expected: c

        list.addFirst("d");
        System.out.println(list.getLast()); // expected: c

        System.out.println();

        // ------------------------------------------------------------------

        list = new DoublyLinkedList<>();

        list.addFirst("a");
        System.out.println(list.getLast()); // expected: a

        list.addFirst("b");
        System.out.println(list.getLast()); // expected: a

        list.addLast("c");
        System.out.println(list.getLast()); // expected: c

        System.out.println();
    }

    private static void testRemoveFirst() {
        System.out.println("testing removeFirst");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.removeFirst();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        list.addFirst("a");
        String first = list.removeFirst();
        System.out.println(first);                  // expected: a
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        System.out.println(list.size());            // expected: 3
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [c, b, a]
        System.out.println(list.toReverseString()); // expected: [a, b, c]
        System.out.println(list.getFirst());        // expected: c
        System.out.println(list.getLast());         // expected: a
        System.out.println();

        first = list.removeFirst();
        System.out.println(first);                  // expected: c
        System.out.println(list.size());            // expected: 2
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [b, a]
        System.out.println(list.toReverseString()); // expected: [a, b]
        System.out.println(list.getFirst());        // expected: b
        System.out.println(list.getLast());         // expected: a
        System.out.println();

        first = list.removeFirst();
        System.out.println(first);                  // expected: b
        System.out.println(list.size());            // expected: 1
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [a]
        System.out.println(list.toReverseString()); // expected: [a]
        System.out.println(list.getFirst());        // expected: a
        System.out.println(list.getLast());         // expected: a
        System.out.println();

        first = list.removeFirst();
        System.out.println(first);                  // expected: a
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        try {
            list.getFirst();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        try {
            list.getLast();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }
    }

    private static void testRemoveLast() {
        System.out.println("testing removeLast");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.removeLast();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        list.addFirst("a");
        String last = list.removeLast();
        System.out.println(last);                  // expected: a
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.addFirst("a");
        list.addFirst("b");
        list.addFirst("c");
        System.out.println(list.size());            // expected: 3
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [c, b, a]
        System.out.println(list.toReverseString()); // expected: [a, b, c]
        System.out.println(list.getFirst());        // expected: c
        System.out.println(list.getLast());         // expected: a
        System.out.println();

        last = list.removeLast();
        System.out.println(last);                  // expected: a
        System.out.println(list.size());            // expected: 2
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [c, b]
        System.out.println(list.toReverseString()); // expected: [b, c]
        System.out.println(list.getFirst());        // expected: c
        System.out.println(list.getLast());         // expected: b
        System.out.println();

        last = list.removeLast();
        System.out.println(last);                  // expected: b
        System.out.println(list.size());            // expected: 1
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [c]
        System.out.println(list.toReverseString()); // expected: [c]
        System.out.println(list.getFirst());        // expected: c
        System.out.println(list.getLast());         // expected: c
        System.out.println();

        last = list.removeFirst();
        System.out.println(last);                  // expected: c
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        try {
            list.getFirst();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        try {
            list.getLast();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }
    }

    private static void testClear() {
        System.out.println("testing clear");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.clear();
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list.size());            // expected: 0
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.addLast("a");
        list.clear();
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list.size());            // expected: 0
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.addLast("a");
        list.addLast("b");
        list.clear();
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list.size());            // expected: 0
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        try {
            list.getFirst();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        try {
            list.getLast();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }
    }

    private static void testContains() {
        System.out.println("testing contains");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println(list.contains(new String("a"))); // expected: false
        System.out.println();

        list.addLast("a");
        System.out.println(list.contains(new String("a"))); // expected: true
        System.out.println(list.contains(new String("b"))); // expected: false
        System.out.println();

        list.addLast("b");
        System.out.println(list.contains(new String("a"))); // expected: true
        System.out.println(list.contains(new String("b"))); // expected: true
        System.out.println(list.contains(new String("c"))); // expected: false
        System.out.println();

        list.addLast("c");
        System.out.println(list.contains(new String("a"))); // expected: true
        System.out.println(list.contains(new String("b"))); // expected: true
        System.out.println(list.contains(new String("c"))); // expected: true
        System.out.println(list.contains(new String("d"))); // expected: false
        System.out.println();

        list.removeLast();
        System.out.println(list.contains(new String("a"))); // expected: true
        System.out.println(list.contains(new String("b"))); // expected: true
        System.out.println(list.contains(new String("c"))); // expected: false
        System.out.println(list.contains(new String("d"))); // expected: false
        System.out.println();

        list.removeFirst();
        System.out.println(list.contains(new String("a"))); // expected: false
        System.out.println(list.contains(new String("b"))); // expected: true
        System.out.println(list.contains(new String("c"))); // expected: false
        System.out.println(list.contains(new String("d"))); // expected: false
        System.out.println();
    }

    private static void testAdd() {
        System.out.println("testing add");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println(list.size());            // expected: 0
        System.out.println(list.isEmpty());         // expected: true
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        boolean added = list.add("aa");
        System.out.println(added);                  // expected: true
        System.out.println(list.size());            // expected: 1
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa]
        System.out.println(list.toReverseString()); // expected: [aa]
        System.out.println();

        list.add("b");
        System.out.println(list.size());            // expected: 2
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b]
        System.out.println(list.toReverseString()); // expected: [b, aa]
        System.out.println();

        list.add("c");
        System.out.println(list.size());            // expected: 3
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b, c]
        System.out.println(list.toReverseString()); // expected: [c, b, aa]
        System.out.println();

        list.add("d");
        System.out.println(list.size());            // expected: 4
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b, c, d]
        System.out.println(list.toReverseString()); // expected: [d, c, b, aa]
        System.out.println();

        list.add("c");
        System.out.println(list.size());            // expected: 5
        System.out.println(list.isEmpty());         // expected: false
        System.out.println(list);                   // expected: [aa, b, c, d, c]
        System.out.println(list.toReverseString()); // expected: [c, d, c, b, aa]
        System.out.println();
    }

    private static void testRemoveObject() {
        System.out.println("testing remove(Object)");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        boolean removed = list.remove(new String("a"));
        System.out.println(removed);                // expected: false
        System.out.println(list.size());            // expected: 0
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.add("a");

        removed = list.remove(new String("b"));
        System.out.println(removed);                // expected: false
        System.out.println(list.size());            // expected: 1
        System.out.println(list);                   // expected: [a]
        System.out.println(list.toReverseString()); // expected: [a]
        System.out.println();

        removed = list.remove(new String("a"));
        System.out.println(removed);                // expected: true
        System.out.println(list.size());            // expected: 0
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("c");

        removed = list.remove("e");
        System.out.println(removed);                // expected: false
        System.out.println(list.size());            // expected: 5
        System.out.println(list);                   // expected: [a, b, c, d, c]
        System.out.println(list.toReverseString()); // expected: [c, d, c, b, a]
        System.out.println();

        removed = list.remove(new String("c"));
        System.out.println(removed);                // expected: true
        System.out.println(list.size());            // expected: 4
        System.out.println(list);                   // expected: [a, b, d, c]
        System.out.println(list.toReverseString()); // expected: [c, d, b, a]
        System.out.println();

        removed = list.remove(new String("c"));
        System.out.println(removed);                // expected: true
        System.out.println(list.size());            // expected: 3
        System.out.println(list);                   // expected: [a, b, d]
        System.out.println(list.toReverseString()); // expected: [d, b, a]
        System.out.println();

        removed = list.remove(new String("a"));
        System.out.println(removed);                // expected: true
        System.out.println(list.size());            // expected: 2
        System.out.println(list);                   // expected: [b, d]
        System.out.println(list.toReverseString()); // expected: [d, b]
        System.out.println(list.getFirst());        // expected: b
        System.out.println(list.getLast());         // expected: d
        System.out.println();
    }

    private static void testEquals() {
        System.out.println("testing equals");

        // both empty
        DoublyLinkedList<String> list1 = new DoublyLinkedList<>();
        DoublyLinkedList<String> list2 = new DoublyLinkedList<>();
        System.out.println(list1.equals(list2));            // expected: true

        // first is longer
        DoublyLinkedList<String> list3 = new DoublyLinkedList<>();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        list3.add("d");
        DoublyLinkedList<String> list4 = new DoublyLinkedList<>();
        list4.add("a");
        list4.add("b");
        System.out.println(list3.equals(list4));            // expected: false

        // second is longer
        DoublyLinkedList<String> list5 = new DoublyLinkedList<>();
        list5.add("a");
        list5.add("b");
        DoublyLinkedList<String> list6 = new DoublyLinkedList<>();
        list6.add("a");
        list6.add("b");
        list6.add("c");
        list6.add("d");
        System.out.println(list5.equals(list6));            // expected: false

        // same length, but one element doesn't match
        DoublyLinkedList<String> list7 = new DoublyLinkedList<>();
        list7.add("a");
        list7.add("b");
        list7.add("c");
        list7.add("d");
        DoublyLinkedList<String> list8 = new DoublyLinkedList<>();
        list8.add("a");
        list8.add("b");
        list8.add("e");
        list8.add("d");
        System.out.println(list7.equals(list8));            // expected: false

        // equal. one built with addFirst, one with addLast
        DoublyLinkedList<String> list9 = new DoublyLinkedList<>();
        list9.addFirst("c");
        list9.addFirst("b");
        list9.addFirst("a");
        DoublyLinkedList<String> list10 = new DoublyLinkedList<>();
        list10.addLast("a");
        list10.addLast("b");
        list10.addLast("c");
        System.out.println(list9.equals(list10));           // expected: true

        // equal. argument is of type Object
        DoublyLinkedList<String> list11 = new DoublyLinkedList<>();
        list11.add("a");
        list11.add("b");
        DoublyLinkedList<String> list12 = new DoublyLinkedList<>();
        list12.add("a");
        list12.add("b");
        System.out.println(list11.equals((Object) list12)); // expected: true

        // check if DLL<String> equals DLL<Integer> of same length
        DoublyLinkedList<String> list13 = new DoublyLinkedList<>();
        list13.add("a");
        DoublyLinkedList<Integer> list14 = new DoublyLinkedList<>();
        list14.add(1);
        System.out.println(list13.equals(list14));          // expected: false

        // check if equals a String
        DoublyLinkedList<String> list15 = new DoublyLinkedList<>();
        list15.add("a");
        System.out.println(list15.equals("a"));             // expected: false

        // check if equals null
        DoublyLinkedList<String> list16 = new DoublyLinkedList<>();
        System.out.println(list16.equals(null));            // expected: false

        System.out.println();
    }

    private static void testIndexOf() {
        System.out.println("testing indexOf");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println(list.indexOf("a")); // expected: -1
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("b");
        System.out.println(list.indexOf("a")); // expected: 0
        System.out.println(list.indexOf("b")); // expected: 1
        System.out.println(list.indexOf("c")); // expected: 2
        System.out.println(list.indexOf("d")); // expected: -1

        System.out.println();
    }

    private static void testLastIndexOf() {
        System.out.println("testing lastIndexOf");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        System.out.println(list.lastIndexOf("a")); // expected: -1
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("c");
        list.add("b");
        System.out.println(list.lastIndexOf("a")); // expected: 0
        System.out.println(list.lastIndexOf("b")); // expected: 4
        System.out.println(list.lastIndexOf("c")); // expected: 3
        System.out.println(list.indexOf("d")); // expected: -1

        System.out.println();
    }

    private static void testGet() {
        System.out.println("testing get");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.get(-1);
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.get(0);
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        list.add("a");
        System.out.println(list.get(0)); // expected: a

        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        System.out.println(list.get(1)); // expected: b
        System.out.println(list.get(2)); // expected: c
        System.out.println(list.get(3)); // expected: d
        System.out.println(list.get(4)); // expected: e
        System.out.println(list.get(5)); // expected: f
        System.out.println();

        try {
            list.get(-1);
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.get(6);
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private static void testSet() {
        System.out.println("testing set");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.set(-1, "a");
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.set(0, "a");
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        list.add("a");
        System.out.println(list.set(0, "aa"));  // expected: a
        System.out.println(list);               // expected: [aa]

        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list.set(1, "bb"));  // expected: b
        System.out.println(list.set(2, "cc"));  // expected: c
        System.out.println(list.set(3, "dd"));  // expected: d
        System.out.println(list.set(4, "ee"));  // expected: e
        System.out.println(list.set(5, "f"));   // expected: f
        System.out.println(list);               // expected: [aa, bb, cc, dd, ee, f]
        System.out.println(list.size());        // expected: 6
        System.out.println();

        try {
            list.set(-1, "a");
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.set(6, "a");
            System.out.println("An exception was supposed to occur here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private static void testAddAtIndex() {
        System.out.println("testing add(int, E)");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.add(-1, "a");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.add(1, "a");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        list.add(0, "a");
        System.out.println(list.size());            // expected: 1
        System.out.println(list);                   // expected: [a]
        System.out.println(list.toReverseString()); // expected: [a]
        System.out.println();

        list.add(1, "b");
        System.out.println(list.size());            // expected: 2
        System.out.println(list);                   // expected: [a, b]
        System.out.println(list.toReverseString()); // expected: [b, a]
        System.out.println();

        list.add(0, "z");
        System.out.println(list.size());            // expected: 3
        System.out.println(list);                   // expected: [z, a, b]
        System.out.println(list.toReverseString()); // expected: [b, a, z]
        System.out.println();

        list.add(2, "ab");
        System.out.println(list.size());            // expected: 4
        System.out.println(list);                   // expected: [z, a, ab, b]
        System.out.println(list.toReverseString()); // expected: [b, ab, a, z]
        System.out.println();

        list.add(2, "other");
        System.out.println(list.size());            // expected: 5
        System.out.println(list);                   // expected: [z, a, other, ab, b]
        System.out.println(list.toReverseString()); // expected: [b, ab, other, a, z]
        System.out.println();

        try {
            list.add(-1, "a");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.add(list.size() + 1, "a");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private static void testRemoveAtIndex() {
        System.out.println("testing remove(int)");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        try {
            list.remove(-1);
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.remove(0);
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        list.add("a");
        String result = list.remove(0);
        System.out.println(result);                 // expected: a
        System.out.println(list.size());            // expected: 0
        System.out.println(list);                   // expected: []
        System.out.println(list.toReverseString()); // expected: []
        System.out.println();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        result = list.remove(2);
        System.out.println(result);                 // expected: c
        System.out.println(list.size());            // expected: 4
        System.out.println(list);                   // expected: [a, b, d, e]
        System.out.println(list.toReverseString()); // expected: [e, d, b, a]
        System.out.println();

        result = list.remove(0);
        System.out.println(result);                 // expected: a
        System.out.println(list.size());            // expected: 3
        System.out.println(list);                   // expected: [b, d, e]
        System.out.println(list.toReverseString()); // expected: [e, d, b]
        System.out.println();

        result = list.remove(2);
        System.out.println(result);                 // expected: e
        System.out.println(list.size());            // expected: 2
        System.out.println(list);                   // expected: [b, d]
        System.out.println(list.toReverseString()); // expected: [d, b]
        System.out.println();

        try {
            list.remove(-1);
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }

        try {
            list.remove(2);
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IndexOutOfBoundsException ignored) {
        }
    }

    private static void testImplementsList3130() {
        System.out.println("testing DoublyLinkedList implements List3130");
        System.out.println(new DoublyLinkedList<String>() instanceof List3130); // expected: true
        System.out.println();
    }

    private static void testIterator() {
        System.out.println("testing iterator()");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        for (String s : list) {
            System.out.print(s);
        }

        list.add("a");
        for (String s : list) {
            System.out.print(s);
        } // expected: a
        System.out.println();

        list.add("b");
        list.add("c");

        for (String s : list) {
            System.out.print(s + " ");
        } // expected: a b c

        System.out.println("\n");

        Iterator<String> iterator = list.iterator();
    }

    private static void testIteratorNext() {
        System.out.println("testing Iterator's next method");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("a");
        list.add("b");

        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.next()); // expected: a
        System.out.println(iterator.next()); // expected: b
        System.out.println();

        try {
            iterator.next();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }

        list.add("c");

        iterator = list.iterator();
        System.out.println(iterator.next()); // expected: a
        System.out.println(iterator.next()); // expected: b
        System.out.println(iterator.next()); // expected: c
        System.out.println();

        try {
            iterator.next();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (NoSuchElementException ignored) {
        }
    }

    private static void testIteratorHasNext() {
        System.out.println("testing Iterator's hasNext method");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("a");
        list.add("b");

        Iterator<String> iterator = list.iterator();
        System.out.println(iterator.hasNext()); // expected: true
        iterator.next();
        System.out.println(iterator.hasNext()); // expected: true
        iterator.next();
        System.out.println(iterator.hasNext()); // expected: false
        System.out.println();

        list.add("c");

        iterator = list.iterator();
        System.out.println(iterator.hasNext()); // expected: true
        iterator.next();
        System.out.println(iterator.hasNext()); // expected: true
        iterator.next();
        System.out.println(iterator.hasNext()); // expected: true
        iterator.next();
        System.out.println(iterator.hasNext()); // expected: false
        System.out.println();
    }

    private static void testOverridesReplaceAll() {
        System.out.println("testing if DoublyLinkedList overrides replaceAll");
        Method[] declaredMethods = DoublyLinkedList.class.getDeclaredMethods();
        System.out.println(containsMethodNamedReplaceAllWithOneUnaryOperatorParameter(declaredMethods)); // expected: true
        System.out.println();
    }

    private static boolean containsMethodNamedReplaceAllWithOneUnaryOperatorParameter(Method[] methods) {
        for (Method method : methods) {
            if (method.getName().equals("replaceAll") && method.getParameterCount() == 1 && method.getParameterTypes()[0].getCanonicalName().equals("java.util.function.UnaryOperator")) {
                return true;
            }
        }

        return false;
    }

    private static void testReplaceAll() {
        System.out.println("testing replaceAll");

        DoublyLinkedList<String> strings = new DoublyLinkedList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.replaceAll(String::toUpperCase);
        System.out.println(strings);                    // expected: [A, B, C]
        System.out.println(strings.toReverseString());  // expected: [C, B, A]
        System.out.println();

        DoublyLinkedList<Integer> integers = new DoublyLinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.replaceAll(integer -> 2 * integer);
        System.out.println(integers);                   // expected: [2, 4, 6, 8]
        System.out.println();
    }

    private static void testIteratorRemove() {
        System.out.println("testing Iterator's remove method");

        DoublyLinkedList<String> list = new DoublyLinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");

        Iterator<String> iterator = list.iterator();

        try {
            iterator.remove();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IllegalStateException ignored) {
        }

        iterator.next();
        iterator.remove();
        System.out.println(list.size());            // expected: 4
        System.out.println(list);                   // expected: [b, c, d, e]
        System.out.println(list.toReverseString()); // expected: [e, d, c, b]
        System.out.println();

        try {
            iterator.remove();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IllegalStateException ignored) {
        }

        iterator.next();

        iterator.next();
        iterator.remove();
        System.out.println(list.size());            // expected: 3
        System.out.println(list);                   // expected: [b, d, e]
        System.out.println(list.toReverseString()); // expected: [e, d, b]
        System.out.println();

        try {
            iterator.remove();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IllegalStateException ignored) {
        }

        iterator.next();

        iterator.next();
        iterator.remove();
        System.out.println(list.size());            // expected: 2
        System.out.println(list);                   // expected: [b, d]
        System.out.println(list.toReverseString()); // expected: [d, b]
        System.out.println();

        try {
            iterator.remove();
            System.out.println("An exception should have occurred here, but didn't");
        } catch (IllegalStateException ignored) {
        }
    }
}

