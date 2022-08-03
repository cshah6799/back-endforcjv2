package com.cjv805.DigitalVideoStore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Movie")
public class Movie {

    @Id
    private String _id;
    private String id;
    private String Title;
    private String Year;
    private String Runtime;
    private String Genre;
    private String Director;
    private String Plot;
    private String Poster;
    private String LargePoster;
    private String imdbID;
    private String Rent;
    private String Buy;

    public Movie() {
    }

    public Movie(String _id, String id, String title, String year, String runtime, String genre, String director, String plot, String poster, String largePoster, String imdbID, String rent, String buy) {
        this._id = _id;
        this.id = id;
        Title = title;
        Year = year;
        Runtime = runtime;
        Genre = genre;
        Director = director;
        Plot = plot;
        Poster = poster;
        LargePoster = largePoster;
        this.imdbID = imdbID;
        Rent = rent;
        Buy = buy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRuntime() {
        return Runtime;
    }

    public void setRuntime(String runtime) {
        Runtime = runtime;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getLargePoster() {
        return LargePoster;
    }

    public void setLargePoster(String largePoster) {
        LargePoster = largePoster;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getRent() {
        return Rent;
    }

    public void setRent(String rent) {
        Rent = rent;
    }

    public String getBuy() {
        return Buy;
    }

    public void setBuy(String buy) {
        Buy = buy;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "_id='" + _id + '\'' +
                ", id='" + id + '\'' +
                ", Title='" + Title + '\'' +
                ", Year='" + Year + '\'' +
                ", Runtime='" + Runtime + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Director='" + Director + '\'' +
                ", Plot='" + Plot + '\'' +
                ", Poster='" + Poster + '\'' +
                ", LargePoster='" + LargePoster + '\'' +
                ", imdbID='" + imdbID + '\'' +
                ", Rent='" + Rent + '\'' +
                ", Buy='" + Buy + '\'' +
                '}';
    }
}
