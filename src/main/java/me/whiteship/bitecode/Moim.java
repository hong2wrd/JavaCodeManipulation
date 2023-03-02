package me.whiteship.bitecode;

public class Moim {

    int maxNumberOfAttendees;
    int numberEnrollment;

    public boolean isEnrollmentFull() {
        if (maxNumberOfAttendees == 0) {
            return false;
        }

        if (numberEnrollment < maxNumberOfAttendees) {
            return false;
        }

        return true;
    }
}
