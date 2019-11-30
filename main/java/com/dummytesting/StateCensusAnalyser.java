
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
public class StateCensusAnalyser {
    private static final String SAMPLE_CSV_FILE_PATH = "/home/user/PicturesStateCode.csv";
    public int numberOfRecord() throws CSVFileException, IOException {
        int noOfRecord = 0;
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            Iterator<CSVUser> csvUserIterator = csvToBean.iterator();
            while (csvUserIterator.hasNext()) {
                CSVUser csvUser = csvUserIterator.next();
                noOfRecord++;
            }
        }
        catch (NoSuchFileException e)
        {
            throw new CSVFileException("Please enter proper fileName",CSVFileException.ExceptionType.NO_SUCHFILE);
        }
        return noOfRecord;
    }
}





