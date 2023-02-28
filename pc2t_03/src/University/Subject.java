package University;

public interface Subject {
    public final short minPointsForCredit = 15;

    public String getSubjectName();
    public short getSubjectPoints();
    public boolean canCreditBeGiven();
}
