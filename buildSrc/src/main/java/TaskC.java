import org.gradle.api.Action;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.*;
import org.gradle.workers.*;

import javax.inject.Inject;
import java.io.File;

class TaskC extends DefaultTask {
    private final WorkerExecutor workerExecutor;

    @Inject
    public TaskC(WorkerExecutor workerExecutor) {
        this.workerExecutor = workerExecutor;
    }

    public void submitWork(String name) throws Exception {
      workerExecutor.submit(WorkAction.class, new Action<WorkerConfiguration>() {
          @Override
          public void execute(WorkerConfiguration config) {
              config.params(name);
          }
      });
    }
}
