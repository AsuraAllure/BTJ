package edu.LoggerAnalyzer.Analyzers;

import edu.LoggerAnalyzer.LogRecords.LogRecord;
import edu.LoggerAnalyzer.LogRecords.RequestStartLine;
import edu.LoggerAnalyzer.Statistic;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class StandartAnalyzer implements Analyzer {
    private final Map<RequestStartLine, Integer> counterRequest = new HashMap<>();
    private final Map<Integer, Integer> counterStatus = new HashMap<>();
    private long sizeAnswer = 0;
    private int countRequest = 0;

    public StandartAnalyzer() {
    }

    @Override
    public Statistic analizing(Stream<LogRecord> stream) {
        stream.forEach((x) -> {
            countRequest++;
            counterRequest.put(x.request(), counterRequest.getOrDefault(x.request(), 0) + 1);
            counterStatus.put(x.status(), counterStatus.getOrDefault(x.status(), 0) + 1);
            sizeAnswer += x.sizeResponce();
        });

        RequestStartLine mostCommonRequest = null;
        int maxCount1 = -1;

        for(var key : counterRequest.keySet()){
            if (counterRequest.get(key) > maxCount1){
                mostCommonRequest = key;
                maxCount1 = counterRequest.get(key);
            }
        }
        int mostCommonStatus = -1;
        int maxCount2 = -1;

        for(var key : counterStatus.keySet()){
            if (counterStatus.get(key) > maxCount2){
                mostCommonStatus = key;
                maxCount2 = counterStatus.get(key);
            }
        }
        return new Statistic(countRequest,mostCommonRequest , mostCommonStatus, (double) sizeAnswer / countRequest);
    }
}
