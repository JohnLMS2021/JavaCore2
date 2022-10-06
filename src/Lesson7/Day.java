package Lesson7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Day {
    @JsonProperty("temp_avg")
    private Integer temp;
    @JsonProperty("condition")
    private String condition;

    public void setTemp(Integer temp) {
        this.temp = temp;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getTemp() {
        return temp;
    }

    public String getCondition() {
        return condition;
    }
}
