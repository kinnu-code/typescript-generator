package cz.habarta.typescript.generator;

public enum DummyStringKinnuEnum {
    ONE("A"),
    TWO("B"),
    THREE("C");

    public final String identifier;

    private DummyStringKinnuEnum(String identifier) {
        this.identifier = identifier;
    }
}
