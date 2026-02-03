// Target Interface
interface MediaPlayer {
    void play(String mediaType);
}

// Adaptee 1
class VlcPlayer {
    void playVlcMedia(String fileName) {
        System.out.println("VLC Player ▶ Playing file: " + fileName);
    }
}

// Adaptee 2
class MxPlayer {
    void playMxMedia(String fileName) {
        System.out.println("MX Player ▶ Playing file: " + fileName);
    }
}

// Adapter
class MediaAdapter implements MediaPlayer {

    private final VlcPlayer vlcPlayer;
    private final MxPlayer mxPlayer;

    MediaAdapter(VlcPlayer vlcPlayer, MxPlayer mxPlayer) {
        this.vlcPlayer = vlcPlayer;
        this.mxPlayer = mxPlayer;
    }

    @Override
    public void play(String mediaType) {
        if ("VLC".equals(mediaType)) {
            vlcPlayer.playVlcMedia("movie.vlc");
        } else if ("MX".equals(mediaType)) {
            mxPlayer.playMxMedia("song.mp3");
        } else {
            System.out.println("Unsupported media type: " + mediaType);
        }
    }
}

// Client
public class Client {
    public static void main(String[] args) {

        System.out.println("=== Adapter Design Pattern Demo ===");

        VlcPlayer vlcPlayer = new VlcPlayer();
        MxPlayer mxPlayer = new MxPlayer();

        MediaPlayer mediaPlayer = new MediaAdapter(vlcPlayer, mxPlayer);

        mediaPlayer.play("VLC");
        mediaPlayer.play("MX");
        mediaPlayer.play("AVI");
    }
}
