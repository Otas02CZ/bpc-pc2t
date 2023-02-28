package University;

public class BPC1 implements Subject{
    private short exercisePoints = 0;
    private short examPoints = 0;
    private boolean examDone = false;
    @Override
    public String getSubjectName() {
        return "BPC1";
    }

    @Override
    public short getSubjectPoints() {
        return (short) (examPoints+exercisePoints);
    }

    @Override
    public boolean canCreditBeGiven() {
        return (exercisePoints >= minPointsForCredit);
    }

    public boolean addPointsForExercise(short exercisePointsToAdd) {
        short newExercisePoints = (short) (exercisePoints + exercisePointsToAdd);
        if (exercisePointsToAdd < 0) return false;
        if (newExercisePoints > 20) {
            exercisePoints = 20;
            return false;
        }
        else {
            exercisePoints = newExercisePoints;
            return true;
        }
    }

    public boolean addPointsForExam(short examPointsToAdd) {
        if (examDone) return false;
        if (examPointsToAdd < 0) return false;
        if (examPointsToAdd > 80) {
            examPoints = 80;
            examDone = true;
            return true;
        }
        examPoints = examPointsToAdd;
        examDone = true;
        return true;
    }
}
