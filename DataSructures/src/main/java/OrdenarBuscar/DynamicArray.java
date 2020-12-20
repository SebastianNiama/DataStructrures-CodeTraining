
package EstructurasDatos;

import java.util.Iterator;

@SuppressWarnings("unchecked")
/*
Here is creating an array class to be used with a generic type
in this case the type is "T"
*/
public class DynamicArray<T> implements Iterable<T> {

  private T[] arr;//Internal static array
  private int len = 0; // It is the length user thinks array is
  private int capacity = 0; // It is the length of the Actual array size
//1st constructor
  /*
  This one will initialize the array to be size 16
  */
  public DynamicArray() {
    this(16);
  }
//2nd Constructor
  /*
  At this one you give it a capacity
  */
  public DynamicArray(int capacity) {
      //The capacity needs to be greater than or equal to zero:
    if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    this.capacity = capacity;
    /*
    Now, we initialize our array and cast it to a type "T"
    */
    arr = (T[]) new Object[capacity];
  }

  public int size() {
    return len;
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public T get(int index) {
    if (index >= len || index < 0) throw new IndexOutOfBoundsException();
    return arr[index];
  }

  public void set(int index, T elem) {
    if (index >= len || index < 0) throw new IndexOutOfBoundsException();
    arr[index] = elem;
  }
//Here we jsut remove all the data in our array, and reset the length
  public void clear() {
    for (int i = 0; i < len; i++) arr[i] = null;
    len = 0;
  }
/*
  Here is the add method
  */
  public void add(T elem) {

    // Time to resize!
    if (len + 1 >= capacity) {
      if (capacity == 0) capacity = 1;
      else capacity *= 2; // double the size
      T[] new_arr = (T[]) new Object[capacity];
      for (int i = 0; i < len; i++) new_arr[i] = arr[i];
      arr = new_arr; // arr has extra nulls padded OJO
    }

    arr[len++] = elem; //OJO
  }

  // Removes an element at the specified index in this array.
  public T removeAt(int rm_index) {
    if (rm_index >= len || rm_index < 0) throw new IndexOutOfBoundsException();
    T data = arr[rm_index];
    T[] new_arr = (T[]) new Object[len - 1];
    for (int i = 0, j = 0; i < len; i++, j++)
      if (i == rm_index) j--; // Skip over rm_index by fixing j temporarily
      else new_arr[j] = arr[i];
    arr = new_arr;
    capacity = --len;
    return data;
  }

  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) return false;
    removeAt(index);
    return true;
  }

  public int indexOf(Object obj) {
    for (int i = 0; i < len; i++) {
      if (obj == null) {
        if (arr[i] == null) return i;
      } else {
        if (obj.equals(arr[i])) return i;
      }
    }
    return -1;
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  // Iterator is still fast but not as fast as iterative for loop
  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < len;
      }

      @Override
      public T next() {
        return arr[index++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }

  @Override
  public String toString() {
    if (len == 0) return "[]";
    else {
      StringBuilder sb = new StringBuilder(len).append("[");
      for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
      return sb.append(arr[len - 1] + "]").toString();
    }
  }
}