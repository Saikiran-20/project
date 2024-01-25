import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

class Hotel {
    private int HotelId;
    private String HotelName;
    private String HotelLocation;
    private int NoOfRooms;
    private float CostPerRoom;

    static HashMap<Integer, Hotel> hotelDetail = new HashMap<>();

    static int countHotel = 1;

    public void setHotelId(int hotelId) {
        HotelId = hotelId;

    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public void setHotelLocation(String hotelLocation) {
        HotelLocation = hotelLocation;
    }

    public void setNoOfRooms(int noOfRooms) {
        NoOfRooms = noOfRooms;
    }

    public void setCostPerRoom(float costPerRoom) {
        CostPerRoom = costPerRoom;
    }

    public Integer getHotelId() {
        return HotelId;
    }

    public String getHotelName() {
        return HotelName;
    }

    public String getHotelLocation() {
        return HotelLocation;
    }

    public Integer getNoOfRooms() {
        return NoOfRooms;
    }

    public float getCostPerRoom() {
        return CostPerRoom;
    }

}

public class Main {

    private static void toCreateAHotel() {
        System.out.println("Welcome - creating a hotel:\n");
        Hotel obHotel = new Hotel();
        obHotel.setHotelId(Hotel.countHotel);
        System.out.println("Enter a ID" + obHotel.getHotelId());

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a Name: ");
        obHotel.setHotelName(input.next());

        System.out.println("Enter a Location: ");
        obHotel.setHotelLocation(input.next());

        System.out.println("Enter a roomNum: ");
        obHotel.setNoOfRooms(input.nextInt());

        System.out.println("Enter cost per room: ");
        obHotel.setCostPerRoom(input.nextFloat());

        Hotel.hotelDetail.put(obHotel.getHotelId(), obHotel);
        Hotel.countHotel++;
        System.out.println("Successfully created\n");

    }

    private static void toRemoveAHotel() {
        System.out.println("Welcome - Remove a hotel:\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a ID: ");
        int id = input.nextInt();
        if (Hotel.hotelDetail.containsKey(id)) {
            Hotel.hotelDetail.remove(id);
            System.out.println("removed successfully\n");
        } else {
            System.out.println("id does not exist\n");
        }

    }

    private static void toUpdateAHotel() {
        System.out.println("Welcome - update a hotel:\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the ID of the hotel to be Update:");
        int id = input.nextInt();
        if (Hotel.hotelDetail.containsKey(id)) {
            System.out.println("1.HotelName");
            System.out.println("2.HotelLocation");
            System.out.println("3.RoomNumber:");
            System.out.println("4.CostPerRoom");
            System.out.print("Enter a choice");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the Name:");
                    String name = input.next();
                    Hotel.hotelDetail.get(id).setHotelName(name);

                    break;
                case 2:
                    System.out.println("Enter the Location:");
                    String location = input.next();
                    Hotel.hotelDetail.get(id).setHotelLocation(location);

                    break;
                case 3:
                    System.out.println("Enter the count of available rooms:");
                    Integer NoOfRooms = input.nextInt();
                    Hotel.hotelDetail.get(id).setNoOfRooms(NoOfRooms);

                    break;
                case 4:
                    System.out.println("Enter the CostPerRoom:");
                    Float CostPerRoom = input.nextFloat();
                    Hotel.hotelDetail.get(id).setCostPerRoom(CostPerRoom);
                    break;
                default:
                    System.err.println("invalid choice:\n");
                    return;
            }
            System.err.println("hotel data updated successfully!!1\n");
        } else {
            System.out.println("hotel does not exit with this id!!\n");

        }
    }

    private static void toDisplayAHotel() {
        System.out.println("Welcome - a Display hotel:\n");
        System.out
                .println("------------------------------------------------------------------------------------------");
        System.out.print("ID \t\t ");
        System.out.print("Name \t\t ");
        System.out.print("Location \t\t ");
        System.out.print("Rooms \t\t ");
        System.out.println("cost \t\t ");
        System.out
                .println("------------------------------------------------------------------------------------------");
        for (Map.Entry<Integer, Hotel> dataEntry : Hotel.hotelDetail.entrySet()) {
            System.out.print(dataEntry.getValue().getHotelId() + "\t\t");

            System.out.print(dataEntry.getValue().getHotelName() + "\t\t");

            System.out.print(dataEntry.getValue().getHotelLocation() + "\t\t\t");

            System.out.print(dataEntry.getValue().getNoOfRooms() + "\t\t");

            System.out.println(dataEntry.getValue().getCostPerRoom() + "\t\t");
            System.out
                    .println("--------------------------------------------------------------------------------------");
        }
    }

    private static void toSearchAHotel() {
        System.out.println("Welcome - Search a hotel:\n");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter  the hotel to be searched:\n");
        int id = input.nextInt();
        if (Hotel.hotelDetail.containsKey(id)) {
            System.out.println("HotelName:\n" + Hotel.hotelDetail.get(id).getHotelName());
            System.out.println("HotelLocation:\n" + Hotel.hotelDetail.get(id).getHotelLocation());
            System.out.println("RoomNumber:\n" + Hotel.hotelDetail.get(id).getNoOfRooms());
            System.out.println("CostPerRoom:\n" + Hotel.hotelDetail.get(id).getCostPerRoom());
            System.out.println("Hotel details displayed successfully.\n");
        } else {
            System.out.println("id does not exist.\n");
        }
    }

    public static void main(String[] args) {

        System.out.print("Welcome to Hotel\n");

        while (true) {
            System.out.println("1.Create a HotelId");
            System.out.println("2.Remove the HotelId");
            System.out.println("3 Update a HotelDetails");
            System.out.println("4.Display a HotelDetails");
            System.out.println("5.Search a HotelDetails");
            System.out.println("6.hotel detail Exit");
            System.out.println("Enter a Choice:\n");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    toCreateAHotel();
                    break;
                case 2:
                    toRemoveAHotel();
                    break;
                case 3:
                    toUpdateAHotel();
                    break;
                case 4:
                    toDisplayAHotel();
                    break;
                case 5:
                    toSearchAHotel();
                    break;
                case 6:
                    System.out.println("Application is Exited\n");
                    return;
                default:
                    System.out.println("Invalid choice!!!");
                    break;
            }

        }

    }
}