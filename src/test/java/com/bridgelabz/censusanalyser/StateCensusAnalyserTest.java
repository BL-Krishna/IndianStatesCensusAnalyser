package com.bridgelabz.censusanalyser;

import com.bridgelabz.censusanalyser.exception.CensusAnalyserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    private static final String STATE_CENSUS_CSV =
            "src/main/resources/IndiaStateCensusData.csv";

    @Test
    public void givenCorrectCSV_ShouldReturnCorrectCount()
        throws CensusAnalyserException{
            StateCensusAnalyser analyser=new StateCensusAnalyser();
            int count  = analyser.loadStateCensusData(STATE_CENSUS_CSV);
            Assertions.assertEquals(29,count);
    }

    @Test
    public void givenIncorrectFile_ShouldThrowException(){
        StateCensusAnalyser analyser=new StateCensusAnalyser();

        Assertions.assertThrows(
                CensusAnalyserException.class,
                ()->analyser.loadStateCensusData("wrong.csv")

        );
    }

    @Test
    public void givenWrongFile_ShouldThrowException(){
       StateCensusAnalyser analyser =new StateCensusAnalyser();

       Assertions.assertThrows(
               CensusAnalyserException.class,
               ()-> analyser.loadStateCensusData("IndianStateCensusData.txt")
       );
    }



}
