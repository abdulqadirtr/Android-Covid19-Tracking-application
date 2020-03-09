package app.easylink.coronavirus.ImageSliderActivity;

public class Model {

    private int image;
    private String title;
    private String desc;
    private int imageDetail;

    public Model(int image, int imageDetail, String title, String desc) {
        this.image = image;
        this.imageDetail = imageDetail;
        this.title = title;
        this.desc = desc;
    }

    public int getImageDetail() {
        return imageDetail;
    }

    public void setImageDetail(int imageDetail) {
        this.imageDetail = imageDetail;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
