package moduls;

import moduls.enumention.Status;

public class Employee extends Person{
     private Status status;
    private int payment = 100000;

    public int getPayment() {
        return payment;
    }

    public Employee(int id, String name, int passcode, Status status) {
        super(id, name, passcode);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "status=" + status +
                ", payment=" + payment +
                "} " + super.toString();
    }
}
