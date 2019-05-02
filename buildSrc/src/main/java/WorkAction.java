import javax.inject.Inject;

public class WorkAction implements Runnable {
    private final String name;

    @Inject
    public WorkAction(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("Starting work item " + name);
            Thread.sleep(1000);
            System.out.println("Finished work item " + name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
