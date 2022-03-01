package moduls;
public class Student extends Person{
    private int unit;

    public Student(int id, String name, int passcode) {
        super(id, name, passcode);

    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Student{" +
                "unit=" + unit +
                "} " + super.toString();
    }
}
