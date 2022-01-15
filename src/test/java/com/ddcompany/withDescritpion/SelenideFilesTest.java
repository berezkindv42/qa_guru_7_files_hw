package com.ddcompany.withDescritpion;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;

public class SelenideFilesTest {

    @Test
//    void sownloadTest() {
//        try {
//            File downloadedFile = $("#raw-url").download();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } // в тестах try/catch быть не должно(!) это может привести к тому, что даже упавшие тесты будут зелеными
//    }

    void sownloadTest() throws Exception { // throws Exception заставляет Junit обработать исключения
        open("https://github.com/junit-team/junit5/blob/main/LICENSE.md");
        File downloadedFile = $("#raw-url").download(); // скачиваем файл по указанному id, получаем путь к нему и помещаем в объект класса File
        try (InputStream is = new FileInputStream(downloadedFile)) { // создаем из полученного объекта InputStream (передаем в конструктор переменную с объектом File)
            assertThat(new String(is.readAllBytes(), StandardCharsets.UTF_8)) // из стрима читаем все байты в кодировне UTF-8 и создаем из этих байтов строку
                    .contains("Eclipse Public License - v 2.0"); // проверяем, что в полученной строке есть искомый текст
            // Любой файл - это массив байт // метод .readAllBytes возвращает нам массив байт
            // Stream - это поток байт, из которых состоит файл
            // InputStream - это чтение байт из какого-то файла
            // OutputStream - это запись каких-то байт в какой-то файл
        }
    }
}
