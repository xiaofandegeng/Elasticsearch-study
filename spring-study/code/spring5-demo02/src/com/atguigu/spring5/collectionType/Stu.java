package com.atguigu.spring5.collectionType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <p>DESC: stu实体类</p>
 * <p>DATE: 2021/5/17</p>
 * <p>VERSION:1.0.0</p>
 * <p>@AUTHOR: liaohongwei</p>
 */
public class Stu {

    private String[] arrs;

    private List<String> lists;

    private Map<String, String> maps;

    private Set<String> sets;

    private List<Course> courseList;

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setArrs(String[] arrs) {
        this.arrs = arrs;
    }

    public void setLists(List<String> lists) {
        this.lists = lists;
    }

    public void setMaps(Map<String, String> maps) {
        this.maps = maps;
    }

    public void setSets(Set<String> sets) {
        this.sets = sets;
    }

    public void add() {
        System.out.println(Arrays.toString(arrs));
        System.out.println(lists);
        System.out.println(maps);
        System.out.println(sets);
        System.out.println(courseList);
    }
}
