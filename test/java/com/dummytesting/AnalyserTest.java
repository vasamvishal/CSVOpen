package com.dummytesting;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AnalyserTest {
    @Test
    public void Shouldreturnhappy_ForProperFile() throws CSVFileException, IOException {
        Analyser stateCensusAnalyser = new Analyser("/home/user/Pictures/StateCode.csv");
        Assert.assertEquals(37, stateCensusAnalyser.numberOfRecord());
    }

    @Test
    public void shoulReturnSad_forImproperFile() throws IOException {
        try {
            Analyser stateCensusAnalyser = new Analyser("/home/user/Pictures/StateCode.csv");
            stateCensusAnalyser.numberOfRecord();
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }

    @Test
    public void shoulReturnSad_forImproperFileName() throws IOException {
        try {
            Analyser stateCensusAnalyser = new Analyser("/home/user/Pictures/StateCensusData.csv");
            stateCensusAnalyser.numberOfRecord();
        } catch (CSVFileException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }

    @Test
    public void ShouldCatchException_forImproperDelimiter() throws CSVFileException, IOException {
        try {
            Analyser analyser = new Analyser("/home/user/Pictures/StateCodeDuplicate.csv");
            analyser.numberOfRecord();
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }
    @Test
    public void ShouldCatchException_forHavingNoHeaders() throws CSVFileException, IOException {
        try {
            Analyser analyser = new Analyser("/home/user/Pictures/StateCodeDuplicate.csv");
            analyser.numberOfRecord();
        }
        catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS,e.type);
        }
    }
    @Test
    public void shouldBeProper_forProperFile() throws IOException, CSVFileException {
        Analyser analyser = new Analyser("/home/user/Pictures/StateCensusData.csv");
        Assert.assertEquals(29,analyser.recordOfStateCensusData());
    }
}




