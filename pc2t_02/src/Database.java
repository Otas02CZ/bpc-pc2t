public class Database {
    private String name;
    private short birthYear;
    private float workLoad;
    private static float workLoadMax = 1;

    Database(String name, short birthYear) {
        super();
        this.name = name;
        this.birthYear = birthYear;
    }

    public String getName() {
        return name;
    }

    public short getBirthYear() {
        return birthYear;
    }

    public float getWorkLoad() {
        return this.workLoad;
    }

    public static float getMaxWorkLoad() {
        return workLoadMax;
    }

    public static void setMaxWorkLoad(float workLoadNew) {
        workLoadMax = workLoadNew;
    }

    public boolean updateWorkload(float newWorkLoad) {
        float tempWorkLoad = this.workLoad + newWorkLoad;
        if (tempWorkLoad > workLoadMax)
            return false;
        else {
            this.workLoad = tempWorkLoad;
            return true;
        }
    }

    public String getInfo() {
        return this.name + " - " + this.birthYear + " - " + this.workLoad;
    }


}
