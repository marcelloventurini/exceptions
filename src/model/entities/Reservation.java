package model.entities;

import model.exeptions.DomainException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		validation(checkIn, checkOut);

		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		//diferenca entre as datas em milissegundos
		long diff = checkOut.getTime() - checkIn.getTime();

		//convertendo a diferenca de milissegundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) throws DomainException {
		validation(checkIn, checkOut);

		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public void validation(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();

		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for updates must be future dates.");
		}
		else if (checkIn.after(checkOut)) {
			throw new DomainException("Check Out date must be after Check In date.");
		}
	}

	@Override
	public String toString() {
		return "Room "
				+ roomNumber
				+ ", Check In: "
				+ SIMPLE_DATE_FORMAT.format(checkIn)
				+ ", Check Out: "
				+ SIMPLE_DATE_FORMAT.format(checkOut)
				+ ", "
				+ duration()
				+ " nights";
	}
}
