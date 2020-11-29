
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.tpd.springbootcucumber.common.BagHttpClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BagCucumberStepDefinitions {

    @Autowired
    private BagHttpClient bagHttpClient;

    @Given("^the bag is not empty$")
    public void the_bag_is_not_empty() {
        bagHttpClient.put("something");
        bagHttpClient.put("something else");
        assertThat(bagHttpClient.getContents().isEmpty()).isFalse();
    }

    @Given("^the bag is empty$")
    public void the_bag_is_empty() {
        bagHttpClient.clean();
        assertThat(bagHttpClient.getContents().isEmpty()).isTrue();
    }

    @When("^I put (\\d+) (\\w+) in the bag$")
    public void i_put_something_in_the_bag(final int quantity, final String something) {
        IntStream.range(0, quantity)
                .map(ignore -> bagHttpClient.put(something))
                .forEach(statusCode -> assertThat(statusCode).isEqualTo(HttpStatus.CREATED.value()));
    }

    @When("^I empty the bag$")
    public void empty_the_bag() {
        bagHttpClient.clean();
    }

    @Then("^the bag should contain only (\\d+) (\\w+)$")
    public void the_bag_should_contain_only_something(final int quantity, final String something) {
        assertNumberOfTimes(quantity, something, true);
    }

    @Then("^the bag should contain (\\d+) (\\w+)$")
    public void the_bag_should_contain_something(final int quantity, final String something) {
        assertNumberOfTimes(quantity, something, false);
    }

    @When("I put these items in the bag")
    public void i_put_these_items_in_the_bag(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> columns : rows) {
            int amount = Integer.parseInt(columns.get("Amount"));
            for (int index = 1; index <= amount; index++) {
                bagHttpClient.put(columns.get("Name"));
            }
        }
    }

    private void assertNumberOfTimes(final int quantity, final String something, final boolean onlyThat) {
        final List<String> things = bagHttpClient.getContents().getThings();
        final int timesInList = Collections.frequency(things, something);
        assertThat(timesInList).isEqualTo(quantity);
        if (onlyThat) {
            assertThat(timesInList).isEqualTo(things.size());
        }
    }
}
