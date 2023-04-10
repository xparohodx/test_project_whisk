package portal.utils.browsers;

public class BrowserHolder {
    private static ThreadLocal<Browser> browserHolder = new ThreadLocal();
    private static ThreadLocal<Boolean> browserCreatedHolder = new ThreadLocal();

    public static Browser getBrowser() {
        Browser b = browserHolder.get();
        if (b == null) {
            b = new Browser();
            browserHolder.set(b);
            browserCreatedHolder.set(true);
        }
        return b;
    }

    public static void setBrowser(Browser browser) {
        browserHolder.set(browser);
    }

    public static boolean isBrowserCreated() {
        Boolean created = browserCreatedHolder.get();
        return created == null ? false : browserCreatedHolder.get();
    }

    public static void setBrowserCreated(boolean browserCreated) {
        browserCreatedHolder.set(browserCreated);
    }

    public static void quit() {
        if (isBrowserCreated()) {
            getBrowser().quit();
        }
        setBrowser(null);
        setBrowserCreated(false);
    }
}
