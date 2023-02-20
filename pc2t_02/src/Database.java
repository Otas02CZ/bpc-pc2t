public class Database {
    String name;
    short birthYear;
    float workingTime;
    static float workingTimeMax = 1;

    Database(String name, short birthYear) {
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public short getBirthYear() {
        return birthYear;
    }

    public float getWorkingTime() {
        return workingTime;
    }

    public float getWorkingTimeMax() {
        return workingTimeMax;
    }

    static void setMaxWorkingTime(float workingTimeNew) {
        workingTimeMax = workingTimeNew;
    }

    public boolean updateWorkingTime(float newWorkingTime) {
        float tempWorkingTime = this.workingTime + newWorkingTime;
        if (tempWorkingTime > workingTimeMax)
            return false;
        else {
            this.workingTime = tempWorkingTime;
            return true;
        }
    }

    public String getInfo() {
        return this.name + " - " + this.birthYear + " - " + this.workingTime;
    }


}
