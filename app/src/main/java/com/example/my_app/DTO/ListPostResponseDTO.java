package com.example.my_app.DTO;

import java.util.List;

public class ListPostResponseDTO {

    private boolean status;

    private List<PostResponseDTO> data;

    public ListPostResponseDTO() {
    }

    public ListPostResponseDTO(boolean status, List<PostResponseDTO> posts) {
        this.status = status;
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<PostResponseDTO> getPosts() {
        return data;
    }

    public void setPosts(List<PostResponseDTO> posts) {
        this.data = posts;
    }

    public class PostResponseDTO{

        private int id;
        private String title;
        private String created_at;
        private String content;

        public PostResponseDTO() {
        }

        public PostResponseDTO(int id, String title, String created_at, String content) {
            this.id = id;
            this.title = title;
            this.created_at = created_at;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
