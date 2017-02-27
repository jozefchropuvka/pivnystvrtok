package pivnystvrtok.pivnystvrtok;

import org.joda.time.DateTime;
import org.springframework.data.rest.core.config.Projection;

import pivnystvrtok.restaurant.Restaurant;
import pivnystvrtok.statemachine.States;

@Projection(name = "simple", types = { PivnyStvrtok.class })
interface PivnyStvrtokSimple {
	DateTime getDate();
	Restaurant getRestaurant();
	States getState();
}
