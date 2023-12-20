import java.util.Objects;

public class Person {

    private String name;
    private SimpleDate birthday;
    private int height;
    private int weight;

    public Person(String name, SimpleDate birthday, int height, int weight) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }

        Person comparedPerson = (Person) compared;

        if (name.equals(comparedPerson.name) &&
                birthday.equals(comparedPerson.birthday) &&
                height == comparedPerson.height &&
                weight == comparedPerson.weight) {
            return true;
        }
        return false;
    }
}
