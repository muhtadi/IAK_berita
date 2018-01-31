package com.example.muhtadi.berita;

/**
 * Created by Muhtadi on 31/01/2018.
 */

public class Sport {

    //init variable
    private String title;
    private String info;
    private final int image;
    private String desc;

    public String getTitle() {
        return title;
    }

//    public void setTitle(String title) {
//        this.title = title;
//    }

    public String getInfo() {
        return info;
    }

//    public void setInfo(String info) {
//        this.info = info;
//    }

    public int getImage() {
        return image;
    }

//    public void setImage(Integer image) {
//        this.image = image;
//    }

    public String getDesc() {
        return desc;
    }

//    public void setDesc(String desc) {
//        this.desc = desc;
//    }

    Sport(String ntitle, String ninfo, Integer nimage, String ndesc){
        this.title = ntitle;
        this.info = ninfo;
        this.image = nimage;
        this.desc = ndesc;
    }


}



























//public class Sport {
//    //Member variables representing the title and information about the sport
//    private String title;
//    private String info;
//    private final int imageResource;
//    private String mdescription;
//
//    /**
//     * Constructor for the Sport data model
//     * @param title the name if the sport
//     * @param info information about the sport
//     */
//    Sport(String title, String info, int imageResource, String description){
//        this.title = title;
//        this.info = info;
//        this.imageResource = imageResource;
//        this.mdescription= description;
//    }
//
//    /**
//     * Gets the title of the sport
//     * @return The title of the sport.
//     */
//    String getTitle(){
//        return title;
//    }
//
//    /**
//     * Gets the info about the sport
//     * @return The info about the sport.
//     */
//    String getInfo(){
//        return info;
//    }
//
//    /**
//     *
//     * @return
//     */
//    public int getImageResource(){
//        return imageResource;
//    }
//
//    /**
//     * Get desc of the sport
//     * @return
//     */
//    String getDescription(){
//        return mdescription;
//    }
//}