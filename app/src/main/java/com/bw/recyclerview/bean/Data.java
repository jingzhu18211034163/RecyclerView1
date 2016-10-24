package com.bw.recyclerview.bean;

import java.util.List;

/**
 * Created by asus on 2016/10/24.
 */
public class Data {
    @Override
    public String toString() {
        return "Data{" +
                "data=" + data +
                ", info='" + info + '\'' +
                ", ra_referer='" + ra_referer + '\'' +
                ", status=" + status +
                ", times=" + times +
                '}';
    }

    public DataEntity data;
    public String info;
    public String ra_referer;
    public int status;
    public int times;

    public static class DataEntity {

        public CountsEntity counts;
        public List<ForumListEntity> forum_list;

        @Override
        public String toString() {
            return "DataEntity{" +
                    "counts=" + counts +
                    ", forum_list=" + forum_list +
                    '}';
        }

        public static class CountsEntity {

            public int ask;
            public int company;
        }

        public static class ForumListEntity {


            public int id;
            public String name;
            public List<GroupEntity> group;

            public static class GroupEntity {

                public int id;
                public String name;
                public String photo;
                public String total_threads;
                public List<TypesEntity> types;

                public boolean hasTitle=false;
                public String title=null;

                public void setHasTitle(boolean hasTitle,String title) {
                    this.hasTitle = hasTitle;
                    this.title=title;
                }

                public static class TypesEntity {

                    public int id;
                    public String name;
                }
            }
        }
    }
}
