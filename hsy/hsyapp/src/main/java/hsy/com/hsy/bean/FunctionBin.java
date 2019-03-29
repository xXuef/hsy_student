package hsy.com.hsy.bean;

import de.hdodenhof.circleimageview.CircleImageView;

public class FunctionBin {
    CircleImageView img;
    String text;

    public FunctionBin(CircleImageView img, String text) {
        this.img = img;
        this.text = text;
    }

    public CircleImageView getImg() {
        return img;
    }

    public void setImg(CircleImageView img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
