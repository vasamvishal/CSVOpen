

package com.dummytesting;

import com.opencsv.bean.CsvBindByName;

    public class StateCode {

        @CsvBindByName(column = "SrNo" ,required = true)
        private String SrNo;

        @CsvBindByName(column = "StateName" ,required = true)
        private String StateName;

        @CsvBindByName(column = "TIN",required = true)
        private String TIN;

        @CsvBindByName(column = "StateCode")
        private String StateCode;

        public String getSrNo() {
            return SrNo;
        }

        public void setSrNo(String srNo) {
            SrNo = srNo;
        }

        public String getStateName() {
            return StateName;
        }

        public void setStateName(String stateName) {
            StateName = stateName;
        }

        public String getTIN() {
            return TIN;
        }

        public void setTIN(String TIN) {
            this.TIN = TIN;
        }

        public String getStateCode() {
            return StateCode;
        }

        public void setStateCode(String stateCode) {
            StateCode = stateCode;
        }
    }