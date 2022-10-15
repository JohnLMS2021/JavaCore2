package Lesson7;

public final class ApplicationGlobalState {

    private static ApplicationGlobalState INSTANCE = new ApplicationGlobalState();
    private String selectedLat = null;
    private String selectedLon = null;
    private final String API_KEY = "f0d46c92-ac5d-408a-9369-25018d670770";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        return INSTANCE;
    }

    public String getSelectedLat() {
        return selectedLat;
    }
    public String getSelectedLon() {
        return selectedLon;
    }

    public void setSelectedLat(String selectedLat) {
        this.selectedLat = selectedLat;
    }
    public void setSelectedLon(String selectedLon) {
        this.selectedLon = selectedLon;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}