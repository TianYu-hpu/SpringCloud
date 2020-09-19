package cn.com.zenmaster.entity.vo;

public class MoviePageVo {

    private Integer pageNum;
    private Integer pageSize;
    private String name;
    private String actor;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "MoviePageVo{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                '}';
    }
}
