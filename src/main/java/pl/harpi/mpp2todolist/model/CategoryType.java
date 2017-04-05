package pl.harpi.mpp2todolist.model;

public enum CategoryType {
    ANA("Analiza"),
    DEV("Development"),
    TST("Testy"),
    WDR("Wdrożenie"),
    SZAC("Szacowanie"),
    KON("Koncepcja"),
    BIU("Biuro"),
    WER("Weryfikacja");

    private String description;

    CategoryType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
