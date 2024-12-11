package ma.emsi.serviceClient_com.enums;

public enum Category {
    GROS_ACHETEUR_FREQUENT("Client qui achète en gros fréquemment."),
    GROS_ACHETEUR_OCCASIONNEL("Client qui achète en gros de façon occasionnelle."),
    GROS_ACHETEUR_GRANDE_VALEUR("Client qui achète en gros avec une grande valeur monétaire."),
    GROS_ACHETEUR_NOUVEAU("Nouveau client qui commence à acheter en gros.");

    private final String description;
    Category(String description) {
        this.description=description;
    }
    public String getDescription() {
        return description;
    }

}