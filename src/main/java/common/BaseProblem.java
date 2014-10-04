package common;

/**
 * Created by gelin on 14-10-4.
 */
public abstract class BaseProblem {
    private static long startTime;
    private static long endTime;
    private static final String EXECUTE_TINE = "执行时间: %s ms";

    public void process() {
        start();
        execute();
        end();
        System.out.println(String.format(EXECUTE_TINE, getExecutionTime()));
    }

    abstract protected void execute();

    private void start() {
        startTime = System.currentTimeMillis();
    }

    private void end() {
        endTime = System.currentTimeMillis();
    }

    protected long getExecutionTime() {
        return endTime - startTime;
    }
}
