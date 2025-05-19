package cz.habarta.typescript.generator;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class KinnuEnumTest {
    @Test
    public void testKinnuEnum() {
        final Settings settings = TestUtils.settings();
        settings.mapEnum = EnumMapping.asKinnuEnum;
        settings.kinnuEnumFields = Arrays.asList("id", "identifier");
        final String output = new TypeScriptGenerator(settings).generateTypeScript(Input.from(KClass.class));
        final String expected = (
                "interface KClass {\n" +
                        "    dummyIntKinnuEnum: DummyIntKinnuEnum;\n" +
                        "    dummyStringKinnuEnum: DummyStringKinnuEnum;\n" +
                        "}\n" +
                        "\n" +
                        "declare const enum DummyIntKinnuEnum {\n" +
                        "    ONE = 1,\n" +
                        "    TWO = 2,\n" +
                        "    THREE = 3,\n" +
                        "}" +
                        "\n\n" +
                        "declare const enum DummyStringKinnuEnum {\n" +
                        "    ONE = \"A\",\n" +
                        "    TWO = \"B\",\n" +
                        "    THREE = \"C\",\n" +
                        "}"
        ).replace("'", "\"");
        assertEquals(expected.trim(), output.trim());
    }


    private static class KClass {
        public DummyIntKinnuEnum dummyIntKinnuEnum;
        public DummyStringKinnuEnum dummyStringKinnuEnum;
    }
}
