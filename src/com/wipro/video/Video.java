package com.wipro.video;

public class Video {
	public String videoName;
	public boolean checkout;
	public int rating;

	public Video(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoName() {
		return videoName;
	}

	public boolean isCheckout() {
		return checkout;
	}

	@Override
	public String toString() {
		return "Video [videoName=" + videoName + ", checkout=" + checkout + ", rating=" + rating + "]";
	}

	public int getRating() {
		return rating;
	}

	public void doCheckout() {
		checkout = true;
	}

	public void doReturn() {
		checkout = false;
	}

	public void receiveRating(int rating) {
		this.rating = rating;
	}

}
