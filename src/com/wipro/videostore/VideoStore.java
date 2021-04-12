package com.wipro.videostore;

import java.util.ArrayList;
import java.util.List;

import com.wipro.video.Video;

public class VideoStore {
	private List<Video> videos;

	public VideoStore() {
		videos = new ArrayList<>();
	}

	public void addVideo(String name) {
		Video v = new Video(name);
		videos.add(v);
		System.out.println(name + " Added Successfully");
	}

	public void doCheckout(String name) {
		int i = findVideoIndex(name);
		if (i != -1) {
			if ((videos.get(i).getVideoName()).equals(name)) {
				if (videos.get(i).isCheckout()) {
					System.out.println("Video has already checked out..");
				} else {
					videos.get(i).doCheckout();
					System.out.println("Video " + name + " has checked out successfully..");
				}
			}
		} else
			System.out.println("No video with name :" + name + " available in our database!");

	}

	public void doReturn(String name) {
		int i = findVideoIndex(name);
		if (i != -1) {
			if ((videos.get(i).getVideoName()).equals(name)) {
				if (!videos.get(i).isCheckout()) {
					System.out.println("Video has already returned..");
				} else {
					videos.get(i).doCheckout();
					System.out.println("Video " + name + " has returned successfully..");
				}
			}
		} else
			System.out.println("No video with name :" + name + " available in our database!");
	}

	public void ReceiveRating(String name, int rating) {
		int index = findVideoIndex(name);
		if (index != -1) {
			videos.get(index).receiveRating(rating);
			System.out.println("Rating " + rating + " has been mapped to the video " + name);
		} else
			System.out.println("No video with name :" + name + " available in our database!");
	}

	private int findVideoIndex(String name) {
		for (int i = 0; i < videos.size(); i++) {
			if (videos.get(i).getVideoName().equals(name))
				return i;
		}
		return -1;
	}

	public void listInventory() {
		System.out.println("-------------------------------------------------------------------------");
		System.out.printf("%30s %20s %10s", "Video Name", "Checkout Status", "Rating");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------");
		for (Video v : videos) {
			System.out.printf("%30s %20s %10s", v.getVideoName(), v.isCheckout(), v.getRating());
			System.out.println();
		}
	}
}
