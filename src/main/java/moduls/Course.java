package moduls;

public class Course extends BaseClass{
    private int unit;
    private String professor;
    private int  professorId;

    public Course(int id, String name, int unit, String professor, int  professorId) {
        super(id, name);
        this.unit = unit;
        this.professor = professor;
        this.professorId = professorId;
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
}
