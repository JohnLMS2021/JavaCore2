package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecasts {
    private String date;
    @JsonProperty("parts")
    private Parts parts;

    public void setParts(Parts parts) {
        this.parts = parts;
    }

    public Parts getParts() {
        return parts;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }
    public String toString() {
        return "Forecasts{"
                + "date='" + date + + '}' + '\'';
    }


}
