package application;

import model.entities.Reservation;
import model.exeptions.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = scanner.nextInt();

			System.out.print("Check In date (dd/mm/yyyy): ");
			Date checkIn = simpleDateFormat.parse(scanner.next());

			System.out.print("Check Out date (dd/mm/yyyy): ");
			Date checkOut = simpleDateFormat.parse(scanner.next());

			Reservation reservation = new Reservation(number, checkIn, checkOut);

			System.out.println("Reservation: " + reservation);

			System.out.println("Enter data to update the reservation:");
			System.out.print("Check In date (dd/mm/yyyy): ");
			checkIn = simpleDateFormat.parse(scanner.next());

			System.out.print("Check Out date (dd/mm/yyyy): ");
			checkOut = simpleDateFormat.parse(scanner.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservation: " + reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format.");
		}
		catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (InputMismatchException e) {
			System.out.println("Invalid format.");
		}

		scanner.close();
	}
}
