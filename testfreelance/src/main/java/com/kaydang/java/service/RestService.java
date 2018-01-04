package com.kaydang.java.service;

import com.kaydang.java.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class RestService {

    @Autowired
    private CategoryRepo categoryRepo;

    public Map<String, Long> getCategories() {
        List<String> list1 = categoryRepo.getCategories();
        List<String> list2 = new ArrayList<>();

        for (String s : list1){
            list2.addAll(convertToListString(s));
        }

        Map<String, Long> counts = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts;
    }

    public Map<String, Long> getSpecialties() {
        List<String> list1 = categoryRepo.getSpecialties();
        List<String> list2 = new ArrayList<>();

        for (String s : list1){
            list2.addAll(convertToListString(s));
        }

        Map<String, Long> counts = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts;
    }

    public Map<String, Long> getApplicationNames() {
        List<String> list1 = categoryRepo.getApplicationNames();
        List<String> list2 = new ArrayList<>();

        for (String s : list1){
            list2.addAll(convertToListString(s));
        }

        Map<String, Long> counts = list2.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return counts;
    }

    private List<String> convertToListString(String str){
        return Arrays.asList(str.split(","));
    }
}
