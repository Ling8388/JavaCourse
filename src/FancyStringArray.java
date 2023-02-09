
import java.util.Arrays;

public class FancyStringArray {
  private int sizes;
  private final String[] arr;

  public FancyStringArray() {
    this.arr = new String[10];
  };
  public FancyStringArray(int capacity) {
    if (capacity < 0) {
      throw new IllegalArgumentException("Capacity cannot be negative.");
    }
    this.arr = new String[capacity];
  };

  public int size() {
    return sizes;
  };
  public void add(String element) {
    if (arr[arr.length-1] != null) {
      throw new IllegalArgumentException("The array is full.");
    }
    arr[this.sizes] = element;
    sizes++;
  };
  public String get(int index) {
    if (index < 0 || index >= this.sizes) {
      throw new IllegalArgumentException("The index cannot be negative or greater than or equal to the size.");
    }
    return arr[index];
  };
  public String set(int index, String newElement) {
    if (index < 0 || index >= this.sizes) {
      throw new IllegalArgumentException("The index cannot be negative or greater than or equal to the size.");
    }
    String temp = arr[index];
    arr[index] = newElement;
    return temp;
  };
  public boolean contains(String s){
    for(int i=0; i<this.sizes; i++) {
      if(arr[i].equals(s)) {
        return true;
      }
    }
    return false;
  };

  @Override
  public String toString() {
    String st = "";
    for (int i=0; i<this.sizes; i++) {
      if(i>0) {
        st += ",";
      }
      st += arr[i];
    }
    return "[" + st + "]";
  };

  @Override
  public boolean equals(Object o) {
    if(o instanceof FancyStringArray) {
      FancyStringArray other = (FancyStringArray) o;
      for (int i = 0; i < this.sizes; i++) {
        if (!this.arr[i].equals(other.arr[i])) {
          return false;
        }
      }
      return true;
    }
    return false;
  };
}
