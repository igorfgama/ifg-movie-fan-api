package br.com.ifg.enums;

public enum TypeEnum {
    MOVIE("movie"), SERIES("series"), EPISODE("episode");

    private final String type;

    TypeEnum(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
