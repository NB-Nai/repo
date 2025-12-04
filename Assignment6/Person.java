/*
 * Class: CMSC203 23118
 * Instructor: Huseyin Aygun
 * Description: Allow for managing different parts of the circus such as animals, buildings, people, and ticket sales, and calculate the cost of ticket based on their preference.
 * Due: 12/08/25
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
* independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Natdanai Boonyaleephan
*/

public abstract class Person {
    private String name;
    private int age;
    private int yearsWorked;

    public Person(String name, int age, int yearsWorked) {
        this.name = name;
        this.age = age;
        this.yearsWorked = yearsWorked;
     }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getYearsWorked() {
        return yearsWorked;
    }

}