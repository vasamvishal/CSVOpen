package com.dummytesting;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class AnalyserTest {
    @Test
    public void Shouldreturnhappy_ForProperFile() throws CSVFileException, IOException, ClassNotFoundException {
        Analyser stateCensusAnalyser = new Analyser();
       Assert.assertEquals(37, stateCensusAnalyser.numberOfRecord("/home/user/Pictures/StateCode.csv","com.dummytesting.StateCode"));
    }

    @Test
    public void shoulReturnSad_forImproperFile() throws IOException, ClassNotFoundException {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.numberOfRecord("/home/user/Pictures/StateCode.csv","com.dummytesting.StateCode");
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }

    @Test
    public void shoulReturnSad_forImproperFileName() throws IOException, ClassNotFoundException {
        try {
            Analyser stateCensusAnalyser = new Analyser();
            stateCensusAnalyser.numberOfRecord("/home/user/Pictures/StateCensusData.csv","com.dummytesting.StateCode");
        } catch (CSVFileException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS, e.type);
        }
    }

    @Test
    public void ShouldCatchException_forImproperDelimiter() throws CSVFileException, IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.numberOfRecord("/home/user/Pictures/StateCodeDuplicate.csv","com.dummytesting.StateCode");
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS, e.type);
        }
    }
    @Test
    public void ShouldCatchException_forHavingNoHeaders() throws CSVFileException, IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.numberOfRecord("/home/user/Pictures/StateCodeDuplicate.csv","com.dummytesting.StateCode");
        }
        catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS,e.type);
        }
    }
    @Test
    public void shouldBeProper_forProperFile() throws IOException, CSVFileException, ClassNotFoundException {
        Analyser analyser = new Analyser();
        Assert.assertEquals(29,analyser.recordOfStateCensusData("/home/user/Pictures/StateCensusData.csv","com.dummytesting.StateCensusData" ));
    }
    @Test
    public void shouldCatch_FilenotFoundException_forImProperFile() throws IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.recordOfStateCensusData("/home/user/Pictures/StateCensusData.csv","com.dummytesting.StateCensusData");
        }
        catch (CSVFileException e)
        {
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE,e.type);
        }
    }
    @Test
    public void shouldCatchException_forImProperTypeName() throws IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.recordOfStateCensusData("/home/user/Pictures/StateCode.csv","com.dummytesting.StateCensusData");
        } catch (CSVFileException e) {
            System.out.println(e.getMessage());
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS, e.type);
        }
    }
    @Test
    public void ShouldCatchException_forImproperDelimiterinStateCensusData() throws CSVFileException, IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.numberOfRecord("/home/user/Pictures/StateCensusDataDuplicate.csv","com.dummytesting.StateCensusData");
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS, e.type);
        }
    }
    @Test
    public void ShouldCatchException_forHavingNoHeadersinStateCensusData() throws CSVFileException, IOException, ClassNotFoundException {
        try {
            Analyser analyser = new Analyser();
            analyser.numberOfRecord("/home/user/Pictures/StateCodeDuplicate.csv","com.dummytesting.StateCensusData");
        }
        catch (CSVFileException e){
            Assert.assertEquals(CSVFileException.ExceptionType.WRONG_OPTIONS,e.type);
        }
    }

}




