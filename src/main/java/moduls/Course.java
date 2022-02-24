package moduls;

public class Course extends BaseClass{
    private int unit;
    private String professor;
    private String college;

    public Course(int id, String name, int unit, String professor, String college) {
        super(id, name);
        this.unit = unit;
        this.professor = professor;
        this.college = college;
    }
}
