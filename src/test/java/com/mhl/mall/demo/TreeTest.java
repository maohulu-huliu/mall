package com.mhl.mall.demo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author huLiu
 * @date 2021/11/17 17:13
 */
public class TreeTest {
    public static void main(String[] args) {
        Person first = new Person("1", "0", "1级");
        Person second = new Person("2", "1", "2级");
        Person third = new Person("3", "2", "3级");
        Person fourth = new Person("4", "3", "4级");
        Person fifth = new Person("5", "4", "5级");
        Person second2 = new Person("2.1", "1", "一级");
        Person third2 = new Person("3.1", "2.1", "一级");
        Person fourth2 = new Person("4.1", "3.1", "一级");
        Person fifth2 = new Person("5.1", "4.1", "一级");

        List<Person> queryFromDbList = Arrays.asList(first, second, third, fourth, fifth, second2, third2, fourth2, fifth2);
        Map<String, Person> map = queryFromDbList.stream().collect(Collectors.toMap(Person::getId, it -> it));
        HashMap<String, Person> treeMap = new HashMap<>();

        for (Person person : queryFromDbList) {
            if (map.containsKey(person.getPid())) {
                Person parentPerson = map.get(person.getPid());
                parentPerson.getChildList().add(person);
                treeMap.put(parentPerson.getPid(), parentPerson);
            }
        }
    }
}
