

package com.dummytesting;

import com.opencsv.bean.CsvBindByName;

    public class CSVUser {

        @CsvBindByName
        private String SrNo;

        @CsvBindByName
        private String StateName;

        @CsvBindByName
        private String TIN;

        @CsvBindByName
        private String StateCode;

    }