package moduls;

import moduls.enumention.Status;

public class Professor extends Employee{
    private int unit;


    @Override
    public int getPayment() {
        return unit*super.getPayment();
    }


    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public Professor(int id, String name, int passcode, Status status) {
        super(id, name, passcode, status);
    }

    @Override
    public String toString() {
        return "Professor{" +
                "unit=" + unit +
                "} " + super.toString();
    }

}
