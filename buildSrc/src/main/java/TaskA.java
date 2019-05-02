import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.*;
import org.gradle.workers.*;

import javax.inject.Inject;
import java.io.File;

class TaskA extends DefaultTask {
    private final WorkerExecutor workerExecutor;

    @Inject
    public TaskA(WorkerExecutor workerExecutor) {
        this.workerExecutor = workerExecutor;
    }

    @TaskAction
    public void taskActionA() throws Exception {
        workerExecutor.submit(WorkAction.class, new Action<WorkerConfiguration>() {
            @Override
            public void execute(WorkerConfiguration config) {
                config.params("a1");
            }
        });
    }
}
