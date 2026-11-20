public class Results {
    // Guarda los datos de el resultado
    private String name;
    private long duration;
    private String sample;

    public Results() {
    }

    public Results(String name, long duration, String sample) {
        this.name = name;
        this.duration = duration;
        this.sample = sample;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public double getMilisegundos() {
        return duration / 1_000_000.0;
    }

    @Override
    public String toString() {
        double milisegundos = getMilisegundos();
        double segundos = duration / 1_000_000_000.0;

        return "Results [" + name + ", duration=" + duration + "ns, " + milisegundos + "ms, " + segundos + "s, sample=" + sample + "]";
    }
}