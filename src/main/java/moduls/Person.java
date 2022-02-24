package moduls;

public abstract class Person extends BaseClass {
    private int passcode;

    public Person(int id, String name, int passcode) {
        super(id, name);
        this.passcode = passcode;
    }

    public int getPasscode() {
        return passcode;
    }

    public void setPasscode(int passcode) {
        this.passcode = passcode;
    }

    @Override
    public String toString() {
        return "Person{" +
                "passcode=" + passcode +
                "} " + super.toString();
    }
}
