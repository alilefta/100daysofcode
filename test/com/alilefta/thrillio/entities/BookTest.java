package com.alilefta.thrillio.entities;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.alilefta.thrillio.constants.BookGenre;
import com.alilefta.thrillio.managers.BookmarkManager;

public class BookTest {

	@Test
	public void testIsKidFriendlyEligible() {
		// Test 1: "Philosophical" genre --> false

		Book book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.PHILOSOPHY, 4.3);
		boolean isKidFriendlyEligible = book.isKidFriendlyEligible();
		assertFalse("For philosophical genre books - isKidFriendlyEligible() must return false", isKidFriendlyEligible);

		// Test 2: "Self-Help" genre --> false

		book = BookmarkManager.getInstance().createBook(4000, "Walden", "", 1854, "Wilder Publications",
				new String[] { "Henry David Thoreau" }, BookGenre.SELF_HELP, 4.3);

		isKidFriendlyEligible = book.isKidFriendlyEligible();

		assertFalse("For self help genre - isKidFriendlyEligible() must return false", isKidFriendlyEligible);
	}

}
