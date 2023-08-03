package com.example.my_app.DTO;

import java.util.List;

public class ApiResponse<Schedule> {
    private boolean status;
    private List<Schedule> data;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Schedule> getData() {
        return data;
    }

    public void setData(List<Schedule> data) {
        this.data = data;
    }
}
