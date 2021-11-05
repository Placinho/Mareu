package com.example.mareu.DI;

import com.example.mareu.service.DummyMeetingApiService;
import com.example.mareu.service.MeetApiService;

public class DI {

    private static final MeetApiService service = (MeetApiService) new DummyMeetingApiService();

    /**
     * Get an instance on @{@link MeetApiService}
     * @return
     */
    public static MeetApiService getMeetApiService() {
        return service;
    }

    /**
     * Get always a new instance on @{@link MeetApiService}. Useful for tests, so we ensure the context is clean.
     * @return
     */
    public static MeetApiService getNewInstanceApiService() {
        return (MeetApiService) new DummyMeetingApiService();
    }
}