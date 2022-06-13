package ReadFile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/*
You are building a small command-line application to calculate hotel availability for a city. Your application reads in two (2) data files, and outputs its answer to STDOUT.
Your application will read in:
· a list of hotels along with how many rooms each contains (in no particular order)
· a list of bookings that have been made (in no particular order)
Your application will then print the list of all hotels which have availability for check-in and check- out date range, if any.
Do not worry about whether a specific room is available in a hotel for the entire booking period without switching rooms: availability is defined as the hotel having at least one (1) available room for each night of the target stay, regardless of whether it's the same room from day to day.

Data Files
hotels.csv
# Name, Rooms
Westin, 10
Best Western, 20
Hilton, 10
...

bookings.csv
# Name, Checkin, Checkout
Hilton, 2015-04-02, 2015-04-03
Hilton, 2015-04-02, 2015-04-04
Westin, 2015-05-01, 2015-05-20
 */
public class ReadFile {

    public static void main(String[] args){

        List<List<String>> hotels = readCsv("hotels.csv");
        List<List<String>> bookings = readCsv("bookings.csv");

        List<HotelCsv> hotelsParsed = new ArrayList<HotelCsv>();
        List<Booking> bookingsParsed = new ArrayList<Booking>();

        for(List<String> booking : bookings){
            bookingsParsed.add(new Booking(booking.get(0), LocalDate.parse(booking.get(1)),LocalDate.parse(booking.get(2))));
        }
        for(List<String> hotel : hotels){
            hotelsParsed.add(new HotelCsv(hotel.get(0), Integer.parseInt(hotel.get(1))));
        }

        Map<String, Map<LocalDate, Integer>> hotelMap = new HashMap<String, Map<LocalDate, Integer>>();

        for(Booking booking : bookingsParsed){
            LocalDate tempDate = booking.checkin;
            hotelMap.putIfAbsent(booking.name, new HashMap<>());
            while(tempDate.compareTo(booking.checkout)<=0) {
                hotelMap.get(booking).putIfAbsent(tempDate, 0);
                hotelMap.get(booking).put(tempDate, hotelMap.get(booking).get(tempDate)+1);
                tempDate.plusDays(1);
            }
        }

        List<String> response = new ArrayList<>();

        for(HotelCsv hotel : hotelsParsed){
            Map<LocalDate, Integer> dateCount =  hotelMap.get(hotel);

            if(dateCount.entrySet().stream().filter((entry) -> entry.getValue()<hotel.rooms).collect(Collectors.toSet()).size()!=0){
                response.add(hotel.name);
            };
        }
        System.out.println(response);

    }

    private static List<List<String>> readCsv(String name){

        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(name))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                records.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }

}

class HotelCsv{
    public String name;
    public Integer rooms;

    public HotelCsv(String name, Integer rooms){
        this.name = name;
        this.rooms = rooms;
    }
}

class Booking{

    public String name;
    public LocalDate checkin;
    public LocalDate checkout;

    public Booking(String name, LocalDate checkin, LocalDate checkout){
        this.name = name;
        this.checkin = checkin;
        this.checkout = checkout;
    }
}
