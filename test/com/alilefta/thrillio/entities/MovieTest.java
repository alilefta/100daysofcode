package com.alilefta.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.alilefta.thrillio.constants.BookGenre;
import com.alilefta.thrillio.constants.MovieGenre;
import com.alilefta.thrillio.managers.BookmarkManager;

public class MovieTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test 1: "Horror" genre --> false

		Movie movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.HORROR,
				8.5);
		boolean isKidFriendlyEligible = movie.isKidFriendlyEligible();
		assertFalse("For Horror genre movie - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// Test 2: "Thriller" genre --> false

		movie = BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", "", 1941,
				new String[] { "Orson Welles", "Joseph Cotten" }, new String[] { "Orson Welles" }, MovieGenre.THRILLERS,
				8.5);

		isKidFriendlyEligible = movie.isKidFriendlyEligible();

		assertFalse("For thriller genre movie - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
	}

}
