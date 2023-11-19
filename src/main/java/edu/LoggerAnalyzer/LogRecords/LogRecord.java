package edu.LoggerAnalyzer.LogRecords;

import java.time.OffsetDateTime;

public record LogRecord(
    IPAddress ip, String remoteUser, OffsetDateTime localTime, RequestStartLine request,
    int status, int sizeResponce, String httpReferer, String httpUserAgent) {
}
