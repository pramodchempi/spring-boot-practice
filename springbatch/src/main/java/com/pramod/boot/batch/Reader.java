package com.pramod.boot.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {

    public String[] courses = {"Java Web services","End to End course","Angular"};
    private int count;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        System.out.println("value of count is :" +count);
        System.out.println("Inside Read Method ");
        if(count<courses.length) {
            return courses[count++];
        } else {
            count = 0;
        }
        return null;
    }
}
