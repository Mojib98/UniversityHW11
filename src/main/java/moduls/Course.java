package moduls;

public class Course extends BaseClass{
    private int unit;
    private String professor;
    private int  professorId;
    private int degree;
    private int studenNumber;

    public Course(int id, String name, int unit, String professor, int  professorId) {
        super(id, name);
        this.unit = unit;
        this.professor = professor;
        this.professorId = professorId;
    }

    public Course(int id, String name, int unit, String professor, int degree, int studenNumber) {
        super(id, name);
        this.unit = unit;
        this.professor = professor;
        this.degree = degree;
        this.studenNumber = studenNumber;
    }

    public int getUnit() {
        return unit;
    }

    public String getProfessor() {
        return professor;
    }

    public int getProfessorId() {
        return professorId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "unit=" + unit +
                ", professor='" + professor + '\'' +
                ", professorId=" + professorId +
                ", degree=" + degree +
                ", studenNumber=" + studenNumber +
                "} " + super.toString();
    }
}
