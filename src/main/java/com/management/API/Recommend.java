package com.management.API;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.management.sys.entity.Attributes;
import com.management.sys.entity.Person;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Recommend {
    /**
     * 在给定username的情况下，计算其他用户和它的距离并排序
     * @param username
     * @return
     */
    private Map<Double, String> computeNearestNeighbor(String username, List<Person> users) {
        Map<Double, String> distances = new TreeMap<>();

        Person u1 = new Person(username);
        for (Person user:users) {
            if (username.equals(user.username)) {
                u1 = user;
            }
        }

        for (int i = 0; i < users.size(); i++) {
            Person u2 = users.get(i);

            if (!u2.username.equals(username)) {
                double distance = pearson_dis(u2.AttriList, u1.AttriList);
                distances.put(distance, u2.username);
            }

        }
        System.out.println("Pearson correlation coefficient between this user and other users -> " + distances);
        return distances;
    }


    /**
     * 计算2个打分序列间的pearson距离
     * 选择公式四进行计算
     * @param rating1
     * @param rating2
     * @return
     */
    private double pearson_dis(List<Attributes> rating1, List<Attributes> rating2) {
        int n=rating1.size();
        List<Integer> rating1ScoreCollect = rating1.stream().map(A -> A.score).collect(Collectors.toList());
        List<Integer> rating2ScoreCollect = rating2.stream().map(A -> A.score).collect(Collectors.toList());

        double Ex= rating1ScoreCollect.stream().mapToDouble(x->x).sum();
        double Ey= rating2ScoreCollect.stream().mapToDouble(y->y).sum();
        double Ex2=rating1ScoreCollect.stream().mapToDouble(x->Math.pow(x,2)).sum();
        double Ey2=rating2ScoreCollect.stream().mapToDouble(y->Math.pow(y,2)).sum();
        double Exy= IntStream.range(0,n).mapToDouble(i->rating1ScoreCollect.get(i)*rating2ScoreCollect.get(i)).sum();
        double numerator=Exy-Ex*Ey/n;
        double denominator=Math.sqrt((Ex2-Math.pow(Ex,2)/n)*(Ey2-Math.pow(Ey,2)/n));
        if (denominator==0) return 0.0;
        return numerator/denominator;
    }


    public Person recommend(String username, List<Person> users) {

        Map<Double, String> distances = computeNearestNeighbor(username, users);
        Map.Entry<Double, String> last = new ArrayList<>(distances.entrySet()).get(distances.size()-1);
        String nearest = last.getValue();
        System.out.println("Nearest -> " + nearest);


        Person neighborRatings = new Person();
        for (Person user:users) {
            if (nearest.equals(user.username)) {
                neighborRatings = user;
            }
        }
        System.out.println("Nearest neighbor health attributes -> " + neighborRatings.AttriList);

        Person userRatings = new Person();
        for (Person user:users) {
            if (nearest.equals(user.username)) {
                userRatings = user;
            }
        }
        System.out.println("User health attributes -> " + userRatings.AttriList);


//        List<Attributes> recommendationMovies = new ArrayList<>();
//        for (Attributes movie : neighborRatings.AttriList) {
//            if (userRatings.find(movie.AttriName) == null) {
//                recommendationMovies.add(movie);
//            }
//        }
        //Collections.sort(recommendationMovies);
        return userRatings;
    }

    /**
     * 在一个实体list中，找出属性是key，值为value的实体
     *
     * @param list
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> T getObjectByKeyAndValue(List<T> list, String key){//, String value) {
        if (null == list || list.isEmpty() || StringUtils.isEmpty(key)){// || StringUtils.isEmpty(value)) {
            return null;
        }
        for (T item : list) {
            try {
                // 获取当前类
                Class cls = item.getClass();
                // 获得某个类的所有声明的字段，即包括public、private和proteced，但是不包括父类的申明字段
                Field[] fields = cls.getDeclaredFields();
                for (int i = 0; i < fields.length; i++) {
                    Field f = fields[i];
                    // 当未设置Field的setAccessible方法为true时，会在调用的时候进行访问安全检查，会抛出IllegalAccessException异常
                    f.setAccessible(true);
                    // 获取字段的名称
                    String name = f.getName();
                    // 如果key相等
                    if (key.equals(name)) {
                        // 如果值相等
                        //if (f.get(item).equals(value)) {
                            // 返回对应的类，结束循环
                            return item;
                        //}
                        // 否则直接结束当前循环
                        //else {
                        //    break;
                        //}
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
