import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import ru.homework.aplana.steps.BaseSteps;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/",
        glue = "ru.homework.aplana.steps"
)
public class CucumberRunner {
}
