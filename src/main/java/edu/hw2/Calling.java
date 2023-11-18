package edu.hw2;

public class Calling {
    private Calling() {
    }

    public static CallingInfo call() {
        StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        StackTraceElement el = trace[2];
        return new CallingInfo(el.getClassName(), el.getMethodName());
    }

    public record CallingInfo(String className, String methodName) {
    }
}
