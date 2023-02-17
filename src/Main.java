// DO NOT MODIFY THIS FILE.

public class Main {
    public static void main(String[] args) {
        testNoArgConstructor();
        testParameterizedConstructor();
        testSize();
        testAdd();
        testGet();
        testSet();
        testContains();
        testToString();
        testEquals();
        testIndexOf();
        testLastIndexOf();
        testAddTwoParameters();
        testRemove();
        testAddFrom();
        testAddTo();
    }

    private static void testNoArgConstructor() {
        System.out.println("Testing no-arg constructor");
        new FancyArray<String>();
        new FancyArray<Integer>();
        System.out.println();
    }

    private static void testParameterizedConstructor() {
        System.out.println("Testing parameterized constructor");

        try {
            new FancyArray<String>(0);
            new FancyArray<String>(1);
            new FancyArray<String>(10);
            new FancyArray<String>(100);
            new FancyArray<Integer>(100);
        } catch (Exception e) {
            System.out.println("an exception should not have occurred here, but did");
        }

        try {
            new FancyArray<String>(-1);
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        System.out.println();
    }

    private static void testSize() {
        System.out.println("Testing size");

        FancyArray<String> a = new FancyArray<>();
        System.out.println(a.size()); // expected: 0
        a.add("a string");
        System.out.println(a.size()); // expected: 1
        a.add("another string");
        System.out.println(a.size()); // expected: 2

        FancyArray<String> b = new FancyArray<>(5);
        System.out.println(b.size()); // expected: 0
        b.add("a string");
        System.out.println(b.size()); // expected: 1
        b.add("another string");
        System.out.println(b.size()); // expected: 2

        System.out.println();
    }

    private static void testAdd() {
        System.out.println("Testing add");

        FancyArray<String> a = new FancyArray<>();

        try {
            for (int i = 0; i < 10; i++) {
                a.add("a string");
            }
        } catch (Exception e) {
            System.out.println("an exception should not have occurred here, but did");
        }

        try {
            a.add("a string");
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        FancyArray<String> b = new FancyArray<>(3);
        try {
            for (int i = 0; i < 3; i++) {
                b.add("a string");
            }
        } catch (Exception e) {
            System.out.println("an exception should not have occurred here, but did");
        }

        try {
            b.add("a string");
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        FancyArray<Integer> integers = new FancyArray<>();
        integers.add(45);

        System.out.println();
    }

    private static void testGet() {
        System.out.println("Testing get");

        FancyArray<String> a = new FancyArray<>(5);
        a.add("first");
        a.add("second");
        a.add("third");

        System.out.println(a.get(0)); // expected: first
        System.out.println(a.get(1)); // expected: second
        System.out.println(a.get(2)); // expected: third

        try {
            a.get(-1);
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        try {
            a.get(3);
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        FancyArray<Integer> integers = new FancyArray<>();
        integers.add(45);
        System.out.println(integers.get(0)); // expected: 45

        System.out.println();
    }

    private static void testSet() {
        System.out.println("Testing set");

        FancyArray<String> a = new FancyArray<>(5);
        a.add("first");
        a.add("second");
        a.add("third");

        String oldString = a.set(1, "another");
        System.out.println(oldString); // expected: second
        System.out.println(a.get(1)); // expected: another

        try {
            a.set(-1, "another");
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        try {
            a.set(3, "another");
            System.out.println("an exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        FancyArray<Integer> integers = new FancyArray<>();
        integers.add(45);
        int original = integers.set(0, 100);
        System.out.println(original);        // expected: 45
        System.out.println(integers.get(0)); // expected: 100

        System.out.println();
    }

    private static void testContains() {
        System.out.println("Testing contains");

        FancyArray<String> a = new FancyArray<>(5);
        a.add("first");
        a.add("second");
        a.add("third");

        System.out.println(a.contains(new String("first"))); // expected: true
        System.out.println(a.contains(new String("second"))); // expected: true
        System.out.println(a.contains("third")); // expected: true
        System.out.println(a.contains("another")); // expected: false

        a.set(1, "another");
        System.out.println(a.contains("another")); // expected: true

        FancyArray<Integer> integers = new FancyArray<>();
        integers.add(45);
        System.out.println(integers.contains(45));  // expected: true
        System.out.println(integers.contains(100)); // expected: false

        System.out.println();
    }

    private static void testToString() {
        System.out.println("Testing toString");

        FancyArray<String> a = new FancyArray<>(5);
        System.out.println(a); // expected: []

        a.add("first");
        System.out.println(a); // expected: [first]

        a.add("second");
        a.add("third");
        System.out.println(a); // expected: [first, second, third]

        System.out.println();
    }

    private static void testEquals() {
        System.out.println("testing equals");

        FancyArray<String> a = new FancyArray<>(5);
        a.add("first");
        a.add("second");
        a.add("third");

        FancyArray<String> b = new FancyArray<>(10);
        b.add("first");
        b.add("second");
        b.add("third");

        FancyArray<String> c = new FancyArray<>(5);
        c.add("first");
        c.add("second");
        c.add("another");

        FancyArray<String> d = new FancyArray<>(5);
        d.add("first");
        d.add("second");

        System.out.println(a.equals(b)); // expected: true
        System.out.println(b.equals(a)); // expected: true
        System.out.println(a.equals((Object) b)); // expected: true
        System.out.println(b.equals((Object) a)); // expected: true
        System.out.println(a.equals(c)); // expected: false
        System.out.println(c.equals(a)); // expected: false
        System.out.println(a.equals(d)); // expected: false
        System.out.println(d.equals(a)); // expected: false
        System.out.println(a.equals("a string")); // expected: false
        System.out.println(a.equals(null)); // expected: false

        System.out.println();
    }

    private static void testIndexOf() {
        System.out.println("Testing indexOf");

        FancyArray<Integer> integers = new FancyArray<>(8);
        integers.add(5);
        integers.add(10);
        integers.add(15);
        integers.add(10);
        integers.add(20);
        System.out.println(integers.indexOf(5)); // expected: 0
        System.out.println(integers.indexOf(10)); // expected: 1
        System.out.println(integers.indexOf(15)); // expected: 2
        System.out.println(integers.indexOf(20)); // expected: 4
        System.out.println(integers.indexOf(25)); // expected: -1

        FancyArray<String> strings = new FancyArray<>();
        strings.add("first");
        System.out.println(strings.indexOf(new String("first"))); // expected: 0
        System.out.println(strings.indexOf("another")); // expected: -1

        System.out.println();
    }

    private static void testLastIndexOf() {
        System.out.println("Testing lastIndexOf");

        FancyArray<Integer> integers = new FancyArray<>(8);
        integers.add(5);
        integers.add(10);
        integers.add(15);
        integers.add(10);
        integers.add(20);
        System.out.println(integers.lastIndexOf(5)); // expected: 0
        System.out.println(integers.lastIndexOf(10)); // expected: 3
        System.out.println(integers.lastIndexOf(15)); // expected: 2
        System.out.println(integers.lastIndexOf(20)); // expected: 4
        System.out.println(integers.lastIndexOf(25)); // expected: -1

        FancyArray<String> strings = new FancyArray<>();
        strings.add("first");
        System.out.println(strings.lastIndexOf(new String("first"))); // expected: 0
        System.out.println(strings.lastIndexOf("another")); // expected: -1

        System.out.println();
    }

    private static void testAddTwoParameters() {
        System.out.println("Testing add with two parameters");

        FancyArray<String> fancyArray = new FancyArray<>(8);
        fancyArray.add("one");
        fancyArray.add("two");
        System.out.println(fancyArray); // expected: [one, two]
        System.out.println(fancyArray.size()); // expected: 2

        fancyArray.add(2, "three");
        System.out.println(fancyArray); // expected: [one, two, three]
        System.out.println(fancyArray.size()); // expected: 3

        fancyArray.add(0, "zero");
        System.out.println(fancyArray); // expected: [zero, one, two, three]
        System.out.println(fancyArray.get(0)); // expected: zero
        System.out.println(fancyArray.get(1)); // expected: one
        System.out.println(fancyArray.size()); // expected: 4

        fancyArray.add(1, "half");
        System.out.println(fancyArray); // expected: [zero, half, one, two, three]
        System.out.println(fancyArray.get(0)); // expected: zero
        System.out.println(fancyArray.get(1)); // expected: half
        System.out.println(fancyArray.get(2)); // expected: one
        System.out.println(fancyArray.size()); // expected: 5

        try {
            fancyArray = new FancyArray<>(8);
            fancyArray.add("one");
            fancyArray.add("two");
            fancyArray.add("three");
            fancyArray.add(-1, "zero");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        try {
            fancyArray = new FancyArray<>(8);
            fancyArray.add("one");
            fancyArray.add("two");
            fancyArray.add("three");
            fancyArray.add(4, "five");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        fancyArray = new FancyArray<>(3);
        fancyArray.add(0, "three");
        fancyArray.add(0, "two");
        fancyArray.add(0, "one");
        System.out.println(fancyArray); // expected: [one, two, three]

        try {
            fancyArray.add(0, "zero");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        try {
            fancyArray = new FancyArray<>(0);
            fancyArray.add(0, "one");
            System.out.println("An exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        System.out.println();
    }

    private static void testRemove() {
        System.out.println("Testing remove");

        FancyArray<String> fancyArray = new FancyArray<>(8);
        fancyArray.add("one");
        fancyArray.add("two");
        fancyArray.add("three");
        fancyArray.add("four");
        fancyArray.add("five");
        fancyArray.add("six");
        System.out.println(fancyArray); // expected: [one, two, three, four, five, six]

        String removed = fancyArray.remove(2);
        System.out.println(removed); // expected: three
        System.out.println(fancyArray); // expected: [one, two, four, five, six]
        System.out.println(fancyArray.get(1)); // expected: two
        System.out.println(fancyArray.get(2)); // expected: four
        System.out.println(fancyArray.get(3)); // expected: five
        System.out.println(fancyArray.size()); // expected: 5

        removed = fancyArray.remove(0);
        System.out.println(removed); // expected: one
        System.out.println(fancyArray); // expected: [two, four, five, six]
        System.out.println(fancyArray.get(0)); // expected: two
        System.out.println(fancyArray.size()); // expected: 4

        removed = fancyArray.remove(3);
        System.out.println(removed); // expected: six
        System.out.println(fancyArray); // expected: [two, four, five]
        System.out.println(fancyArray.size()); // expected: 3

        fancyArray.add("seven");
        System.out.println(fancyArray); // expected: [two, four, five, seven]
        System.out.println(fancyArray.size()); // expected: 4

        fancyArray = new FancyArray<>(3);
        fancyArray.add("one");
        fancyArray.add("two");
        fancyArray.add("three");
        removed = fancyArray.remove(2);
        System.out.println(fancyArray); // expected: [one, two]
        System.out.println(fancyArray.size()); // expected: 2

        try {
            fancyArray = new FancyArray<>(8);
            fancyArray.add("one");
            fancyArray.add("two");
            fancyArray.remove(-1);
            System.out.println("An exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        try {
            fancyArray = new FancyArray<>(8);
            fancyArray.add("one");
            fancyArray.add("two");
            fancyArray.remove(2);
            System.out.println("An exception should have occurred here, but didn't");
        } catch (Exception ignored) {
        }

        System.out.println();
    }

    private static void testAddFrom() {
        System.out.println("Testing addFrom");

        FancyArray<Integer> fa1 = new FancyArray<>();
        fa1.add(1);
        fa1.add(2);

        FancyArray<Integer> fa2 = new FancyArray<>();
        fa2.add(3);
        fa2.add(4);
        fa2.add(5);

        fa1.addFrom(fa2);
        System.out.println(fa1); // expected: [1, 2, 3, 4, 5]
        System.out.println(fa2); // expected: [3, 4, 5]

        /**********************/

        FancyArray<Number> fa3 = new FancyArray<>();
        fa3.add(1.5);

        FancyArray<Integer> fa4 = new FancyArray<>();
        fa4.add(2);
        fa4.add(3);
        fa4.add(4);

        fa3.addFrom(fa4);
        System.out.println(fa3); // expected: [1.5, 2, 3, 4]
        System.out.println(fa4); // expected: [2, 3, 4]

        System.out.println();
    }

    private static void testAddTo() {
        System.out.println("Testing addTo");

        FancyArray<Integer> fa1 = new FancyArray<>();
        fa1.add(1);
        fa1.add(2);

        FancyArray<Integer> fa2 = new FancyArray<>();
        fa2.add(3);
        fa2.add(4);
        fa2.add(5);

        fa1.addTo(fa2);
        System.out.println(fa1); // expected: [1, 2]
        System.out.println(fa2); // expected: [3, 4, 5, 1, 2]

        /**********************/

        FancyArray<Integer> fa3 = new FancyArray<>();
        fa3.add(1);

        FancyArray<Number> fa4 = new FancyArray<>();
        fa4.add(2.5);
        fa4.add(3.5);

        fa3.addTo(fa4);
        System.out.println(fa4); // expected: [2.5, 3.5, 1]
        System.out.println(fa3); // expected: [1]
    }
}