package com.mobileapps.rxjavatutorial.utilities;

import com.mobileapps.rxjavatutorial.models.local.randomme.Location;
import com.mobileapps.rxjavatutorial.models.local.randomme.Name;

import static com.mobileapps.rxjavatutorial.models.local.Constants.SPACE_STRING;

/*************************************************************
 *  Standard String Utils
 */
public class StringUtils {
    /*
    * Returns if the string is null or empty
    * @param stringToCheck String to be checked
    * @return if the string is truly empty
    */
    public static boolean isStringEmpty(String stringToCheck) {
        return stringToCheck == null || stringToCheck.isEmpty();
    }

    public static String getFullName(Name passedName) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(passedName.getTitle());
        stringBuilder.append(SPACE_STRING);
        stringBuilder.append(passedName.getFirst());
        stringBuilder.append(SPACE_STRING);
        stringBuilder.append(passedName.getLast());
        return stringBuilder.toString();
    }

    public static String getLocation(Location location) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(location.getCity());
        stringBuilder.append(SPACE_STRING);
        stringBuilder.append(location.getState());
        stringBuilder.append(SPACE_STRING);
        stringBuilder.append(location.getPostcode());
        return stringBuilder.toString();
    }
}
