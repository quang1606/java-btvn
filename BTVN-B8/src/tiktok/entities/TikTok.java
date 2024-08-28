package tiktok.entities;

import java.util.List;

public class TikTok {
    private List<Idol>idols;
    private List<Song>songs;

    public TikTok() {
    }

    public TikTok(List<Idol> idols, List<Song> songs) {
        this.idols = idols;
        this.songs = songs;
    }


    @Override
    public String toString() {
        return "TikTok{" +
                "idols=" + idols +
                ", songs=" + songs +
                '}';
    }
}
