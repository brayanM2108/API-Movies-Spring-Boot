package com.melo_play.infrastructure.persistence.mapper;

import com.melo_play.domain.Status;
import org.mapstruct.Named;

public class StatusMapper {

    @Named( "statusToString")
    public static String statusToString(Status status) {
        if (status == null) return null;

        return switch (status) {
            case ACTIVE -> "A";
            case INACTIVE -> "I";
            case UPCOMING_RELEASE -> "P";
            default -> null;
        };
    }

    @Named( "stringToStatus")
    public static Status stringToStatus(String status) {
        if (status == null) return null;

        return switch (status){
            case "A" -> Status.ACTIVE;
            case "I" -> Status.INACTIVE;
            case "P" -> Status.UPCOMING_RELEASE;
            default -> null;
        };
    }
}
