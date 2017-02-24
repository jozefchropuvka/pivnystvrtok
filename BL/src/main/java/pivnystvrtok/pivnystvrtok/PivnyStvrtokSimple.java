package pivnystvrtok.pivnystvrtok;

import org.joda.time.DateTime;

import pivnystvrtok.restaurant.Restaurant;
import pivnystvrtok.statemachine.States;

public interface PivnyStvrtokSimple {
	DateTime getDate();
	Restaurant getRestaurant();
	States getState();
}
