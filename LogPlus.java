import android.support.annotation.Nullable;
import android.util.Log;

public class LogPlus {

    private static final int CURRENT_LOG_LEVEL = Log.VERBOSE;


    public static void v(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.VERBOSE, tag, msg, tr);
    }

    public static void d(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.DEBUG, tag, msg, tr);
    }

    public static void i(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.INFO, tag, msg, tr);
    }

    public static void w(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.WARN, tag, msg, tr);
    }

    public static void e(@Nullable String tag, String msg, @Nullable Throwable tr) {
        log(Log.ERROR, tag, msg, tr);
    }

    private static void log(int logLevel, String tag, String msg, Throwable tr) {
        if (logLevel < CURRENT_LOG_LEVEL) {
            return;
        }
        StackTraceElement e = Thread.currentThread().getStackTrace()[4];
        String fileName = e.getFileName();
        int lineNum = e.getLineNumber();
        String methodName = e.getMethodName();
        String className = e.getClassName();
        int index = className.lastIndexOf('.') + 1;
        className = className.substring(index);
        tag = isEmpty(tag) ? className : tag;
        msg = String.format("[%s](%s:%d) %s", methodName, fileName, lineNum, msg);
        if (tr == null) {
            switch (logLevel) {
                case Log.VERBOSE:
                    Log.v(tag, msg);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg);
                    break;
                case Log.INFO:
                    Log.i(tag, msg);
                    break;
                case Log.WARN:
                    Log.w(tag, msg);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg);
                    break;
            }
        } else {
            switch (logLevel) {
                case Log.VERBOSE:
                    Log.v(tag, msg, tr);
                    break;
                case Log.DEBUG:
                    Log.d(tag, msg, tr);
                    break;
                case Log.INFO:
                    Log.i(tag, msg, tr);
                    break;
                case Log.WARN:
                    Log.w(tag, msg, tr);
                    break;
                case Log.ERROR:
                    Log.e(tag, msg, tr);
                    break;
            }
        }

    }

    private static boolean isEmpty(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

}
