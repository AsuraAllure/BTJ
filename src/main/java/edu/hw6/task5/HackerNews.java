package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private final static HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private final static String URI_HACKER_SITE_ID = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private final static String URI_HACKER_SITE_ITEM = "https://hacker-news.firebaseio.com/v0/item/";
    private final static long[] EMPTY_LONG_ARRAY = new long[0];

    private HackerNews() {

    }

    public static long[] hackerNewsTopStories() {
        try {
            HttpRequest request = HttpRequest
                .newBuilder(new URI(URI_HACKER_SITE_ID))
                .build();

            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            return Arrays.stream(response
                    .body()
                    .replace('[', ' ')
                    .replace(']', ' ')
                    .strip()
                    .split(","))
                .map(Long::parseLong)
                .mapToLong(Long::longValue)
                .toArray();
        } catch (URISyntaxException ignored) {
        } catch (IOException | InterruptedException e) {
            return EMPTY_LONG_ARRAY;
        }
        return EMPTY_LONG_ARRAY;
    }

    public static String news(long id) throws IOException {
        try {
            HttpRequest request = HttpRequest
                .newBuilder(new URI(URI_HACKER_SITE_ITEM + id + ".json"))
                .build();

            HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            Pattern pattern = Pattern.compile("\"title\":\"(.+?)\"");
            Matcher m = pattern.matcher(response.body());
            if (m.find()) {
                return m.group(1);
            }
        } catch (URISyntaxException | InterruptedException ignored) {
        } catch (IOException e) {
            throw new IOException(e);
        }
        return "";
    }
}
