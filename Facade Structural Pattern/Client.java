// -------- Subsystem 1 --------
class PowerSystem {
    public void turnOn() {
        System.out.println("Power System is ON");
    }
}

// -------- Subsystem 2 --------
class SoundSystem {
    public void turnOn() {
        System.out.println("Sound System is ON");
    }

    public void setVolume(int volume) {
        System.out.println("Volume set to " + volume + "%");
    }
}

// -------- Subsystem 3 --------
class MusicSource {
    private String sourceName;

    public MusicSource(String sourceName) {
        this.sourceName = sourceName;
    }

    public void play(String songName) {
        System.out.println("Playing \"" + songName + "\" from " + sourceName);
    }
}

// -------- Facade --------
class MusicPlayerFacade {

    private PowerSystem powerSystem;
    private SoundSystem soundSystem;
    private MusicSource musicSource;

    public MusicPlayerFacade(
            PowerSystem powerSystem,
            SoundSystem soundSystem,
            MusicSource musicSource
    ) {
        this.powerSystem = powerSystem;
        this.soundSystem = soundSystem;
        this.musicSource = musicSource;
    }

    public void listenMusic(String songName) {
        powerSystem.turnOn();
        soundSystem.turnOn();
        soundSystem.setVolume(40);
        musicSource.play(songName);
    }
}

// -------- Client (ONLY public class) --------
public class Client {

    public static void main(String[] args) {

	System.out.println("=== Welcome to Facade Design Pattern Demo ===");
        PowerSystem powerSystem = new PowerSystem();
        SoundSystem soundSystem = new SoundSystem();
        MusicSource musicSource = new MusicSource("YouTube Music");

        MusicPlayerFacade facade =
                new MusicPlayerFacade(powerSystem, soundSystem, musicSource);

        facade.listenMusic("Pal");
    }
}
