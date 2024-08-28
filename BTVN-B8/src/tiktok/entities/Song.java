package tiktok.entities;

public class Song extends Base{
    private String singer;

    public Song(int id, String name) {
        super(id, name);
    }

    public Song(int id, String name, String singer) {
        super(id, name);
        this.singer = singer;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Id : "+getId()+" name: "+getName()+" singger: "+getSinger();
    }
}
