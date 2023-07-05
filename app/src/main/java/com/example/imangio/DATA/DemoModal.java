package com.example.imangio.DATA;




import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

public class DemoModal implements Serializable {
    private Data data;

    private Boolean success;

    public Data getData() {
        return this.data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static class Data implements Serializable {
        private List<Memes> memes;

        public List<Memes> getMemes() {
            return this.memes;
        }

        public void setMemes(List<Memes> memes) {
            this.memes = memes;
        }

        public static class Memes implements Serializable {
            private String name;

            private Integer width;

            private String id;

            private String url;

            private Integer captions;

            private Integer height;

            private Integer box_count;

            public String getName() {
                return this.name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public Integer getWidth() {
                return this.width;
            }

            public void setWidth(Integer width) {
                this.width = width;
            }

            public String getId() {
                return this.id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUrl() {
                return this.url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public Integer getCaptions() {
                return this.captions;
            }

            public void setCaptions(Integer captions) {
                this.captions = captions;
            }

            public Integer getHeight() {
                return this.height;
            }

            public void setHeight(Integer height) {
                this.height = height;
            }

            public Integer getBox_count() {
                return this.box_count;
            }

            public void setBox_count(Integer box_count) {
                this.box_count = box_count;
            }
        }
    }
}

