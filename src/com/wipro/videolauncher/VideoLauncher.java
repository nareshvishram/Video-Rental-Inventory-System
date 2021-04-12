package com.wipro.videolauncher;

import java.util.Scanner;

import com.wipro.videostore.VideoStore;

public class VideoLauncher {
	private static VideoStore vStore;

	public static void main(String[] args) {
		int n = choice();
		Scanner sc = new Scanner(System.in);
		vStore = new VideoStore();
		while (true) {
			switch (n) {
			case 1:
				System.out.println("Enter the name of the video you want to add:");
				String name = getInputString();
				vStore.addVideo(name);

				n = choice();

				break;
			case 2:
				System.out.println("Enter the name of the video you want to check out:");
				String nCheckout = getInputString();
				vStore.doCheckout(nCheckout);
				n = choice();
				break;
			case 3:
				System.out.println("Enter the name of the video you want to return:");
				String nReturn = getInputString();
				vStore.doReturn(nReturn);
				n = choice();
				break;
			case 4:
				System.out.println("Enter the name of the video you want to rate:");
				String nRate = getInputString();
				System.out.println("Enter the rating:");
				int rating = getInputInt();
				vStore.ReceiveRating(nRate, rating);
				n = choice();
				break;
			case 5:
				vStore.listInventory();
				n = choice();
				break;
			case 6:
				System.out.println("Exiting!!.......Thanks for using the application.");
				return;

			default:
				break;
			}
		}

	}

	public static int choice() {
		System.out.println("Main Menu");
		System.out.println("===================");
		System.out.println("1.Add Videos:\n" + "2.Checkout Video:\n" + "3.Return Video:\n" + "4.Receive Rating:\n"
				+ "5.List Inventory:\n" + "6.Exit:\n" + "Enter your choice(1....6)");
		return getInputInt();

	}

	public static String getInputString() {
		Scanner sc = new Scanner(System.in);
		try {
			String str = sc.next().trim();
			return str;
		} catch (Exception e) {

			System.out.println("Input should be of String type only.");
			getInputString();
		}
		return "";
	}

	public static int getInputInt() {
		Scanner sc = new Scanner(System.in);
		try {
			int n = sc.nextInt();
			return n;
		} catch (Exception e) {

			System.out.println("Input should be of integer type.");
			getInputInt();
		}
		return 0;
	}
}
