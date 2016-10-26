package com.example.wms_erp.model.response;

import java.util.List;

/**
 * Created by Administrator on 2016/10/26.
 */

public class TaotuDetail {

    /**
     * count : 46
     * fcount : 0
     * galleryclass : 3
     * id : 990
     * img : /ext/161025/e1bf044ccef5ce3e4e0b7abe37e5d7a8.jpg
     * list : [{"gallery":990,"id":15189,"src":"/ext/161025/e1bf044ccef5ce3e4e0b7abe37e5d7a8.jpg"},{"gallery":990,"id":15190,"src":"/ext/161025/c714138d21d0d5ab3111f7855e976a83.jpg"},{"gallery":990,"id":15191,"src":"/ext/161025/90ab4ab52785dd196facee396a5e5ec2.jpg"},{"gallery":990,"id":15192,"src":"/ext/161025/657b8cbba505be18fe7c2080025375c8.jpg"},{"gallery":990,"id":15193,"src":"/ext/161025/6192cd5d84994817a58df69019fb99a8.jpg"},{"gallery":990,"id":15194,"src":"/ext/161025/525dee493058a36ec7ec26a4cb1dd13f.jpg"},{"gallery":990,"id":15195,"src":"/ext/161025/8e58db80d0d509385d57d1024c1e5768.jpg"},{"gallery":990,"id":15196,"src":"/ext/161025/5a9a17c2a0a9e9030b6526a2d8db8b44.jpg"},{"gallery":990,"id":15197,"src":"/ext/161025/6e30e5f48b15232e2ae07283f5d7db06.jpg"}]
     * rcount : 0
     * size : 9
     * status : true
     * time : 1477400547000
     * title : 大长腿美女性感蕾丝裙黑丝高跟美腿
     * url : http://www.tngou.net/tnfs/show/990
     */

    private int count;
    private int fcount;
    private int galleryclass;
    private int id;
    private String img;
    private int rcount;
    private int size;
    private boolean status;
    private long time;
    private String title;
    private String url;
    /**
     * gallery : 990
     * id : 15189
     * src : /ext/161025/e1bf044ccef5ce3e4e0b7abe37e5d7a8.jpg
     */

    private List<ListBean> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getFcount() {
        return fcount;
    }

    public void setFcount(int fcount) {
        this.fcount = fcount;
    }

    public int getGalleryclass() {
        return galleryclass;
    }

    public void setGalleryclass(int galleryclass) {
        this.galleryclass = galleryclass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getRcount() {
        return rcount;
    }

    public void setRcount(int rcount) {
        this.rcount = rcount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private int gallery;
        private int id;
        private String src;

        public int getGallery() {
            return gallery;
        }

        public void setGallery(int gallery) {
            this.gallery = gallery;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }
    }
}
