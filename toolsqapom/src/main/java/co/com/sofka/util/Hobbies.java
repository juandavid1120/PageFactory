package co.com.sofka.util;

public enum Hobbies {
    SPORTS("Sports"),
    READING("Reading"),
    MUSIC("Music");

    private final String value;

    public String getValue() {
        return value;
    }

    Hobbies(String value) {
        this.value = value;
    }
}
