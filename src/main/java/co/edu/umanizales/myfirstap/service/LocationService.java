package co.edu.umanizales.myfirstap.service;

import co.edu.umanizales.myfirstap.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class LocationService {

    private List<Location> locations;

    @Value( "${locations_filename}" )
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException, URISyntaxException {
        locations = new ArrayList<>();

        Path pathFile = Paths.get(ClassLoader.getSystemResource(locationsFilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Leer todas las filas del CSV
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                locations.add(new Location(line[2],line[3]));
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public ArrayList<Location> getLocationByDesc(String description) {
        String actual_description;
        ArrayList<Location> matching_locations = new ArrayList<>();
        for (Location location : locations) {
            actual_description = location.getDescription().toLowerCase();
            if (actual_description.contains(description.toLowerCase())) {
                // Add location if matches in the response
                matching_locations.add(location);
            }
        }
        return matching_locations;
    }

    public ArrayList<Location> getLocationByKeyLetters(String letters) {
        ArrayList<Location> matching_locations = new ArrayList<>();
        String first_letter = letters.substring(0, 1).toLowerCase();
        String last_letter = letters.substring(1).toLowerCase();

        for (Location location : locations) {
            String actual_description = location.getDescription().toLowerCase();
            String description_first_letter = actual_description.substring(0, 1);
            String description_last_letter = actual_description.substring(actual_description.length() - 1);
            if (first_letter.equals(description_first_letter) && last_letter.equals(description_last_letter)) {
                matching_locations.add(location);
            }
        }

        return matching_locations;
    }

    public ArrayList<Location> getLocationByInitials(String letters) {
        ArrayList<Location> matching_locations = new ArrayList<>();
        String search = letters.toLowerCase();
        for (Location location : locations) {
            String actualDescription = location.getDescription();
            String firstDescriptionLetters = actualDescription.substring(0, letters.length());
            if (firstDescriptionLetters.toLowerCase().equals(letters)) {
                matching_locations.add(location);
            }
        }
        return matching_locations;
    }

    public  ArrayList<Location> getFramenCode(String Framencode ) {
        String actual_Code;
        ArrayList<Location> matching_codes  = new ArrayList<>();
        for (Location location : locations) {
            actual_Code = location.getCode();
            if (actual_Code.contains(Framencode)) {
                matching_codes.add(location);
            }
        }
        return matching_codes;
    }
}






