package com.ddcompany;

import com.ddcompany.withDescritpion.FileParsingTest;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ZipFileTest {

    private ClassLoader cl = FileParsingTest.class.getClassLoader();

    @Test
    void zipFileTest() throws Exception {

        ZipFile zipFile = new ZipFile("src/test/resources/zip_sample.zip");


        ZipEntry zipCsvFile = zipFile.getEntry("csv_sample.csv");

    }
}
