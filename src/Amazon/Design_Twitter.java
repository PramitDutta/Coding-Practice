package Amazon;

import java.util.HashSet;
import java.util.Set;

public class Design_Twitter {
	private static int timeStamp = 0;

	private class Tweet {
		public int tweetId;
		public int time;
		public Tweet next;

		public Tweet(int tweetId) {
			this.tweetId = tweetId;
			time = timeStamp++;
			next = null;
		}
	}

	private class User {
		public int userId;
		public Set<Integer> followed;
		public Tweet tweetHead;

		public User(int userId) {
			this.userId = userId;
			followed = new HashSet<>();
			follow(userId);
			tweetHead = null;
		}

		public void follow(int id) {
			followed.add(id);
		}

		public void unfollow(int id) {
			followed.remove(id);
		}

		public void post(int id) {
			Tweet t = new Tweet(id);
			t.next = tweetHead;
			tweetHead = t;
		}
	}
}
