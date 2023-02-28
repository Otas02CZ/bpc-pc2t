package University;

public class BPC2 implements Subject{
    private short projectPoints = 0;
    private boolean projectDone = false;
    private short halfSemesterExamPoints = 0;
    private boolean halfSemesterDone = false;
    private short examPoints = 0;
    private boolean examDone = false;

    @Override
    public String getSubjectName() {
        return "BPC2";
    }

    @Override
    public short getSubjectPoints() {
        return (short) (projectPoints+halfSemesterExamPoints+examPoints);
    }

    @Override
    public boolean canCreditBeGiven() {
        return (halfSemesterExamPoints+projectPoints >= minPointsForCredit);
    }

    public boolean addPointsForProject(short projectPointsToAdd) {
        if (projectDone) return false;
        if (projectPointsToAdd < 0) return false;
        if (projectPointsToAdd > 30) {
            projectPoints = 30;
            projectDone = true;
            return true;
        }
        projectPoints = projectPointsToAdd;
        projectDone = true;
        return true;
    }

    public boolean addPointsForHalfSemesterExam(short halfSemesterExamPointsToAdd) {
        if (halfSemesterDone) return false;
        if (halfSemesterExamPointsToAdd < 0) return false;
        if (halfSemesterExamPointsToAdd > 20) {
            halfSemesterExamPoints = 20;
            halfSemesterDone = true;
            return true;
        }
        halfSemesterExamPoints = halfSemesterExamPointsToAdd;
        halfSemesterDone = true;
        return true;
    }

    public boolean addPointsForExam(short examPointsToAdd) {
        if (examDone) return false;
        if (examPointsToAdd < 0) return false;
        if (examPointsToAdd > 50) {
            examPoints = 50;
            examDone = true;
            return true;
        }
        examPoints = examPointsToAdd;
        examDone = true;
        return true;
    }
}
