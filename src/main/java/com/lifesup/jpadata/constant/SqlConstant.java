package com.lifesup.jpadata.constant;

public class SqlConstant {

    public static final String FIND_ALL_WITH_FILTER =
        "SELECT \n"
            + "     * \n"
            + " FROM test.employee \n"
            + " WHERE "
            + "     :name = '' OR name = :name AND \n"
            + "     :age = -1 OR age = :age AND \n"
            + "     :province = '' OR province = :province \n";

    public static final String COUNT_ALL_WITH_FILTER =
        "SELECT \n"
            + "     count(emp.id) \n"
            + " FROM test.employee emp \n"
            + " WHERE "
            + "     emp.name = :name \n"
            + "     AND emp.age = :age \n"
            + "     AND emp.province = :province \n";
}
