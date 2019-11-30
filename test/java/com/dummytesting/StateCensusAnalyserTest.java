package com.dummytesting;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class StateCensusAnalyserTest {
    @Test
    public void Shouldreturnhappy_ForProperFile() throws CSVFileException, IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(37, stateCensusAnalyser.numberOfRecord());
    }

    @Test
    public void shoulReturnSad_forImproperFile() throws IOException {
        try {
            StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
            stateCensusAnalyser.numberOfRecord();
        } catch (CSVFileException e) {
            Assert.assertEquals(CSVFileException.ExceptionType.NO_SUCHFILE, e.type);
        }
    }
}




