package com.abhishek.restaurant.manual;

import com.abhishek.restaurant.domain.RestaurantCreateUpdateRequest;
import com.abhishek.restaurant.domain.entities.Address;
import com.abhishek.restaurant.domain.entities.OperatingHours;
import com.abhishek.restaurant.domain.entities.Photo;
import com.abhishek.restaurant.domain.entities.TimeRange;
import com.abhishek.restaurant.services.PhotoService;
import com.abhishek.restaurant.services.RestaurantService;
import com.abhishek.restaurant.services.impl.RandomGeoLocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class RestaurantDataLoaderTest {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RandomGeoLocationService geoLocationService;

    @Autowired
    private PhotoService photoService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Test
    @Rollback(false) // Allow changes to persist
    public void createSampleRestaurants() throws Exception {
        List<RestaurantCreateUpdateRequest> restaurants = createRestaurantData();
        restaurants.forEach(restaurant -> {
            String fileName = restaurant.getPhotoIds().getFirst();
            Resource resource = resourceLoader.getResource("classpath:testdata/" + fileName);
            MultipartFile multipartFile = null;
            try {
                multipartFile = new MockMultipartFile(
                        "file", // parameter name
                        fileName, // original filename
                        MediaType.IMAGE_PNG_VALUE,
                        resource.getInputStream()
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


            // Call the service method
            Photo uploadedPhoto = photoService.uploadPhoto(multipartFile);

            restaurant.setPhotoIds(List.of(uploadedPhoto.getUrl()));

            restaurantService.createRestaurant(restaurant);

            System.out.println("Created restaurant: " + restaurant.getName());
        });
    }

    private List<RestaurantCreateUpdateRequest> createRestaurantData() {
        return Arrays.asList(
                createRestaurant(
                        "The Golden Dragon",
                        "Chinese",
                        "+1 706 345 7889",
                        createAddress("12", "Gerrard Street", null, "Athens", "Georgia", "30609", "United States of America"),
                        createStandardOperatingHours("11:30", "23:00", "11:30", "23:30"),
                        "golden-dragon.png"
                ),
                createRestaurant(
                        "La Petite Maison",
                        "French",
                        "+1 706 345 6578",
                        createAddress("54", "Brook Street", null, "Athens", "Georgia", "30608", "United States of America"),
                        createStandardOperatingHours("12:00", "22:30", "12:00", "23:00"),
                        "la-petit-maison.png"
                ),
                createRestaurant(
                        "Raj Pavilion",
                        "Indian",
                        "+1 706 345 4179",
                        createAddress("27", "Brick Lane", null, "Athens", "Georgia", "30609", "United States of America"),
                        createStandardOperatingHours("12:00", "23:00", "12:00", "23:30"),
                        "raj-pavilion.png"
                ),
                createRestaurant(
                        "Sushi Master",
                        "Japanese",
                        "+1 706 348 7514",
                        createAddress("8", "Poland Street", null, "Athens", "Georgia", "30604", "United States of America"),
                        createStandardOperatingHours("11:30", "22:00", "11:30", "22:30"),
                        "sushi-master.png"
                ),
                createRestaurant(
                        "The Rustic Olive",
                        "Italian",
                        "+1 706 842 8469",
                        createAddress("92", "Dean Street", null, "Athens", "Georgia", "30609", "United States of America"),
                        createStandardOperatingHours("11:00", "23:00", "11:00", "23:30"),
                        "rustic-olive.png"
                ),
                createRestaurant(
                        "El Toro",
                        "Spanish",
                        "+1 706 345 8745",
                        createAddress("15", "Charlotte Street", null, "Athens", "Georgia", "30605", "United States of America"),
                        createStandardOperatingHours("12:00", "23:00", "12:00", "23:30"),
                        "el-toro.png"
                ),
                createRestaurant(
                        "The Greek House",
                        "Greek",
                        "+1 706 247 9841",
                        createAddress("32", "Store Street", null, "Athens", "Georgia", "30601", "United States of America"),
                        createStandardOperatingHours("12:00", "22:30", "12:00", "23:00"),
                        "greek-house.png"
                ),
                createRestaurant(
                        "Seoul Kitchen",
                        "Korean",
                        "+1 706 304 9713",
                        createAddress("71", "St John Street", null, "Athens", "Georgia", "30603", "United States of America"),
                        createStandardOperatingHours("11:30", "22:00", "11:30", "22:30"),
                        "seoul-kitchen.png"
                ),
                createRestaurant(
                        "Thai Orchid",
                        "Thai",
                        "+1 706 356 8429",
                        createAddress("45", "Warren Street", null, "Athens", "Georgia", "30609", "United States of America"),
                        createStandardOperatingHours("11:00", "22:30", "11:00", "23:00"),
                        "thai-orchid.png"
                ),
                createRestaurant(
                        "The Burger Joint",
                        "American",
                        "+1 706 345 9994",
                        createAddress("88", "Commercial Street", null, "Athens", "Georgia", "30604", "United States of America"),
                        createStandardOperatingHours("11:00", "23:00", "11:00", "23:30"),
                        "burger-joint.png"
                )
        );
    }

    private RestaurantCreateUpdateRequest createRestaurant(
            String name,
            String cuisineType,
            String contactInformation,
            Address address,
            OperatingHours operatingHours,
            String photoId
    ) {
        return RestaurantCreateUpdateRequest.builder()
                .name(name)
                .cuisineType(cuisineType)
                .contactInformation(contactInformation)
                .address(address)
                .operatingHours(operatingHours)
                .photoIds(List.of(photoId))
                .build();
    }

    private Address createAddress(
            String streetNumber,
            String streetName,
            String unit,
            String city,
            String state,
            String postalCode,
            String country
    ) {
        Address address = new Address();
        address.setStreetNumber(streetNumber);
        address.setStreetName(streetName);
        address.setUnit(unit);
        address.setCity(city);
        address.setState(state);
        address.setPostalCode(postalCode);
        address.setCountry(country);
        return address;
    }

    private OperatingHours createStandardOperatingHours(
            String weekdayOpen,
            String weekdayClose,
            String weekendOpen,
            String weekendClose
    ) {
        TimeRange weekday = new TimeRange();
        weekday.setOpenTime(weekdayOpen);
        weekday.setCloseTime(weekdayClose);

        TimeRange weekend = new TimeRange();
        weekend.setOpenTime(weekendOpen);
        weekend.setCloseTime(weekendClose);

        OperatingHours hours = new OperatingHours();
        hours.setMonday(weekday);
        hours.setTuesday(weekday);
        hours.setWednesday(weekday);
        hours.setThursday(weekday);
        hours.setFriday(weekend);
        hours.setSaturday(weekend);
        hours.setSunday(weekend);

        return hours;
    }
}
