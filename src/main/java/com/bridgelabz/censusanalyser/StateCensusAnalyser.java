package com.bridgelabz.censusanalyser;

import com.bridgelabz.censusanalyser.exception.CensusAnalyserException;
import com.bridgelabz.censusanalyser.model.CSVStateCensus;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class StateCensusAnalyser {

    public int loadStateCensusData(String csvFilePath)
            throws CensusAnalyserException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {

            Iterator<CSVStateCensus> iterator =
                    new CsvToBeanBuilder<CSVStateCensus>(reader)
                            .withType(CSVStateCensus.class)
                            .withIgnoreLeadingWhiteSpace(true)
                            .build()
                            .iterator();

            int count = 0;
            while (iterator.hasNext()) {
                iterator.next();
                count++;
            }
            return count;

        } catch (Exception e) {
            throw new CensusAnalyserException(
                    e.getMessage(),
                    CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }
    }
}
