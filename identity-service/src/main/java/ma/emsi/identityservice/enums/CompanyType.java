package ma.emsi.identityservice.enums;


public enum CompanyType {
    PETITE(50),
    MOYENNE(249),
    GRANDE(Integer.MAX_VALUE);

    private final int maxEmployees;

    // Constructor
    CompanyType(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }

    // Getter
    public int getMaxEmployees() {
        return maxEmployees;
    }

    // Static method to determine the company type
    public static CompanyType determineCompanyType(int employees) {
        if (employees <= PETITE.maxEmployees) {
            return PETITE;
        } else if (employees <= MOYENNE.maxEmployees) {
            return MOYENNE;
        } else {
            return GRANDE;
        }
    }
}
