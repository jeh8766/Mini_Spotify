package entities;

public class Midias extends Catalogo {
    private String titulo;
    private String artista;
    private double duracao;
    private String genero;

    public Midias(String titulo, String artista, double duracao, String genero) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracao = duracao;
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public double getDuracao() {
        return duracao;
    }

    public void setDuracao(double duracao) {
        this.duracao = duracao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String toString() {
        return "Titulo: " + titulo + " Artista: " + artista + " Duração: " + duracao + " Minutos " + " Genero: " + genero;
    }
}
