public class HealthStation {
    
    private int numberOfWeighings;

    public int weigh(Person person) {
        numberOfWeighings++;
        return person.getWeight();
    }

    public void feed(Person person) {
        person.setWeight(weigh(person) + 1);
    }

    public int weighings() {
        return numberOfWeighings;
    }
}
