package edu.LoggerAnalyzer;

import edu.LoggerAnalyzer.LogRecords.RequestStartLine;

public record Statistic(int countRequest, RequestStartLine mostCallableResource, int mostCallableStatus, double mediumSize) {
}
