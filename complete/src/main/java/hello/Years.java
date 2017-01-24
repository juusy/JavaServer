package hello;

import org.json.JSONObject;

/**
 * Created by Пользователь on 24.01.2017.
 */
public class Years {
    private final String this_year;
    private final String last_year;
    private final String year_before_last;

    public Years(String this_year, String last_year, String year_before_last){
        this.this_year = this_year;
        this.last_year = last_year;
        this.year_before_last = year_before_last;
    }

    public String getThis_year(){return this_year;}
    public String getLast_year() {return last_year;}
    public String getYear_before_last() {return year_before_last;}

   // public void setThis_year(String new_year) {this.this_year = new_year;}
}
