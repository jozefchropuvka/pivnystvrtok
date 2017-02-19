package pivnystvrtok.pivnystvrtok;

import org.joda.time.DateTime;

import pivnystvrtok.restaurant.Restaurant;

public interface PivnyStvrtokSimple {
	DateTime getDate();
	Restaurant getRestaurant();
	State getState();
}
