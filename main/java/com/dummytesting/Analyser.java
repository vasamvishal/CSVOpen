
//Welcome to the opencv program



package com.dummytesting;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
public class Analyser {
    public int OpenCSVBuilder(Reader reader, String POJO) throws ClassNotFoundException {
        int noOfRecord = 0;
        CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                .withType(Class.forName(POJO))
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        Iterator<StateCode> csvUserIterator = csvToBean.iterator();
        while (csvUserIterator.hasNext()) {
            csvUserIterator.next();
            noOfRecord++;
        }
        
        return  noOfRecord;

    }

    public int numberOfRecord(String SAMPLE_CSV_FILE_PATH, String POJO) throws CSVFileException, IOException, ClassNotFoundException {
            int record=0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            record = OpenCSVBuilder(reader, POJO);
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (RuntimeException e) {
            throw new CSVFileException("Please enter proper fileName Or Delimiter Problem Or Header Problem ", CSVFileException.ExceptionType.WRONG_OPTIONS);
        }

        return record;
    }

    public int recordOfStateCensusData(String SAMPLE_CSV_FILE_PATH, String POJO) throws IOException, CSVFileException, ClassNotFoundException {
        int record = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            record = OpenCSVBuilder(reader, POJO);
        } catch (NoSuchFileException e) {
            throw new CSVFileException("Please enter proper file name", CSVFileException.ExceptionType.NO_SUCHFILE);
        } catch (RuntimeException e) {
                throw new CSVFileException("Please enter proper fileName Or Delimiter Problem Or Header Problem ", CSVFileException.ExceptionType.WRONG_OPTIONS);
        }
        return record;
    }
}







