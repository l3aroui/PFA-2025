package ma.emsi.serviceClient_com.enums;

public enum Type {
    B2B("Business-to-Business: Transactions or interactions between businesses."),
    B2C("Business-to-Consumer: Transactions or interactions directly between a business and individual consumers.");

    private final String definition;

    // Constructor
    Type(String definition) {
        this.definition = definition;
    }

    // Getter for the definition
    public String getDefinition() {
        return definition;
    }
}
