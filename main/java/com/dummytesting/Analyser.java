
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
public String SAMPLE_CSV_FILE_PATH="";
    public Analyser(String SAMPLE_CSV_FILE_PATH) {
        this.SAMPLE_CSV_FILE_PATH=SAMPLE_CSV_FILE_PATH;
    }

    public int numberOfRecord() throws CSVFileException, IOException {
        int noOfRecord = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                csvUserIterator.next();
                noOfRecord++;
            }
        } catch (NoSuchFileException e)
        {
            e.printStackTrace();
        }
        catch ( RuntimeException e)
        {
            throw new CSVFileException("Please enter proper fileName Or Delimiter Problem Or Header Problem ",CSVFileException.ExceptionType.WRONG_OPTIONS);
        }
        return noOfRecord;
    }

    public int recordOfStateCensusData() throws IOException, CSVFileException {
        int noOfRecord=0;
        try{
            Reader reader=Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(StateCensusData.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<StateCensusData> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                csvUserIterator.next();
                noOfRecord++;
            }
        } catch (NoSuchFileException e) {
            throw new CSVFileException("Please enter proper file name", CSVFileException.ExceptionType.NO_SUCHFILE);
        }
        catch ( RuntimeException e)
        {
            try {
                throw new CSVFileException("Please enter proper fileName Or Delimiter Problem Or Header Problem ",CSVFileException.ExceptionType.WRONG_OPTIONS);
            } catch (CSVFileException ex) {
                ex.printStackTrace();
            }
        }
        return noOfRecord;
    }

}






