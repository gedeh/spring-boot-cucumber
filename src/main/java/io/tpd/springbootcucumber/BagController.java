package io.tpd.springbootcucumber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/things")
public final class BagController {

    private final Logger logger = LoggerFactory.getLogger(BagController.class);
    private final Bag bag = new Bag();

    @GetMapping
    public Bag getBag() {
        return bag;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addThing(@RequestBody final String something) {
        bag.add(something);
        logger.info("Added item \"{}\" to the bag", something);
    }

    @DeleteMapping
    public void removeEverything() {
        bag.removeEverything();
        logger.info("Bag is emptied");
    }
}
