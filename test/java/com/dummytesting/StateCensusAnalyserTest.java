package com.dummytesting;
import org.junit.Assert;
import org.junit.Test;
public class StateCensusAnalyserTest {
    @Test
    public void Shouldreturnhappy_ForProperFile() {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        Assert.assertEquals(37, stateCensusAnalyser.numberOfRecord());
    }
}




