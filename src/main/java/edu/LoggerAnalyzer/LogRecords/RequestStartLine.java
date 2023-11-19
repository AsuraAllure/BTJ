package edu.LoggerAnalyzer.LogRecords;

public record RequestStartLine(String method, String url, String version) {
}
