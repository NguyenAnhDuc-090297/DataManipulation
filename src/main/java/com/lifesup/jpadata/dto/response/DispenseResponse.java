package com.lifesup.jpadata.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DispenseResponse {

    private Integer count50;
    private Integer count20;
    private Integer count10;

    public DispenseResponse() {
        count50 = 0;
        count20 = 0;
        count10 = 0;
    }

    public void increment50Count(Integer num) {
        this.count50 += num;
    }

    public void increment20Count(Integer num) {
        this.count20 += num;
    }

    public void increment10Count(Integer num) {
        this.count10 += num;
    }
}
