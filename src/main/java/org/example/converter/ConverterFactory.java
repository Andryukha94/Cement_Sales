package org.example.converter;

public class ConverterFactory {
    public static OrderConverter FactoryConverter(String inputFile) {
        if (inputFile.contains("hash")) {
            return new HashOrderConverter();
        } else {
            return new CommaOrderConverter();
        }
    }
}