package University;

public class BPIS implements Subject{
    private boolean creditGiven = false;
    @Override
    public String getSubjectName() {
        return "BPIS";
    }

    @Override
    public short getSubjectPoints() {
        return 0;
    }

    @Override
    public boolean canCreditBeGiven() {
        return true;
    }

    public void giveCredit() {
        creditGiven = true;
    }

    public boolean isCreditGiven() {
        return creditGiven;
    }
}
