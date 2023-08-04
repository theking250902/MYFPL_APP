package com.example.my_app.DTO;

public class DetailpostDTO {
    private boolean status;

        private ListPostResponseDTO.PostResponseDTO data;

    public DetailpostDTO() {
    }

    public DetailpostDTO(boolean status, ListPostResponseDTO.PostResponseDTO data) {
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ListPostResponseDTO.PostResponseDTO getData() {
        return data;
    }

    public void setData(ListPostResponseDTO.PostResponseDTO data) {
        this.data = data;
    }
}
