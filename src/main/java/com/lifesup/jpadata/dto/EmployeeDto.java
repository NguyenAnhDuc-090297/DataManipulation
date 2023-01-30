package com.lifesup.jpadata.dto;

import java.util.List;
import com.lifesup.jpadata.common.CustomSort;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {

    private String name;
    private Integer age;
    private String province;
    private List<CustomSort> sort;
    private Integer pageNo;
    private Integer pageSize;
}
