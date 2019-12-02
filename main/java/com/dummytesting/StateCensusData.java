package com.dummytesting;

import com.opencsv.bean.CsvBindByName;

public class StateCensusData {


        @CsvBindByName(column = "State",required = true)
        private String State;

        @CsvBindByName(column = "Population",required = true)
        private String Population;

        @CsvBindByName(column = "AreaInSqKm",required =true)
        private String AreaInSqKm ;

        @CsvBindByName(column = "DensityPerSqKm",required = true)
        private String DensityPerSqKm;


}
