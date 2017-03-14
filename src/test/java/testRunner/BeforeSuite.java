package testRunner;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Here is the annotation for BeforeSuite. As JUnit doesn't have 
 * this feature this method is user defined. Method using this 
 * annotation will be triggered even before the cucumber test 
 * start running
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD })
public @interface BeforeSuite {

}