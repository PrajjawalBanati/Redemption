## Quick revision of concepts applied

**[Problem-1 Contains Duplicate](ContainsDuplicate.java)**

Need to remember the functions of HashSet

(Java)

```java
import java.util.HashSet;

class HashSetImpl {
    public static void main(String[] args) {
        HashSet<Integer> hs = new HashSet<>();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 7, 8, 9};

        // adding the numbers in Hashset
        for (int num : nums) {
            hs.add(num);
        }
        System.out.println("HashSet after adding elements: " + hs);

        // checking if any number is there
        System.out.println("Contains 5? " + hs.contains(5));
        System.out.println("Contains 10? " + hs.contains(10));

        // get any number (HashSet has no index, but you can iterate)
        for (int num : hs) {
            System.out.println("Getting element: " + num);
            break; // Just get one
        }

        // delete any number
        hs.remove(3);
        System.out.println("After removing 3: " + hs);

        // replace any number with some other
        if (hs.remove(4)) {
            hs.add(40);
            System.out.println("Replaced 4 with 40: " + hs);
        }

        // Miscellaneous methods which are helpful
        System.out.println("Size of HashSet: " + hs.size());
        System.out.println("Is HashSet empty? " + hs.isEmpty());
        hs.clear();
        System.out.println("HashSet after clear(): " + hs);
    }
}
```

**[Problem-2 Valid Anagrams](ValidAnagrams.java)**

Whenever you are asked to calculated frequency always use HashMap. In this question you can follow two approaches:

- Calculate the freq of first string and start decrementing the frequency value as soon as you find the same character in another string. If any character frequency reaches 0 delete it from hashMap. At the end if hashmap is empty it's true otherwise it's false.
- Calculate the freq of both strings and store the result in two different hashmaps. Now start comparing the two hashmaps. There might be a possibility that the character in first hashmap is not there in second one (or vice versa) so use try catch in this case to properly catch the **NullPointerExceptions**.

Need to remember about the functions of HashMap

(Java)

```java
import java.util.HashMap;
import java.util.Map;

class HashMapImpl {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();

        // adding entries into HashMap
        hm.put(1, "Apple");
        hm.put(2, "Banana");
        hm.put(3, "Cherry");

        // Getting Entries from HashMap
        System.out.println("Value at key 2: " + hm.get(2));

        // Check if the following key is present
        System.out.println("Contains key 3? " + hm.containsKey(3));
        System.out.println("Contains key 5? " + hm.containsKey(5));

        // Replace the key with some updated value
        hm.put(2, "Blueberry"); // or hm.replace(2, "Blueberry");
        System.out.println("Updated HashMap: " + hm);

        // Iterating over the whole HashMap
        for (Map.Entry<Integer, String> entry : hm.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```

**[Problem-3 Two Sum](TwoSum.java)**

- Refer the functions of the HashMap above.
- Whenever you are asked to calculate the index positions use a Hashmap. If you just want to find the existence of such pair use HashSet.
- Always try to insert the value and try to find the `target-nums[i]` value in the HashMap.

**[Problem-4 Group Anagrams](GroupAnagrams.java)**

- Try to use enhanced for-each loops wherever possible. Makes it look cleaner. Example

```java
class ForEachImpl{
    public static void main(String[] args)
    {
        for (String word : strs) {
        }
        for (int num : numbers) {
        }
    }
}
```

- If a key is not present in HashMap then use computeIfAbsent function and create the type value in one line. Example

```java
import java.util.*;
import java.util.function.Function;

class User {
    String name;
    User(String name) { this.name = name; }
    public String toString() { return "User: " + name; }
}

public class ComputeIfAbsentImpl {
    public static void main(String[] args) {

        // 1. List as value
        Map<String, List<String>> listMap = new HashMap<>();
        listMap.computeIfAbsent("fruits", k -> new ArrayList<>()).add("Apple");
        listMap.computeIfAbsent("fruits", k -> new ArrayList<>()).add("Banana");
        System.out.println("ListMap: " + listMap);

        // 2. Set as value
        Map<String, Set<Integer>> setMap = new HashMap<>();
        setMap.computeIfAbsent("evens", k -> new HashSet<>()).add(2);
        setMap.computeIfAbsent("evens", k -> new HashSet<>()).add(4);
        System.out.println("SetMap: " + setMap);

        // 3. Integer as value (manual increment)
        Map<String, Integer> countMap = new HashMap<>();
        countMap.computeIfAbsent("apple", k -> 0);
        countMap.put("apple", countMap.get("apple") + 1);
        countMap.put("apple", countMap.get("apple") + 1);
        System.out.println("CountMap: " + countMap);

        // 4. Custom object as value
        Map<Integer, User> userMap = new HashMap<>();
        userMap.computeIfAbsent(1, id -> new User("John"));
        userMap.computeIfAbsent(2, id -> new User("Alice"));
        System.out.println("UserMap: " + userMap);

        // 5. String as value
        Map<Integer, String> stringMap = new HashMap<>();
        stringMap.computeIfAbsent(10, k ->"Default");
        System.out.println("StringMap: " + stringMap);
    }
}
```

- A string builder class is the ultimate class to create any integer, character, float, double to a string. StringBuilder object needs to converted back to string using `toString()` function.
- Expression creation - It's a very beautiful approach that actually creates an expression from the frequency array. We just keep on appending the frequency of each alphabet separated by a "#" or any other special character so that the expression remains unique and same for anagrams.

**[Problem-5 Top K frequent elements](TopKFrequentElements.java)**

- Comparator needs to be revised, how it behaves with priority queue.
- Priority Queue comes with a min heap logic saying that minimum elements comes first.

```text
compare(a,b)
{ 
    return a-b 
}

compare(a,b) < 0 - a comes first 
comapre(a,b) > 0 - a comes after 
compare(a,b) = 0 - a and b remains unchanged
```

- Creating a priority queue of a Pair is not valid as Pair is no such class in Java.
- Instead, use Map.Entry<K ,V>. It works the same way.

```java
import java.util.*;

class MaxHeapPriorityQueuePairImpl {
    public static void main(String[] args) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue() // Max-Heap based on value
        );

        // Add elements
        pq.offer(new AbstractMap.SimpleEntry<>(1, 40));
        pq.offer(new AbstractMap.SimpleEntry<>(2, 10));
        pq.offer(new AbstractMap.SimpleEntry<>(3, 50));
        pq.offer(new AbstractMap.SimpleEntry<>(4, 30));

        System.out.println("Initial Max-Heap:");
        printQueue(pq);

        // Remove top element (max value)
        System.out.println("\nRemoved top element: " + pq.poll());

        // Replace an element (e.g., replace key 4's value with 60)
        pq.removeIf(e -> e.getKey() == 4); // delete existing
        pq.offer(new AbstractMap.SimpleEntry<>(4, 60)); // add new one

        System.out.println("\nAfter replacing key 4 with value 60:");
        printQueue(pq);

        // Delete an element (e.g., key 2)
        pq.removeIf(e -> e.getKey() == 2);

        System.out.println("\nAfter deleting key 2:");
        printQueue(pq);
    }

    private static void printQueue(PriorityQueue<Map.Entry<Integer, Integer>> pq) {
        // Make a copy to avoid mutating original queue while printing
        PriorityQueue<Map.Entry<Integer, Integer>> copy = new PriorityQueue<>(pq);
        while (!copy.isEmpty()) {
            Map.Entry<Integer, Integer> entry = copy.poll();
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
```
