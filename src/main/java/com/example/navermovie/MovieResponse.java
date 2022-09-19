package com.example.navermovie;

import com.fasterxml.jackson.databind.util.JSONPObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse implements Serializable{

    Integer total;

    Integer start;

    List<Item> items = new ArrayList<>();

    @Data
    static class Item {
        private String title;

        private String link;

        private String subtitle;

        private String director;

        private String actor;

        private String userRating;
    }

}
