/**
 *
 */
package org.rash.collections;

/**
 * @author Ammi
 */
public class CustomHashMap<K, V> {
    private int intialCapacity = 10;
    private Entry<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Entry[intialCapacity];
    }

    @SuppressWarnings("unchecked")
    public CustomHashMap(int intialcapacity) {
        this.intialCapacity = intialcapacity;
        buckets = new Entry[intialCapacity];
    }

    public static void main(String args[]) {
        CustomHashMap<String, String> map = new CustomHashMap<>();
        map.put("Rasool", "Shaik");
        map.put("Shaik", "World");

        map.put("one", "two");
        map.put("three", "four");
        map.put("five", "six");

        map.put("seven", "eight");
        map.put("nine", "ten");

        map.display();

        map.remove("three");
        System.out.println();
        map.display();
        System.out.println();
        System.out.println(map.get("Rasool"));

    }

    public int hash(K key) {
        return (Math.abs(key.hashCode()) % intialCapacity);
    }

    public void put(K key, V value) {
        if (key == null)
            return;
        int hash = hash(key);
        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
        if (buckets[hash] == null) {
            buckets[hash] = newEntry;
        } else {
            Entry<K, V> previousEntry = null;
            for (Entry<K, V> currentEntry = buckets[hash]; currentEntry != null; previousEntry = currentEntry, currentEntry = currentEntry.next) {
                if (currentEntry.key.equals(newEntry.key)) {
                    currentEntry.value = newEntry.value;
                    return;
                }
            }
            newEntry.next = previousEntry.next;
            previousEntry.next = newEntry;
        }
    }

    public V get(K key) {
        if (key == null)
            return null;
        int hash = hash(key);
        if (buckets[hash] == null) {
            return null;
        } else {
            for (Entry<K, V> currentEntry = buckets[hash]; currentEntry != null; currentEntry = currentEntry.next) {
                if (currentEntry.key.equals(key)) {
                    return currentEntry.value;
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        if (key == null)
            return;
        int hash = hash(key);
        if (buckets[hash] == null) {
            return;
        } else {
            Entry<K, V> previousEntry = null;
            for (Entry<K, V> currentEntry = buckets[hash]; currentEntry != null; previousEntry = currentEntry, currentEntry = currentEntry.next) {
                if (currentEntry.key.equals(key)) {
                    if (previousEntry == null) {
                        buckets[hash] = buckets[hash].next;
                        return;
                    } else {
                        previousEntry.next = currentEntry.next;
                        return;
                    }
                }
            }
        }
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            for (Entry<K, V> currentEntry = buckets[i]; currentEntry != null; currentEntry = currentEntry.next) {
                System.out.println(currentEntry.key + " " + currentEntry.value);
            }
        }
    }

    public static class Entry<K, V> {
        public K key;
        public V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
