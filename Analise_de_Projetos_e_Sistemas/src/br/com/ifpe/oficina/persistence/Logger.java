package br.com.ifpe.oficina.persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static final String ERRO_FILE_NAME = "erro.txt";
    private static final String INFO_FILE_NAME = "info.txt";

    public static void info(String text) {
        File file = new File(INFO_FILE_NAME);
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(text + System.lineSeparator());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo de log de info.");
        }
    }

    public static void error(String text) {
        File file = new File(ERRO_FILE_NAME);
        try (FileWriter writer = new FileWriter(file,true)) {
            writer.write(text + System.lineSeparator());

        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo de log de erro.");
        }
    }
}
