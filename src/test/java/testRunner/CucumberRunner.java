package testRunner;


import cucumber.api.junit.Cucumber;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;


import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * ExtendedCucumberRunner class extends the junit runner class
 * and helps in providing us to run the user defined annotations
 */

@SuppressWarnings("rawtypes")
public class CucumberRunner extends Runner {

	private Class clazz;
    private Cucumber cucumber;

    public CucumberRunner(Class clazzValue) throws Exception {
        clazz = clazzValue;
        cucumber = new Cucumber(clazzValue);
    }

    @Override
    public Description getDescription() {
        return cucumber.getDescription();
    }

    private void runPredefinedMethods(Class annotation) throws Exception {
        if (!annotation.isAnnotation()) {
            return;
        }
        Method[] methodList = this.clazz.getMethods();
        for (Method method : methodList) {
            Annotation[] annotations = method.getAnnotations();
            for (Annotation item : annotations) {
                if (item.annotationType().equals(annotation)) {
                    method.invoke(null);
                    break;
                }
            }
        }
    }
    
    /**
     * Here run method overrides the run method in the Runner class.
     * Hence ends up providing us the flexibility to run user defined 
     * annotation
     */

    @Override
    public void run(RunNotifier notifier) {
        try {
            runPredefinedMethods(BeforeSuite.class);
        } catch (Exception e) {
        	//Log.getLogger().error(e.getMessage());
        }
        cucumber.run(notifier);
        try {
            runPredefinedMethods(AfterSuite.class);
        } catch (Exception e) {
        	//Log.getLogger().error(e.getMessage());
        }
    }
}