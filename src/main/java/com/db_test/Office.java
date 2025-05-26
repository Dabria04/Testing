package com.db_test;

public class Office {
    private int OfficeCode;
    private String State;
    private String City;
    public Office(int officeCode, String state, String city) {
        OfficeCode = officeCode;
        State = state;
        City = city;
    }
    public int getOfficeCode() {
        return OfficeCode;
    }

    public String getState() {
        return State;
    }

    public String getCity() {
        return City;
    }

    @Override
    public String toString() {
        return "Office{" +
                "OfficeCode=" + OfficeCode +
                ", State='" + State + '\'' +
                ", City='" + City + '\'' +
                '}';
    }
}

