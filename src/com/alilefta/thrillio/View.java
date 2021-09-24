package com.alilefta.thrillio;

import com.alilefta.thrillio.constants.KidFriendlyStatus;
import com.alilefta.thrillio.constants.UserType;
import com.alilefta.thrillio.controllers.BookmarkController;
import com.alilefta.thrillio.entities.Bookmark;
import com.alilefta.thrillio.entities.User;
import com.alilefta.thrillio.partner.Shareable;

public class View {
	public static void browse(User user, Bookmark[][] bookmarks) {
		System.out.println("\n User: " + user.getEmail() + " is browsing ...");

		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {

				// Bookmarking !!!!
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);

					if (isBookmarked) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, bookmark);
						System.out.println("New Item Bookmarked -- " + bookmark);
					}
				}

				if (user.getUserType().equals(UserType.CHIEF_EDITOR) || user.getUserType().equals(UserType.EDITOR)) {

					// Mark as isKidFriendly
					boolean approvedKidFriendly = false;
					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);

						if (kidFriendlyStatus.equals(KidFriendlyStatus.APPROVED)) {
							approvedKidFriendly = true;
						}

						if (!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)) {
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
						}
					}

					// Sharing !!!
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)
							&& bookmark instanceof Shareable) {
						boolean isShared = getShareDecision();
						if (isShared) {

							// we passing user to book keep of which user shared that bookmark.
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
				}
			}
		}

	}
	
	// TODO: below method simulate user input. After I/O we take input via console.
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random() < 0.5 ? true : false;
	}

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n User: "+ user.getEmail() + " is bookmarking");
	 * 
	 * for(int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++) { int typeOffset
	 * =(int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT); int bookmarkOffset =
	 * (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * 
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark); } }
	 */
}
