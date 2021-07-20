package com.model;

public class Post {

    private String titulo;
    private String texto;
    private String email;

    public Post() {

    }

    public Post(String titulo, String texto, String email) {
        this.titulo = titulo;
        this.texto = texto;
        this.email = email;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Post{" +
                "titulo='" + titulo + '\'' +
                ", texto='" + texto + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
