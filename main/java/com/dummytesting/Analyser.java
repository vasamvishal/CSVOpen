
//Welcome to the opencsv program
package com.dummytesting;

import com.google.gson.Gson;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.*;

public class Analyser {

    private static String SAMPLE_JSON_FILE_PATH = "/home/user/Pictures/PopulationData.json";

    public int numberOfRecord(String SAMPLE_CSV_FILE_PATH, String POJO) throws CSVFileException, IOException, ClassNotFoundException {
        System.out.println(SAMPLE_CSV_FILE_PATH);
        int count = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            List<StateCensusData> list = new ArrayList();
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Class.forName(POJO))
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                StateCensusData data = (StateCensusData) csvUserIterator.next();
                list.add(data);
                count++;
            }
            sortThisListBasedOnStateName(list);
            sortThisListBasedOnStatePopulation(list);
            sortThisListBasedOnDensityPerSqKmPopulation(list);
            sortThisListBasedOnAreaPerSqKmPopulation(list);
            WriteToJson(list);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new CSVFileException("Please enter proper fileName Or Delimiter Problem Or Header Problem ", CSVFileException.ExceptionType.WRONG_OPTIONS);
        }
        return count;
    }

    private static void WriteToJson(List<StateCensusData> list) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
        writer.write(json);
        writer.close();
    }
    private static void sortThisListBasedOnStateName(List<StateCensusData> censusList) {
        Comparator<StateCensusData> c = (s1, s2) -> s1.getState().compareTo(s2.getState());
        censusList.sort(c);
    }
    private static void sortThisListBasedOnStatePopulation(List<StateCensusData> censusList) {
        Comparator<StateCensusData> c = Comparator.comparing(StateCensusData::getPopulation);
        censusList.sort(c);
    }
    private static void sortThisListBasedOnDensityPerSqKmPopulation(List<StateCensusData> censusList) {
        Comparator<StateCensusData> c = (s1, s2) -> Integer.parseInt(s2.getDensityPerSqKm()) - Integer.parseInt(s1.getDensityPerSqKm());
        censusList.sort(c);
    }
    private static void sortThisListBasedOnAreaPerSqKmPopulation(List<StateCensusData> censusList) {
        Comparator<StateCensusData> c = (s1, s2) -> Integer.parseInt(s2.getAreaInSqKm()) - Integer.parseInt(s1.getAreaInSqKm());
        censusList.sort(c);
    }
}







