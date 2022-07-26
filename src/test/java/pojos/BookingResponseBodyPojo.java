package pojos;


public class BookingResponseBodyPojo {
    // 1) Tüm key'ler icin private variable'lar olusturuyoruz
    private Integer bookingid;
    private BookingPojo booking;

    // 2) Tüm parametrelerle ve parametresiz constructor' larımızı olusturuyoruz.

    public BookingResponseBodyPojo(Integer bookingid, BookingPojo booking) {
        this.bookingid = bookingid;
        this.booking = booking;
    }

    public BookingResponseBodyPojo() {
    }
    // 3) Getters ve Setters'larımızı olusturuyoruz

    public Integer getBookingid() {
        return bookingid;
    }

    public void setBookingid(Integer bookingid) {
        this.bookingid = bookingid;
    }

    public BookingPojo getBooking() {
        return booking;
    }

    public void setBooking(BookingPojo booking) {
        this.booking = booking;
    }

    // 4) toString() methodumuzu olusturuyoruz.


    @Override
    public String toString() {
        return "BookingResponseBodyPojo{" +
                "bookingId=" + bookingid +
                ", booking='" + booking + '\'' +
                '}';
    }
}
