package com.bridgelabz.censusanalyser;

import com.bridgelabz.censusanalyser.exception.CensusAnalyserException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StateCensusAnalyserTest {

    private static final String STATE_CENSUS_CSV =
            "src/main/resources/IndiaStateCensusData.csv";
    //UC 1.1 - Happy Test Case
    @Test
    public void givenCorrectCSV_ShouldReturnCorrectCount()
        throws CensusAnalyserException{
            StateCensusAnalyser analyser=new StateCensusAnalyser();
            int count  = analyser.loadStateCensusData(STATE_CENSUS_CSV);
            Assertions.assertEquals(29,count);
    }
    //UC 1.2 - Incorrect File(Sad test case)
    @Test
    public void givenIncorrectFile_ShouldThrowException(){
        StateCensusAnalyser analyser=new StateCensusAnalyser();

        Assertions.assertThrows(
                CensusAnalyserException.class,
                ()->analyser.loadStateCensusData("wrong.csv")

        );
    }
    //UC 1.3 - Wrong FileType
    @Test
    public void givenWrongFile_ShouldThrowException(){
       StateCensusAnalyser analyser =new StateCensusAnalyser();

       Assertions.assertThrows(
               CensusAnalyserException.class,
               ()-> analyser.loadStateCensusData("IndianStateCensusData.txt")
       );
    }
    //UC 1.4 - Wrong Delimiter
    @Test
    public void givenWrongDelimiter_ShouldThrowException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadStateCensusData(
                        "src/main/resources/wrong_delimiter.csv")
        );
    }
    //UC 1.5 - Wrong Header
    @Test
    public void givenWrongHeader_ShouldThrowException() {

        StateCensusAnalyser analyser = new StateCensusAnalyser();

        Assertions.assertThrows(
                CensusAnalyserException.class,
                () -> analyser.loadStateCensusData(
                        "src/main/resources/wrong_header.csv")
        );
    }





}
