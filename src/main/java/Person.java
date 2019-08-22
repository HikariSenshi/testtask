
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {
    private int id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    static void order(final List<Person> persons, int[] ids) {
        //check parameters for null's
        if (persons == null) throw new IllegalArgumentException("List of persons should not be null");
        if (ids == null) throw new IllegalArgumentException("Array with ids should not be null");

        //check that incoming list of persons does not has collisions

        for (int i = 0; i < persons.size() - 2; i++) {
            if (persons.get(i).getId() == persons.get(i + 1).getId())
                throw new IllegalStateException("Incoming list has more than one element with same id");
        }

        //Revert iterating helps to place elements in necessary order using less resources

        iterator:
        for (int j = ids.length - 1; j > -1; j--) {

            //find element with necessary id and put it to head of array
            //if element would not founded, nothing will changed
            for (Person current : persons) {
                if (current.getId() == ids[j]) {
                    persons.remove(current);
                    persons.add(0, current);
                    continue iterator;
                }

            }

        }

    }

}
