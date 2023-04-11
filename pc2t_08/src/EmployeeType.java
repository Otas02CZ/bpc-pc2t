public enum EmployeeType {
    ACTIVE("active"),
    INACTIVE("inactive"),
    DELETED("deleted")
    ;

    private final String text;

    /**
     * @param text
     */
    EmployeeType(final String text) {
        this.text = text;
    }

    /* (non-Javadoc)
     * @see java.lang.Enum#toString()
     */
    @Override
    public String toString() {
        return text;
    }
}
