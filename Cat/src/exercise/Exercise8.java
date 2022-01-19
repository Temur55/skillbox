package exercise;

import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

import java.util.List;

public class Exercise8
{
    /**
     * Получение кол-ва самолетов в аэропорту
     */
    public static void main(String[] args)
    {
        List<Aircraft> aircraftList = Airport.getInstance().getAllAircrafts();
        System.out.println(aircraftList.size());
    }
}
