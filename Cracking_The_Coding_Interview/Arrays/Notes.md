# Hash Tables
Map keys to values for highly efficient lookup.

## Simple Implementation
Use an array of linked lists and a hash code function.
To insert a key:
1. Compute the hash code. Usually an int or long datatype. Two different keys could have the same hash code.
2. Map the hash code to an index in the array. E.g. `index = hash_code % array_length`.
3. This index contains a linked list. Insert the key-value pair at the head of the list. This linked list is used in case of collisions (two keys having same hash code and hence the same index)
   
Retrieval:
1. Compute the hash code.
2. Compute the index from the hash code.
3. The search the linked list at the index for the value with this key.

The worst case time complexity is O(n), which occurs when the hash function maps all keys to the same index. This is called a collision. The average case is O(1).

Alternative implementation is to use a balanced binary search tree. This is more efficient than the linked list implementation. The worst case time complexity is O(log n).

# ArrayList & Resizable Arrays
An array is a contiguous block of memory. It is a fixed size. If you want to add an element to an array, you need to create a new array of size n+1 and copy all the elements from the old array to the new array. This is inefficient.

An ArrayList is a resizable array. It is implemented as a dynamic array. It is a fixed size array that grows as needed. It is implemented as a fixed size array. When the array is full, a new array is created with double the size of the old array. The elements are copied from the old array to the new array. The old array is discarded.

This process is however very rare and thus the amortized runtime is O(1).

```java
ArrayList<string> merge(String[] words, String[] more) {
    ArrayList<String> sentence = new ArrayList<String>();
    for (String w : words) sentence.add(w);
    for (String w : more) sentence.add(w);
    return sentence;
}
```

# String Builder
A string builder is a resizable array of characters. It is used to build strings efficiently by appending characters. It is more efficient than using the `+` operator to concatenate strings.

```java
StringBuilder sentence = new StringBuilder();
for (String w : words)
    sentence.append(w);
```