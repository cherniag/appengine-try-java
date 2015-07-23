package myapp;

import java.util.Date;

/**
 * Author: Gennadii Cherniaiev
 * Date: 7/23/2015
 */
public class Batch {
    Long id;
    String name;
    Long generateCodesCount;
    Date createDate;
    Date startDate;
    Date endDate;
    String owner;


    public Batch(Long id, String name, Long generateCodesCount, Date createDate, Date startDate, Date endDate, String owner) {
        this.id = id;
        this.name = name;
        this.generateCodesCount = generateCodesCount;
        this.createDate = createDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.owner = owner;
    }
}
