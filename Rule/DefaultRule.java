package Rule;

public class DefaultRule {
    private static volatile DefaultRule instance;


    public static DefaultRule getInstance() {
        DefaultRule result = instance;
        if (result == null) {
            synchronized (DefaultRule.class) {
                instance = result = new DefaultRule();
            }
        }
        return result;
    }
}
