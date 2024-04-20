package com.example.musicapp;

public class InstanceHolder {
    static android.media.MediaPlayer instance;
    public static android.media.MediaPlayer getInstance(){
       if(instance==null){
           instance=new android.media.MediaPlayer();
       }
       return instance;
    }

    public static int currIndex=-1;
    //indikator pesnata ne e kliknata
}
