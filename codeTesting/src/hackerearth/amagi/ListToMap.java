package hackerearth.amagi;

/**
 * @author : ssuddhapally
 * @since : 10/11/20, Tue
 **/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

// create a list
class Student {

  // id will act as Key
  private Integer id;

  // name will act as value
  private String name;

  // create curstuctor for reference
  public Student(Integer id, String name) {

    // assign the value of id and name
    this.id = id;
    this.name = name;
  }

  // return private variable id
  public Integer getId() {
    return id;
  }

  // return private variable name
  public String getName() {
    return name;
  }
}

// main class and method
public class ListToMap {

  // main Driver
  public static void main(String[] args) {

    // create a list
    List<Student> lt = new ArrayList<>();

    // add the member of list
    lt.add(new Student(1, "Geeks"));
    lt.add(new Student(2, "For"));
    lt.add(new Student(3, "Geeks"));
    lt.add(new Student(1, "dudeDuplicate"));

    // create map with the help of
    // Collectors.toMap() method
    HashMap<Integer, Student>
            map = lt.stream()
            .collect(
                    Collectors
                            .toMap(
                                    Student::getId,
                                    Function.identity(),
                                    (x, y)
                                            -> y,
                                    HashMap::new));

    // print map
    map.forEach(
            (x, y) -> System.out.println(x + "=" + y));
  }
}
